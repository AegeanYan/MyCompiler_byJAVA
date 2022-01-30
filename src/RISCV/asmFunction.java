package RISCV;

import LLVMIR.Operand.VirtualReg;
import RISCV.Operand.PhysicalReg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class asmFunction {
    public String name;
    public ArrayList<PhysicalReg> parameters = new ArrayList<>();
    public Integer labelCnt;
    public LinkedList<asmBlock> blockTable = new LinkedList<>();
    public HashSet<Integer> stackVars = new HashSet<>();
    public asmFunction(String name){
        this.name = name;
        labelCnt = 0;
        this.blockTable.add(new asmBlock(name , takeLabel()));
    }

    public void allocaStackVar(VirtualReg reg){
        stackVars.add(reg.numLabel);
    }

    public boolean cotainStackVar(VirtualReg reg){
        return stackVars.contains(reg.numLabel);
    }

    public asmBlock getEntry(){
        return this.blockTable.get(0);
    }

    public void addBlock(asmBlock bb){
        this.blockTable.add(bb);
    }

    public int takeLabel(){
        return labelCnt++;
    }

    public void accept(asmVisitor visitor){
        visitor.visit(this);
    }
}
