package RISCV.Inst;

import RISCV.Operand.Imm;
import RISCV.Operand.PhysicalReg;

public class LoadImm extends RISCVInst{
    public Imm imm;
    public LoadImm(PhysicalReg rd , Long imm){
        super(rd , null , null);
        this.imm = new Imm(imm);
    }
    @Override
    public String toString(){
        return "li\t" + rd.toString() + ", " + imm.toString();
    }
}
