package Backend;
import LLVMIR.IRBasicBlock;
import LLVMIR.IRFunction;
import LLVMIR.IRModule;
import LLVMIR.Instr.*;
import LLVMIR.Instr.Branch;
import LLVMIR.Instr.Call;
import LLVMIR.Instr.Jump;
import LLVMIR.Instr.Load;
import LLVMIR.Instr.Store;
import LLVMIR.Operand.*;
import LLVMIR.Type.IRType;
import LLVMIR.Type.IntegerType;
import LLVMIR.Type.PointerType;
import RISCV.*;
import RISCV.Inst.*;
import RISCV.Operand.PhysicalReg;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AsmBuilder implements IRInterface{
    asmmodule root = new asmmodule();
    public LinkedHashMap<String , PhysicalReg> regs = new LinkedHashMap<>();

    public ArrayList<String> RegsName = new ArrayList<>(Arrays.asList(
            "zero","ra","sp","gp","tp","t0","t1","t2","s0","s1","a0","a1","a2","a3","a4","a5","a6","a7",
            "s2","s3","s4","s5","s6","s7","s8","s9","s10","s11","t3","t4","t5","t6"
    ));
    public String[] sRegs = {
            "s0","s1","s2","s3","s4","s5","s6","s7","s8","s9","s10","s11"
    };
    public String[] aRegs = {
            "a0","a1","a2","a3","a4","a5","a6","a7"
    };

    asmFunction curfunc = null;
    asmBlock curBlock = null;
    IRBasicBlock irtmpBlock = null;
    HashMap<Integer , Integer> block_label_Map = new HashMap<>();
    HashMap<Integer , asmBlock> blockMap = new HashMap<>();
    LinkedHashMap<Integer , Long> addrMap = new LinkedHashMap<>();

    long regReserve = 0;
    long spOffset = 0;

    public AsmBuilder(){
        for (String regName : RegsName)regs.put(regName , new PhysicalReg(regName));
    }

    public asmmodule getRoot(){
        return root;
    }


    @Override
    public void visit(IRModule node) {
        root.nameTable.addAll(node.staticDataName);
        for (Pair<String , VirtualReg> pair : node.asmStrings)
            root.dataTable.add(new Pair<>(pair.b.name , pair.a));
        for (String name : node.customFunctionName)
            node.customFunctions.get(name).accept(this);
    }

    @Override
    public void visit(IRFunction node) {
        curfunc = new asmFunction(node.name);
        curBlock = null;
        addrMap = new LinkedHashMap<>();
        for (IRBasicBlock block : node.blockList){
            if (curBlock != null){
                curBlock = new asmBlock(curfunc , node.name , curfunc.takeLabel());
            }else {
                curBlock = curfunc.getEntry();
                funcAllocate(node);
            }
            int indexnow = node.blockList.indexOf(block);
            if (indexnow < node.blockList.size() - 1) irtmpBlock = node.blockList.get(indexnow + 1);
            else irtmpBlock = null;
            block.accept(this);
            blockMap.put(curBlock.label , curBlock);
        }
        root.funcTable.add(new Pair<>(node.name , curfunc));
        curBlock = null;
        curfunc = null;
    }

    @Override
    public void visit(IRBasicBlock node) {
        for (IRInstr inst : node.instrs){
            inst.accept(this);
        }
    }

    @Override
    public void visit(Alloc node) {
        curfunc.StackAlloc(node.allocReg);
        spaceAllocate(node.allocReg);
    }

    @Override
    public void visit(Binary node) {
        PhysicalReg rs1 = get_tmp_sReg();
        PhysicalReg rs2 = get_tmp_sReg();
        PhysicalReg rd = get_tmp_sReg();
        getReg(rs1 , node.rs1);
        getReg(rs2 , node.rs2);
        RegBinary.Op op = getRegBinaryOp(node.op);
        curBlock.append(new RegBinary(op , rd , rs1 , rs2));
        spaceAllocate(node.result);
        saveRegs_v_p(rd , node.result);
        rs1.free();
        rs2.free();
        rd.free();
    }

    @Override
    public void visit(Bitcast node) {
        PhysicalReg reg = get_tmp_sReg();
        if (node.srcReg.name != null) curBlock.append(new LoadAddr(reg , node.srcReg.name));
        else getReg(reg , node.srcReg);
        spaceAllocate(node.destReg);
        saveRegs_v_p(reg , node.destReg);
        reg.free();
    }

    @Override
    public void visit(Branch node) {
        RISCV.Inst.Branch.Op op = irtmpBlock == node.thenBlock ? RISCV.Inst.Branch.Op.beqz : RISCV.Inst.Branch.Op.bnez;
        int target = irtmpBlock == node.thenBlock ? node.elseBlock.label : node.thenBlock.label;
        int asm_block_Label = block_label_Map.get(target);
        PhysicalReg rs1 = get_tmp_sReg();
        getReg(rs1 , node.cond);
        curBlock.append(new RISCV.Inst.Branch(op , rs1 , null , "." + curfunc.name + "_" + asm_block_Label));
        rs1.free();
    }

    @Override
    public void visit(Call node) {
        IRConstant parameter;
        PhysicalReg reg;
        long spiltOffset;
        for (int i = 0; i < node.in_args.size();++i){
            parameter = node.in_args.get(i);

//            if (i < 8){
//                reg = rege(aRegs[i]);
//                getReg(reg , parameter);
//            }
//            else {
            PhysicalReg offsetReg = get_tmp_sReg();
            PhysicalReg addrReg = get_tmp_sReg();
            //spiltOffset = (node.in_args.size() - 1 - i) * 4L;
            spiltOffset = i * 4L;
            reg = get_tmp_sReg();
            getReg(reg , parameter);
            curBlock.append(new LoadImm(offsetReg , spiltOffset));
            curBlock.append(new RegBinary(RegBinary.Op.add , addrReg , rege("sp") , offsetReg));
            curBlock.append(new RISCV.Inst.Store(StepWidth.word , reg , addrReg , 0L));
            reg.free();
            offsetReg.free();
            addrReg.free();
//            }

        }
        curBlock.append(new RISCV.Inst.Call(node.func.name));
        if (node.allocReg != null){
            spaceAllocate(node.allocReg);
            saveRegs_v_p(regs.get("a0") , node.allocReg);
        }
    }

    @Override
    public void visit(Gep node) {
        if (!(node.indexSrc instanceof VirtualReg))throw new RuntimeException("constant call gep");
        PhysicalReg result = get_tmp_sReg();
        PhysicalReg baseAddr = get_tmp_sReg();
        PhysicalReg reg1 = get_tmp_sReg();
        PhysicalReg offsetReg = get_tmp_sReg();
        IRConstant offset = node.indexOffsets.get(node.indexOffsets.size() - 1);
        getReg(baseAddr , node.indexSrc);
        if (offset instanceof IntConstant){
            long value = ((IntConstant)offset).value;
            long gepOffset = value * 4;
            IRType refType = ((PointerType)node.indexSrc.type).dePointed();
            if (refType instanceof IntegerType && ((IntegerType) refType).width == 8)gepOffset = value;
            curBlock.append(new LoadImm(reg1 , gepOffset));
            curBlock.append(new RegBinary(RegBinary.Op.add , result ,baseAddr , reg1));
        }else {
            getReg(reg1, offset);
            curBlock.append(new ImmBinary(ImmBinary.Op.slli, offsetReg, reg1, 2L));
            curBlock.append(new RegBinary(RegBinary.Op.add, result, baseAddr, offsetReg));
        }
        spaceAllocate(node.resultReg);
        saveRegs_v_p(result , node.resultReg);
        result.free();
        baseAddr.free();
        reg1.free();
        offsetReg.free();
    }

    @Override
    public void visit(Icmp node) {
        PhysicalReg reg1 = get_tmp_sReg();
        PhysicalReg reg2 = get_tmp_sReg();
        PhysicalReg reg3 = get_tmp_sReg();
        PhysicalReg reg4 = get_tmp_sReg();
        PhysicalReg result = get_tmp_sReg();
        getReg(reg1 , node.rs1);
        getReg(reg2 , node.rs2);
        curBlock.append(new RegBinary(RegBinary.Op.sub , reg3 , reg1 , reg2));
        if (node.op == Icmp.CmpOp.eq){
            curBlock.append(new Unary(Unary.Op.seqz , result , reg3));
        } else if (node.op == Icmp.CmpOp.ne){
            curBlock.append(new Unary(Unary.Op.snez , result , reg3));
        } else if (node.op == Icmp.CmpOp.sgt){
            curBlock.append(new Unary(Unary.Op.sgtz , result , reg3));
        } else if (node.op == Icmp.CmpOp.slt){
            curBlock.append(new Unary(Unary.Op.sltz , result , reg3));
        } else if (node.op == Icmp.CmpOp.sge){
            curBlock.append(new Unary(Unary.Op.sltz , reg4 , reg3));
            curBlock.append(new Unary(Unary.Op.seqz , result , reg4));
        } else if (node.op == Icmp.CmpOp.sle){
            curBlock.append(new Unary(Unary.Op.sgtz , reg4 , reg3));
            curBlock.append(new Unary(Unary.Op.seqz , result , reg4));
        }

        spaceAllocate(node.resultReg);
        saveRegs_v_p(result , node.resultReg);
        reg1.free();
        reg2.free();
        reg3.free();
        reg4.free();
        result.free();
    }

    @Override
    public void visit(Jump node) {
        int asmLabel = block_label_Map.get(node.dest.label);
        curBlock.append(new RISCV.Inst.Jump("." + curfunc.name + "_" + asmLabel));
    }

    @Override
    public void visit(Load node) {
        PhysicalReg result = get_tmp_sReg();
        PhysicalReg addr = get_tmp_sReg();
        if (node.addr.name != null){
            curBlock.append(new LoadAddr(addr , node.addr.name));
            curBlock.append(new RISCV.Inst.Load(StepWidth.word , result , addr , 0L));
        }else if (!curfunc.cotainStackVar((VirtualReg) node.addr)){
            getReg(addr , node.addr);
            curBlock.append(new RISCV.Inst.Load(StepWidth.word , result , addr , 0L));
        } else getReg(result , node.addr);
        spaceAllocate(node.resultReg);
        saveRegs_v_p(result , node.resultReg);
        result.free();
        addr.free();
    }

    @Override
    public void visit(Phi node) {
        Integer rootLabel = block_label_Map.get(node.paths.get(0).b);
        Integer alterLabel = block_label_Map.get(node.paths.get(1).b);
        BoolConstant rootValue = (BoolConstant) node.paths.get(0).a;
        VirtualReg alterValue = (VirtualReg) node.paths.get(1).a;
        asmBlock rootBlock = blockMap.get(rootLabel);
        asmBlock alterBlock = blockMap.get(alterLabel);
        if (!(rootBlock.InstTable.getLast() instanceof RISCV.Inst.Branch))throw new RuntimeException("rootblock : branch lost");
        if (!(alterBlock.InstTable.getLast() instanceof RISCV.Inst.Jump))throw new RuntimeException("alterblock : jump lost");
        rootBlock.InstTable.getLast().rs1.use();
        PhysicalReg result = get_tmp_sReg();
        PhysicalReg offset = get_tmp_sReg();
        PhysicalReg addr = get_tmp_sReg();
        LoadImm rootInsert = new LoadImm(result , rootValue.value ? 1L : 0L);
        rootBlock.InstTable.add(rootBlock.InstTable.size() - 1, rootInsert);

        RISCVInst alterInsert0 = new LoadImm(offset , addrMap.get(alterValue.numLabel));
        RISCVInst alterInsert1 = new RegBinary(RegBinary.Op.add , addr , rege("sp") , offset);
        RISCVInst alterInsert2 = new RISCV.Inst.Load(StepWidth.word , result , addr , 0L);
        alterBlock.InstTable.add(alterBlock.InstTable.size() - 1, alterInsert0);
        alterBlock.InstTable.add(alterBlock.InstTable.size() - 1, alterInsert1);
        alterBlock.InstTable.add(alterBlock.InstTable.size() - 1, alterInsert2);
        spaceAllocate(node.resultReg);
        saveRegs_v_p(result , node.resultReg);
        rootBlock.InstTable.getLast().rs1.free();
        result.free();
        offset.free();
        addr.free();
    }

    @Override
    public void visit(Ret node) {
        PhysicalReg a0 = rege("a0");
        if (node.retVal != null)getReg(a0 , node.retVal);

        long i = 2;
        for (String sReg : sRegs){
            curBlock.append(new LoadImm(rege("t0") , spOffset - 4 * i));
            curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("sp") , rege("t0")));
            curBlock.append(new RISCV.Inst.Load(StepWidth.word , regs.get(sReg) , rege("t1") , 0L));
            i++;
        }
        curBlock.append(new LoadImm(rege("t0") , spOffset - 4));
        curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("sp") , rege("t0")));
        curBlock.append(new RISCV.Inst.Load(StepWidth.word , rege("ra") , rege("t1") , 0L));


        curBlock.append(new LoadImm(rege("t0") , spOffset));
        curBlock.append(new RegBinary(RegBinary.Op.add , rege("sp") , rege("sp") , rege("t0")));
        curBlock.append(new Return());
    }

    @Override
    public void visit(Store node) {
        PhysicalReg value = get_tmp_sReg();
        PhysicalReg addr = get_tmp_sReg();
        getReg(value , node.storeVal);
        assert node.storeAddr instanceof VirtualReg;
        if (((VirtualReg)node.storeAddr).name != null){
            curBlock.append(new LoadAddr(addr , node.storeAddr.name));
            curBlock.append(new RISCV.Inst.Store(StepWidth.word , value , addr , 0L));
        }else if (!curfunc.cotainStackVar((VirtualReg) node.storeAddr)){
            getReg(addr , node.storeAddr);
            curBlock.append(new RISCV.Inst.Store(StepWidth.word , value , addr , 0L));
        } else saveRegs_v_p(value , (VirtualReg) node.storeAddr);
        value.free();
        addr.free();
    }

    public PhysicalReg get_tmp_sReg(){
        for (String name : sRegs){
            PhysicalReg tmp = regs.get(name);
            if (!tmp.busy){
                tmp.use();
                return tmp;
            }
        }
        throw new RuntimeException("sregs all busy");
    }

    public void funcAllocate(IRFunction node){
        int blockNum = 0;
        for (IRBasicBlock block : node.blockList){
            block_label_Map.put(block.label , blockNum);
            blockNum++;
        }

        int pReg = 13;
        int inPara = node.args.size();
        int outPara = 50;
        int vReg = node.regCnt - blockNum;
        long number = pReg + vReg + inPara + outPara;
        spOffset = number % 4 == 0 ? 4 * number : 16 * (number / 4 + 1);

        curBlock.append(new LoadImm(regs.get("t0") , -spOffset));
        curBlock.append(new RegBinary(RegBinary.Op.add , regs.get("sp") , regs.get("sp") , regs.get("t0")));

        curBlock.append(new LoadImm(rege("t0") , spOffset-4));
        curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("t0") , rege("sp")));
        curBlock.append(new RISCV.Inst.Store(StepWidth.word , rege("ra") , rege("t1") , 0L));
        int i = 2;
        for (String name : sRegs){
            curBlock.append(new LoadImm(rege("t0") , spOffset - 4L*i));
            curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("sp") , rege("t0")));
            curBlock.append(new RISCV.Inst.Store(StepWidth.word , rege(name) , rege("t1") , 0L));
            i++;
        }
        regReserve = 13;

        for (i = 0; i < node.args.size() ;i++){
            VirtualReg arg = node.args.get(i);
            PhysicalReg tmp;
            spaceAllocate(arg);
//            if (i < 8){
//                tmp = rege(aRegs[i]);
//                saveRegs_v_p(tmp , arg);
//            }
//            else {
            tmp = get_tmp_sReg();
            curBlock.append(new LoadImm(rege("t0") , spOffset + 4L * i));
            curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("sp") , rege("t0")));
            curBlock.append(new RISCV.Inst.Load(StepWidth.word , tmp , rege("t1") , 0L));
            saveRegs_v_p(tmp , arg);
            tmp.free();
