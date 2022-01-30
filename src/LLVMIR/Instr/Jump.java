package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.IRBasicBlock;

public class Jump extends IRInstr{
    public IRBasicBlock dest;
    public Jump(IRBasicBlock dest){
        this.dest = dest;
    }
    @Override
    public String toString(){
        return "br label " + dest.getName();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
