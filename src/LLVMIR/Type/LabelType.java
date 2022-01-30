package LLVMIR.Type;

import LLVMIR.Operand.IRConstant;

public class LabelType extends IRType{
    @Override
    public int byteSize() {
        throw new RuntimeException("use byteSize in label type");
    }

    @Override
    public String toString() {
        return "label";
    }

    @Override
    public boolean isEqual(IRType ot) {
        return (ot instanceof LabelType);
    }

    @Override
    public IRConstant getZeroInit() {
        return null;
    }
}
