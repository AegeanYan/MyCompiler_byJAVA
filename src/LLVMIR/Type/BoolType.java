package LLVMIR.Type;

import LLVMIR.Operand.BoolConstant;
import LLVMIR.Operand.IRConstant;

public class BoolType extends IRType{

    @Override
    public int byteSize() {
        return 4;
    }

    @Override
    public String toString() {
        return "i1";
    }

    @Override
    public boolean isEqual(IRType ot) {
        return (ot instanceof BoolType);
    }

    @Override
    public IRConstant getZeroInit() {
        return new BoolConstant(false);
    }
}
