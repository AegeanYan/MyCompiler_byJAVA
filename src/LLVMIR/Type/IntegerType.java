package LLVMIR.Type;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.IntConstant;
import LLVMIR.Operand.NullConstant;

public class IntegerType extends IRType{
    public int width;

    public IntegerType(int width){//i width
        this.width = width;
    }

    @Override
    public int byteSize() {
        return this.width/8;
    }

    @Override
    public String toString() {
        return "i" + this.width;
    }

    @Override
    public boolean isEqual(IRType ot) {
        return (ot instanceof IntegerType) && ((IntegerType) ot).width == this.width;
    }

    @Override
    public IRConstant getZeroInit() {
        return new IntConstant(0);
    }
}
