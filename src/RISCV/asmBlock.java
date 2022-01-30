package RISCV;

import RISCV.Inst.RISCVInst;

import java.util.LinkedList;

public class asmBlock {
    public String functionName;
    public Integer label;
    public LinkedList<RISCVInst> InstTable = new LinkedList<>();

    public asmBlock(asmFunction parent, String functionName , int label){
        this.functionName = functionName;
        this.label = label;
        parent.addBlock(this);
    }
    public asmBlock(String functionName , int label){
        this.functionName = functionName;
        this.label = label;
    }
    public void append(RISCVInst inst){
        this.InstTable.add(inst);
    }

    public String getLabel(){
        return "." + functionName + "_" + label;
    }
    public void accept(asmVisitor visitor){
        visitor.visit(this);
    }
}
