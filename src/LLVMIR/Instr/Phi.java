package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class Phi extends IRInstr{
    public VirtualReg resultReg;
    public ArrayList<Pair<IRConstant , Integer>> paths;
    public Phi(VirtualReg result , ArrayList<Pair<IRConstant , Integer>> path){
        this.resultReg = result;
        this.paths = path;
    }
    @Override
    public String toString(){
        StringBuilder raw = new StringBuilder(resultReg.getName() + " = phi "+resultReg.type.toString());
        for (int i = 0; i < paths.size();++i){
            raw.append(" [ ").append(paths.get(i).a.getName()).append(", %").append(paths.get(i).b.toString()).append(" ]");
            if (i != paths.size()-1) raw.append(',');
        }
        return raw.toString();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
