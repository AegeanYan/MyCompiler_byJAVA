package RISCV.Inst;

public class Call extends RISCVInst{
    public String funcName;
    public Call(String name){
        super(null , null , null);
        funcName = name;
    }
    @Override
    public String toString(){
        return "call\t" + funcName;
    }
}
