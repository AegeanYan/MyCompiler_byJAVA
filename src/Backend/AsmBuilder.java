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

    public ArrayList<Integer> calleeSaved_color = new ArrayList<>(Arrays.asList(
            9,
            18,19,20,21,22,23,24,25,26,27
    ));

    long reg_reserved = 0;
    long sp_offset = 0;

    asmFunction curfunc = null;
    asmBlock curBlock = null;
    IRBasicBlock ir_nxt_Block = null;

    HashMap<Integer , asmBlock> blockMap = new HashMap<>();
    HashMap<Integer , Integer> block_label_Map = new HashMap<>();
    LinkedHashMap<Integer , Long> addrMap = new LinkedHashMap<>();



    public AsmBuilder(){
        for (String regName : PhysicalReg.RegsName)regs.put(regName , new PhysicalReg(regName));
    }

    public asmmodule getRoot(){
        return root;
    }


    @Override
    public void visit(IRModule node) {
        root.nameTable.addAll(node.staticDataName);
        for (Pair<String , VirtualReg> pair : node.asmStrings)
            root.dataTable.add(new Pair<>(pair.b.name , pair.a));
        for (String name : node.customFunctionName) {
            curfunc = new asmFunction(name);
            curBlock = null;
            addrMap = new LinkedHashMap<>();
            node.customFunctions.get(name).accept(this);
        }
    }

    @Override
    public void visit(IRFunction node) {
        boolean flag = false;
        for (IRBasicBlock block : node.blockList){
            if (flag){
                curBlock = new asmBlock(curfunc , node.name , curfunc.takeLabel());
            }else {
                flag = true;
                curBlock = curfunc.getEntry();
                funcAllocate(node);
            }
            int indexnow = node.blockList.indexOf(block);
            if (indexnow < node.blockList.size() - 1) ir_nxt_Block = node.blockList.get(indexnow + 1);
            else ir_nxt_Block = null;
            block.accept(this);
            blockMap.put(curBlock.label , curBlock);
        }
        root.funcTable.add(new Pair<>(node.name , curfunc));
        curfunc = null;
        curBlock = null;
    }

    public void funcAllocate(IRFunction node){
        int block_Num = 0;
        for (IRBasicBlock block : node.blockList){
            block_label_Map.put(block.label , block_Num);
            block_Num++;
        }

        int re_Regs = 13;
        int inPara = node.args.size();
        int altra = 10;
        int vReg = node.regCnt - block_Num;
        long number = re_Regs + vReg + inPara + altra;
        sp_offset =  4 * number;

        curBlock.append(new LoadImm(regs.get("t0") , -sp_offset));
        curBlock.append(new RegBinary(RegBinary.Op.add , regs.get("sp") , regs.get("sp") , regs.get("t0")));

        curBlock.append(new LoadImm(rege("t0") , sp_offset - 4));
        curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("t0") , rege("sp")));
        curBlock.append(new RISCV.Inst.Store(StepWidth.word , rege("ra") , rege("t1") , 0L));


        int i = 2;
        for (String name : PhysicalReg.sRegs){
            curBlock.append(new LoadImm(rege("t0") , sp_offset - 4L*i));
            curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("sp") , rege("t0")));
            curBlock.append(new RISCV.Inst.Store(StepWidth.word , rege(name) , rege("t1") , 0L));
            i++;
        }
        reg_reserved = 13;

        for (i = 0; i < node.args.size() ;i++){
            VirtualReg arg = node.args.get(i);
            PhysicalReg tmp;
            spaceAllocate(arg);
            if (i < 8){
            tmp = rege(PhysicalReg.aRegs[i]);
            saveRegs_v_p(tmp , arg);
            }
//            else {
//                tmp = get_tmp_sReg();
//                curBlock.append(new LoadImm(rege("t0") , spOffset + 4L * (i - 8)));
//                curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("sp") , rege("t0")));
//                curBlock.append(new RISCV.Inst.Load(StepWidth.word , tmp , rege("t1") , 0L));
//                saveRegs_v_p(tmp , arg);
//                tmp.free();
//            }
        }
    }

    @Override
    public void visit(IRBasicBlock node) {
        node.instrs.forEach(cd -> cd.accept(this));
    }

    @Override
    public void visit(Alloc node) {
        curfunc.StackAlloc(node.allocReg);
        spaceAllocate(node.allocReg);
    }

    @Override
    public void visit(Branch node) {
        RISCV.Inst.Branch.Op op = ir_nxt_Block == node.thenBlock ? RISCV.Inst.Branch.Op.beqz : RISCV.Inst.Branch.Op.bnez;
        int target = ir_nxt_Block == node.thenBlock ? node.elseBlock.label : node.thenBlock.label;
        int asm_block_Label = block_label_Map.get(target);
        PhysicalReg rs1 = get_tmp_sReg();
        getReg(rs1 , node.cond);
        curBlock.append(new RISCV.Inst.Branch(op , rs1 , null , "." + curfunc.name + "_" + asm_block_Label));
        rs1.free();
    }

    @Override
    public void visit(Binary node) {
        PhysicalReg lhs = get_tmp_sReg();
        PhysicalReg rhs = get_tmp_sReg();
        PhysicalReg rd = get_tmp_sReg();
        getReg(lhs , node.rs1);
        getReg(rhs , node.rs2);
        RegBinary.Op op = getRegBinaryOp(node.op);
        curBlock.append(new RegBinary(op , rd , lhs , rhs));
        spaceAllocate(node.result);
        saveRegs_v_p(rd , node.result);
        lhs.free();
        rhs.free();
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
    public void visit(Call node) {
        IRConstant parameter;
        PhysicalReg reg;
        long tmp_Offset;
        for (int i = 0; i < node.in_args.size();++i){
            parameter = node.in_args.get(i);
            if (i < 8){
                reg = rege(PhysicalReg.aRegs[i]);
                getReg(reg , parameter);
            }
//            else {
//            PhysicalReg offsetReg = get_tmp_sReg();//0
//            PhysicalReg addrReg = get_tmp_sReg();//1
//            //tmp_Offset = (node.in_args.size() - 1 - i) * 4L;
//            tmp_Offset = (i - 8) * 4L;
//            reg = get_tmp_sReg();//2
//            getReg(reg , parameter);
//            curBlock.append(new LoadImm(offsetReg , tmp_Offset));
//            curBlock.append(new RegBinary(RegBinary.Op.add , addrReg , rege("sp") , offsetReg));
//            curBlock.append(new RISCV.Inst.Store(StepWidth.word , reg , addrReg , 0L));
//            reg.free();
//            offsetReg.free();
//            addrReg.free();
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
        PhysicalReg tmp_sReg = get_tmp_sReg();
        PhysicalReg offsetReg = get_tmp_sReg();
        IRConstant offset = node.indexOffsets.get(node.indexOffsets.size() - 1);
        getReg(baseAddr , node.indexSrc);
        if (offset instanceof IntConstant){
            long value = ((IntConstant)offset).value;
            long gepOffset = value * 4;
            IRType refType = ((PointerType)node.indexSrc.type).dePointed();
            if (refType instanceof IntegerType && ((IntegerType) refType).width == 8)gepOffset = value;
            curBlock.append(new LoadImm(tmp_sReg , gepOffset));
            curBlock.append(new RegBinary(RegBinary.Op.add , result ,baseAddr , tmp_sReg));
        }else {
            getReg(tmp_sReg, offset);
            curBlock.append(new ImmBinary(ImmBinary.Op.slli, offsetReg, tmp_sReg, 2L));
            curBlock.append(new RegBinary(RegBinary.Op.add, result, baseAddr, offsetReg));
        }
        spaceAllocate(node.resultReg);
        saveRegs_v_p(result , node.resultReg);
        result.free();
        baseAddr.free();
        tmp_sReg.free();
        offsetReg.free();
    }

    @Override
    public void visit(Icmp node) {
        PhysicalReg rs1 = get_tmp_sReg();
        PhysicalReg rs2 = get_tmp_sReg();
        PhysicalReg rs3 = get_tmp_sReg();
        PhysicalReg rs4 = get_tmp_sReg();
        PhysicalReg result = get_tmp_sReg();
        getReg(rs1 , node.rs1);
        getReg(rs2 , node.rs2);
        curBlock.append(new RegBinary(RegBinary.Op.sub , rs3 , rs1 , rs2));
        if (node.op == Icmp.CmpOp.eq){
            curBlock.append(new Unary(Unary.Op.seqz , result , rs3));
        } else if (node.op == Icmp.CmpOp.ne){
            curBlock.append(new Unary(Unary.Op.snez , result , rs3));
        } else if (node.op == Icmp.CmpOp.sgt){
            curBlock.append(new Unary(Unary.Op.sgtz , result , rs3));
        } else if (node.op == Icmp.CmpOp.slt){
            curBlock.append(new Unary(Unary.Op.sltz , result , rs3));
        } else if (node.op == Icmp.CmpOp.sge){
            curBlock.append(new Unary(Unary.Op.sltz , rs4 , rs3));
            curBlock.append(new Unary(Unary.Op.seqz , result , rs4));
        } else if (node.op == Icmp.CmpOp.sle){
            curBlock.append(new Unary(Unary.Op.sgtz , rs4 , rs3));
            curBlock.append(new Unary(Unary.Op.seqz , result , rs4));
        }

        spaceAllocate(node.resultReg);
        saveRegs_v_p(result , node.resultReg);
        rs1.free();
        rs2.free();
        rs3.free();
        rs4.free();
        result.free();
    }

    @Override
    public void visit(Jump node) {
        int asmLabel = block_label_Map.get(node.dest.label);
        curBlock.append(new RISCV.Inst.Jump("." + curfunc.name + "_" + asmLabel));
    }

    @Override
    public void visit(Load node) {
        PhysicalReg result = get_tmp_sReg();//0
        PhysicalReg addr = get_tmp_sReg();//1
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

        RISCVInst Inst1 = new LoadImm(offset , addrMap.get(alterValue.numLabel));
        RISCVInst Inst2 = new RegBinary(RegBinary.Op.add , addr , rege("sp") , offset);
        RISCVInst Inst3 = new RISCV.Inst.Load(StepWidth.word , result , addr , 0L);
        alterBlock.InstTable.add(alterBlock.InstTable.size() - 1, Inst1);
        alterBlock.InstTable.add(alterBlock.InstTable.size() - 1, Inst2);
        alterBlock.InstTable.add(alterBlock.InstTable.size() - 1, Inst3);
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
        for (String sReg : PhysicalReg.sRegs){
            curBlock.append(new LoadImm(rege("t0") , sp_offset - 4 * i));
            curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("sp") , rege("t0")));
            curBlock.append(new RISCV.Inst.Load(StepWidth.word , regs.get(sReg) , rege("t1") , 0L));
            i++;
        }
        curBlock.append(new LoadImm(rege("t0") , sp_offset - 4));
        curBlock.append(new RegBinary(RegBinary.Op.add , rege("t1") , rege("sp") , rege("t0")));
        curBlock.append(new RISCV.Inst.Load(StepWidth.word , rege("ra") , rege("t1") , 0L));


        curBlock.append(new LoadImm(rege("t0") , sp_offset));
        curBlock.append(new RegBinary(RegBinary.Op.add , rege("sp") , rege("sp") , rege("t0")));
        curBlock.append(new Return());
    }

    @Override
    public void visit(Store node) {
        PhysicalReg value = get_tmp_sReg();//0
        PhysicalReg addr = get_tmp_sReg();//1
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
        for (String name : PhysicalReg.sRegs){
            PhysicalReg tmp = regs.get(name);
            if (!tmp.busy){
                tmp.use();
                return tmp;
            }
        }
        throw new RuntimeException("sregs all busy");
    }



    PhysicalReg rege(String re){
        return regs.get(re);
    }

    void spaceAllocate(VirtualReg reg){
        reg_reserved++;
        addrMap.put(reg.numLabel , sp_offset - reg_reserved * 4);
    }

    void saveRegs_v_p(PhysicalReg reg , VirtualReg vreg){
        PhysicalReg addr = get_tmp_sReg();//2
        PhysicalReg offset = get_tmp_sReg();//3
        curBlock.append(new LoadImm(offset , addrMap.get(vreg.numLabel)));
        curBlock.append(new RegBinary(RegBinary.Op.add , addr , rege("sp") , offset));
        curBlock.append(new RISCV.Inst.Store(StepWidth.word , reg , addr , 0L));
        addr.free();
        offset.free();
    }

    void getReg(PhysicalReg p , IRConstant o){
        if (o instanceof VirtualReg) {
            PhysicalReg offset = get_tmp_sReg();//3
            PhysicalReg addr = get_tmp_sReg();//4
            curBlock.append(new LoadImm(offset , addrMap.get(((VirtualReg) o).numLabel)));
            curBlock.append(new RegBinary(RegBinary.Op.add , addr , rege("sp") , offset));
            curBlock.append(new RISCV.Inst.Load(StepWidth.word , p , addr , 0L));
            offset.free();
            addr.free();
        }
        else if (o instanceof NullConstant) {
            curBlock.append(new Move(p , rege("zero")));
        }
        else if (o instanceof IntConstant) {
            curBlock.append(new LoadImm(p , ((IntConstant) o).value));
        }
        else if (o instanceof BoolConstant) {
            curBlock.append(new LoadImm(p , ((BoolConstant) o).value ? 1L : 0L));
        }
        else throw new RuntimeException("getReg no such type");
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
