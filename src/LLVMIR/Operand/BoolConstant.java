package LLVMIR.Operand;

import LLVMIR.Type.BoolType;

public class BoolConstant extends IRConstant{
    public boolean value;

    public BoolConstant(boolean flag) {
        super("bool_const", new BoolType());
        this.value = flag;
    }

    @Override
    public String getName(){
        return value ? "true" : "false";
    }
    @Override
    public String toString(){
        String flag = value ? "true" : "false";
        return this.type.toString() + " " + flag;
    }
}
