package LLVMIR.Type;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;

import java.util.ArrayList;

public class FuncType extends IRType{
    public IRType returnType;
    public ArrayList<VirtualReg> args;
    public Integer regCnt;

    public FuncType(IRType returnType){
        this.returnType = returnType;
        this.args = new ArrayList<>();
        regCnt = 0;
    }

    public void addParameter(IRType type , String name){
        args.add(new VirtualReg(type , name));
    }

    public void addParameter(IRType type){
        args.add(new VirtualReg(type , takeLabel()));
    }
    public int takeLabel(){
        return regCnt ++;
    }
    @Override
    public int byteSize() {
        throw new RuntimeException("use byteSize in function type");
    }

    @Override
    public String toString() {
        return returnType.toString();
    }

    @Override
    public boolean isEqual(IRType ot) {
        throw new RuntimeException("use isequal in function");
    }

    @Override
    public IRConstant getZeroInit() {
        return null;
    }
}
