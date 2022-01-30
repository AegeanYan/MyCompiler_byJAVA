package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Type.VoidType;

public class Store extends IRInstr{
    public IRConstant storeVal , storeAddr;
    public Store(IRConstant val , IRConstant addr){
        this.storeVal = val;
        this.storeAddr = addr;
    }


    @Override
    public String toString(){
        return "store " + storeVal.toString() + " ," + storeAddr.toString() + ", align " + this.storeVal.type.byteSize();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
