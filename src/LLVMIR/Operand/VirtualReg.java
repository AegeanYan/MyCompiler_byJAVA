package LLVMIR.Operand;

import LLVMIR.Type.IRType;

public class VirtualReg extends IRConstant{
    public Integer numLabel;
    public String  name;
    public VirtualReg(IRType basetype , int label){
        super(null , basetype);
        numLabel = label;
        name = null;
    }
    public VirtualReg(IRType basetype , String name){
        super(name , basetype);
        this.name = name;
    }

    @Override
    public String getName(){
        if (name == null)return "%" + numLabel.toString();
        else return "@" + name;
    }
    @Override
    public String toString(){
        if (name == null)return this.type.toString() + " %" + numLabel.toString();
        else return this.type.toString() + " @" + this.name;
    }
}
