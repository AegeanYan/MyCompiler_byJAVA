package RISCV.Inst;

import RISCV.Operand.PhysicalReg;

public class LoadAddr extends RISCVInst{
    String variable;
    public LoadAddr(PhysicalReg rd , String var){
        super(rd , null , null);
        this.variable = var;
    }

    @Override
    public String toString(){
        return "la\t" + rd.toString() + ", " + variable;
    }
}
