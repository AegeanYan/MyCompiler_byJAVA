package RISCV.Inst;

import RISCV.Operand.Imm;
import RISCV.Operand.PhysicalReg;

import java.lang.annotation.Inherited;

public class Store extends RISCVInst{
    public StepWidth width;
    public Imm imm;
    public Store(StepWidth width , PhysicalReg rs2 , PhysicalReg rs1 , Long imm){
        super(null , rs1 , rs2);
        this.width = width;
        this.imm = new Imm(imm);
    }

    @Override
    public String toString(){
        String ret;
        if (width == StepWidth.word)ret = "sw\t";
        else if (width == StepWidth.half)ret = "sh\t";
        else ret = "sb\t";
        ret += rs2.toString() + ", " + imm.toString() + "(" + rs1.toString() + ")";
        return ret;
    }
}
