package LLVMIR.Operand;

import LLVMIR.Type.IRType;
import LLVMIR.Type.PointerType;
import LLVMIR.Type.VoidType;

public class NullConstant extends IRConstant{

    public NullConstant(){
        super("null" , new PointerType(new VoidType()));
    }

    public NullConstant(PointerType type){
        super("null" , type);
    }

    public void setType(IRType type){
        this.type = type;
    }

    @Override
    public String getName(){
        return "null";
    }

    @Override
    public String toString(){
        return "null";
    }
}
