package RISCV.Inst;

import RISCV.Operand.Imm;
import RISCV.Operand.PhysicalReg;

public class Load extends RISCVInst{
    public  StepWidth width;
    public Imm imm;
    public Load(StepWidth width , PhysicalReg rd , PhysicalReg rs1 , Long imm){
        super(rd , rs1 , null);
        this.width = width;
        this.imm = new Imm(imm);
    }
    @Override
    public String toString(){
        String ret;
        if (width == StepWidth.word)ret = "lw\t";
        else if (width == StepWidth.half)ret = "lh\t";
        else ret = "lb\t";

        ret += rd.toString() + ", " + imm.toString() + "(" + rs1.toString() + ")";
        return ret;
    }
}
