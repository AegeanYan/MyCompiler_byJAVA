package RISCV.Inst;

import RISCV.Operand.PhysicalReg;

public class Branch extends RISCVInst{
    public enum Op{
        beqz , bnez , bltu , blt , bge , bgeu
    }
    final Op op;
    final String target;
    public Branch(Op op , PhysicalReg rs1 , PhysicalReg rs2 , String target){
           super(null , rs1 , rs2);
           this.op = op;
           this.target = target;
    }
    @Override
    public String toString(){
        String str;
        if (rs2 != null)str = op.toString() + " " + rs1.toString() + ", " + rs2.toString() + ", " + target;
        else str = op.toString() + " " + rs1.toString() + ", " + target;
        return str;
    }
}
