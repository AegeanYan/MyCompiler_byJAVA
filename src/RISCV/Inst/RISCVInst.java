package RISCV.Inst;
import RISCV.Operand.PhysicalReg;
import RISCV.asmBlock;
abstract public class RISCVInst {
    public asmBlock parent;
    public PhysicalReg rs1 , rs2 , rd;
    public RISCVInst(PhysicalReg rd , PhysicalReg rs1 , PhysicalReg rs2){
        this.rd = rd;
        this.rs1 = rs1;
        this.rs2 = rs2;
    }
    abstract public String toString();
}
