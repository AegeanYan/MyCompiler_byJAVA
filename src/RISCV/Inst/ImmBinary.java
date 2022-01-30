package RISCV.Inst;

import RISCV.Operand.Imm;
import RISCV.Operand.PhysicalReg;

public class ImmBinary extends RISCVInst{
    public enum Op{
        addi , slti , sltiu , andi , ori , xori , slli
    }
    public Op op;
    public Imm imm;
    public ImmBinary(Op op , PhysicalReg rd , PhysicalReg rs1 , Long imm){
        super(rd , rs1 , null);
        this.op = op;
        this.imm = new Imm(imm);
    }

    @Override
    public String toString(){
        return op.toString() + "\t" + this.rd.toString() + ", " + this.rs1.toString()  + ", "  + imm.toString();
    }
}
