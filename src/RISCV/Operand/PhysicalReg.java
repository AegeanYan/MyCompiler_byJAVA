package RISCV.Operand;

public class PhysicalReg {
    public String name;
    public boolean busy;
    public PhysicalReg(String name){
        this.name = name;
        this.busy = false;
    }
    public void use(){
        if (busy)throw new RuntimeException("reg had been used");
        else this.busy = true;
    }
    public void free(){
        if (!busy)throw new RuntimeException("reg hadn't been used");
        this.busy = false;
    }
    public String toString(){
        return this.name;
    }
}