//            }
        }
    }

    PhysicalReg rege(String re){
        return regs.get(re);
    }

    void spaceAllocate(VirtualReg reg){
        regReserve++;
        addrMap.put(reg.numLabel , spOffset - regReserve * 4);
    }

    void saveRegs_v_p(PhysicalReg reg , VirtualReg vreg){
        PhysicalReg addr = get_tmp_sReg();
        PhysicalReg offset = get_tmp_sReg();
        curBlock.append(new LoadImm(offset , addrMap.get(vreg.numLabel)));
        curBlock.append(new RegBinary(RegBinary.Op.add , addr , rege("sp") , offset));
        curBlock.append(new RISCV.Inst.Store(StepWidth.word , reg , addr , 0L));
        addr.free();
        offset.free();
    }

    void getReg(PhysicalReg p , IRConstant o){
        if (o instanceof VirtualReg)getReg(p , (VirtualReg) o);
        else if (o instanceof NullConstant)getReg(p);
        else if (o instanceof IntConstant)getReg(p , (IntConstant) o);
        else if (o instanceof BoolConstant)getReg(p , (BoolConstant) o);
        else throw new RuntimeException("getReg no such type");
    }
    void getReg(PhysicalReg p , VirtualReg v){
        PhysicalReg offset = get_tmp_sReg();
        PhysicalReg addr = get_tmp_sReg();
        curBlock.append(new LoadImm(offset , addrMap.get(v.numLabel)));
        curBlock.append(new RegBinary(RegBinary.Op.add , addr , rege("sp") , offset));
        curBlock.append(new RISCV.Inst.Load(StepWidth.word , p , addr , 0L));
        offset.free();
        addr.free();
    }
    void getReg(PhysicalReg p){
        curBlock.append(new Move(p , rege("zero")));
    }
    void getReg(PhysicalReg p , IntConstant i){
        curBlock.append(new LoadImm(p , i.value));
    }
    void getReg(PhysicalReg p , BoolConstant b){
        curBlock.append(new LoadImm(p , b.value ? 1L : 0L));
    }
    RegBinary.Op getRegBinaryOp(Binary.BiOp op){
        switch (op){
            case add : return RegBinary.Op.add;
            case sub : return RegBinary.Op.sub;
            case mul : return RegBinary.Op.mul;
            case sdiv: return RegBinary.Op.div;
            case srem: return RegBinary.Op.rem;
            case shl: return RegBinary.Op.sll;
            case ashr: return RegBinary.Op.sra;
            case and: return RegBinary.Op.and;
            case or: return RegBinary.Op.or;
            case xor: return RegBinary.Op.xor;
        }
        throw new RuntimeException("getBinaryop no such op");
    }
}
