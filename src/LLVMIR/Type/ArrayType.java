package LLVMIR.Type;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.NullConstant;

public class ArrayType extends IRType{
    public IRType baseType;
    public int arraysize;

    public ArrayType(IRType type , int arraysize){
        this.baseType = type;
        this.arraysize = arraysize;
    }


    @Override
    public int byteSize() {
        return baseType.byteSize() * arraysize;
    }

    @Override
    public String toString() {
        return "[" + this.arraysize + " x " + this.baseType.toString() + "]";
    }

    @Override
    public boolean isEqual(IRType ot) {
        return (ot instanceof ArrayType) && this.baseType.isEqual(((ArrayType) ot).baseType) && this.arraysize == ((ArrayType) ot).arraysize;
    }
    @Override
    public IRConstant getZeroInit(){
        return new NullConstant();
    }
}
