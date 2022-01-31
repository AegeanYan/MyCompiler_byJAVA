package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.NullConstant;
import LLVMIR.Type.IRType;
import LLVMIR.Type.VoidType;

public class Ret extends IRInstr {
    public IRConstant retVal;
    public IRType nullType;
    public Ret(IRConstant returnVal){
        this.retVal = returnVal;
        this.nullType = null;
    }
    public Ret(IRConstant retVal , IRType nullType){
        this.retVal = retVal;
        this.nullType = nullType;
    }

    @Override
    public String toString(){
        String retValStr;
        if (retVal == null)retValStr = "void";
        else {
            if (retVal instanceof NullConstant)retValStr = nullType.toString() + " null";
            else retValStr = retVal.toString();
        }
        return "ret " + retValStr;
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
