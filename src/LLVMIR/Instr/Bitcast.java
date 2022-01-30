package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.IRType;

public class Bitcast extends IRInstr{
    public VirtualReg srcReg;
    public VirtualReg destReg;
    public Bitcast(VirtualReg src , VirtualReg dest){
        this.srcReg = src;
        this.destReg = dest;
    }

    @Override
    public String toString(){
        return destReg.getName() + " = bitcast " + srcReg.toString() + " to " + destReg.type.toString();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
