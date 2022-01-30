package RISCV.Inst;

import RISCV.Operand.PhysicalReg;

public class Move extends RISCVInst{
    public Move(PhysicalReg rd , PhysicalReg rs1){
        super(rd, rs1 , null);
    }

    @Override
    public String toString(){
        return "mv\t" + rd.toString() + ", " + rs1.toString();
    }
}
