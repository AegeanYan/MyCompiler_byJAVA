package LLVMIR.Type;

import LLVMIR.Operand.IRConstant;

public abstract class IRType {
    public abstract int byteSize();
    public abstract String toString();
    public abstract boolean isEqual(IRType ot);
    public abstract IRConstant getZeroInit();
    public IRType dePointed(){
        if (this instanceof PointerType){
            if (((PointerType) this).dimSize == 1)return ((PointerType)this).baseType;
            else return new PointerType(((PointerType) this).baseType , ((PointerType) this).dimSize -1);
        } else throw new RuntimeException("depointing a non-pointed value");
    }
}
