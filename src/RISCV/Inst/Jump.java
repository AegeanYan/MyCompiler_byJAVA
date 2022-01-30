package RISCV.Inst;

public class Jump extends RISCVInst{
    public String target;
    public Jump(String target){
        super(null , null , null);
        this.target = target;
    }
    @Override
    public String toString(){
        return "j\t" + target;
    }
}
