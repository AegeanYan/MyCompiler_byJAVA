package RISCV.Inst;

import RISCV.Operand.PhysicalReg;

public class RegBinary extends RISCVInst{
    public enum Op{
        add , sub , mul , div , rem , sll , sra, slt , sltu , or , and ,xor
    }
    public Op op;
    public RegBinary(Op op , PhysicalReg rd, PhysicalReg rs1 , PhysicalReg rs2){
        super(rd, rs1 ,rs2);
        this.op = op;
    }
    @Override
    public String toString(){
        return op.toString() + "\t" + rd.toString() + ", "  +rs1.toString() + ", " + rs2.toString();
    }
}
