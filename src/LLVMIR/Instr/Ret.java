package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Type.VoidType;

public class Ret extends IRInstr {
    public IRConstant retVal;
    public Ret(IRConstant returnVal){
        this.retVal = returnVal;
    }

    @Override
    public String toString(){
        String retType = retVal != null ? retVal.toString() : "void";
        return "ret" + retType;
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
