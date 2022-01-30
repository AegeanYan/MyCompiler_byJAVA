package RISCV.Operand;

public class Imm {
    public Long value;
    public Imm(long value){
        this.value = value;
    }
    public String toString(){
        return value.toString();
    }
}
