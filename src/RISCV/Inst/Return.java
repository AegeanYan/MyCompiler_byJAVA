package RISCV.Inst;

public class Return extends RISCVInst{
    public Return(){
        super(null ,null , null);
    }

    @Override
    public String toString(){
        return "ret";
    }
}
