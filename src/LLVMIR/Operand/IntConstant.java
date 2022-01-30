package LLVMIR.Operand;

import LLVMIR.Type.IRType;
import LLVMIR.Type.IntegerType;

public class IntConstant extends IRConstant{
    public long value;
    public IntConstant(long value){
        super("int_const" , new IntegerType(32));
        this.value = value;
    }
    public IntConstant(long value , int width){
        super("int_const" , new IntegerType(width));
        this.value = value;
    }

    @Override
    public String getName(){
        return String.valueOf(this.value);
    }

    @Override
    public String toString(){
        return this.type.toString() + " " + String.valueOf(this.value);
    }
}
