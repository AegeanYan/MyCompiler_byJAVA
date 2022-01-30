package LLVMIR.Type;

import LLVMIR.Operand.IRConstant;

public class VoidType extends IRType{

    @Override
    public int byteSize() {
        throw new RuntimeException("use byteSize in void type");
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public boolean isEqual(IRType ot) {
        return (ot instanceof VoidType);
    }

    @Override
    public IRConstant getZeroInit() {
        return null;
    }
}
