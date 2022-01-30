package LLVMIR.Type;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.NullConstant;

public class PointerType extends IRType {
    public IRType baseType;
    public int dimSize;

    public PointerType(IRType baseType){
        if (baseType instanceof PointerType){
            this.baseType = ((PointerType) baseType).baseType;
            this.dimSize = ((PointerType) baseType).dimSize + 1;
        }else {
            this.baseType = baseType;
            this.dimSize = 1;
        }
    }

    public PointerType(IRType baseType , int dimSize){
        if (baseType instanceof PointerType){
            this.baseType = ((PointerType)baseType).baseType;
            this.dimSize = ((PointerType)baseType).dimSize + dimSize;
        }else {
            this.baseType = baseType;
            this.dimSize = dimSize;

        }
    }

    @Override
    public int byteSize() {
        return 8;
    }

    @Override
    public String toString() {
        return this.baseType.toString() + "*".repeat(this.dimSize);
    }

    @Override
    public boolean isEqual(IRType ot) {
        return false;
    }

    @Override
    public IRConstant getZeroInit() {
        return new NullConstant();
    }
}
