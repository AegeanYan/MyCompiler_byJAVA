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
    public HashSet<Integer> vari_num_stack = new HashSet<>();
    public LinkedList<asmBlock> blockTable = new LinkedList<>();

    public asmFunction(String name){
        this.name = name;
        labelCnt = 0;
        this.blockTable.add(new asmBlock(name , takeLabel()));
    }

    public void StackAlloc(VirtualReg reg){
        vari_num_stack.add(reg.numLabel);
    }

    public boolean cotainStackVar(VirtualReg reg){
        return vari_num_stack.contains(reg.numLabel);
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
