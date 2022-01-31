package LLVMIR;

import LLVMIR.BasicClass.Value;
import LLVMIR.Instr.Gep;
import LLVMIR.Instr.Load;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.IntConstant;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.PointerType;
import LLVMIR.Type.StructType;

import java.util.ArrayList;
import java.util.HashMap;

public class LLVMScope {
    public LLVMScope parent;
    public HashMap<String , Value> valueTable;
    public HashMap<String , VirtualReg> regTable;
    public StructType classon;

    public LLVMScope(LLVMScope parent){
        this.parent = parent;
        this.valueTable = new HashMap<>();
        this.regTable = new HashMap<>();
    }


    public void addvar_to_table(String id , VirtualReg reg){
        this.regTable.put(id , reg);
    }

    public LLVMScope to_parent(){
        assert this.parent != null;
        return this.parent;
    }

//    public VirtualReg getVarReg(String name , boolean lookUpon){
//        if (regTable.containsKey(name))return regTable.get(name);
//        else if (lookUpon && parent != null) return parent.getVarReg(name , true);
//        else return null;
//    }

    public VirtualReg getVarReg(String name , boolean lookUpon , IRBasicBlock curBlock , IRFunction curFunc){
        if (classon != null){
            if (classon.idTable.contains(name)){
                VirtualReg thisReg = new VirtualReg(new PointerType(new StructType(classon.name)) , curFunc.takeLabel());
                VirtualReg thisStoreReg = getVarReg("this" , true , curBlock , curFunc);
                curBlock.addInstr(new Load(thisReg , thisStoreReg));
                VirtualReg ptrReg = new VirtualReg(new PointerType(classon.getBaseType(name)) , curFunc.takeLabel());
                ArrayList<IRConstant> offset = new ArrayList<>();
                offset.add(new IntConstant(0));
                offset.add(new IntConstant(classon.getIndex(name)));
                curBlock.addInstr(new Gep(ptrReg , thisReg , offset));
                return ptrReg;
            }
            else if (regTable.containsKey(name))return regTable.get(name);
            else if (lookUpon && parent != null)return parent.getVarReg(name , true , curBlock , curFunc);
            else return null;
        }else {
            if (regTable.containsKey(name))return regTable.get(name);
            else if (lookUpon && parent != null)return parent.getVarReg(name , true , curBlock , curFunc);
            else return null;
        }
    }

//    public Value fetchValue(String identifier){
//        Value tmp = this.valueTable.get(identifier);
//        return tmp == null ? this.parent.fetchValue(identifier) : tmp;
//    }

}
