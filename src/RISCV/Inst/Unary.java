package RISCV.Inst;

import RISCV.Operand.PhysicalReg;

public class Unary extends RISCVInst{
    public enum Op{
        seqz , snez , sgtz , sltz
    }
    public Op op;
    public Unary(Op op , PhysicalReg rd , PhysicalReg rs1){
        super(rd , rs1 , null);
        this.op = op;
    }
    @Override
    public String toString(){
        return op.toString() + "\t" + rd.toString() + ", " + rs1.toString();
    }
}

