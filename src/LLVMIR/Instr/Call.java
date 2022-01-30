package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.IRFunction;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.FuncType;
import LLVMIR.Type.VoidType;

import java.util.ArrayList;

public class Call extends IRInstr{
    public VirtualReg allocReg;
    public IRFunction func;
    public ArrayList<IRConstant> in_args;

    public Call(VirtualReg reg , IRFunction func_ , ArrayList<IRConstant> in_args){
        this.allocReg = reg;
        this.func = func_;
        this.in_args = new ArrayList<>();
        if (in_args != null){
            this.in_args.addAll(in_args);
        }
    }

    @Override
    public String toString(){
        StringBuilder raw ;
        if (allocReg != null){
            raw = new StringBuilder(allocReg.getName() + " = call " + func.type.toString() + " @" + func.name);
        }else {
            raw = new StringBuilder("call " + (func.type).toString() + " @" + func.name);
        }
        raw.append("(");
        for (int i = 0; i < in_args.size() ; ++i){
            raw.append(in_args.get(i).toString());
            if (i != in_args.size() - 1)raw.append(", ");
        }
        raw.append(")");
        return raw.toString();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
