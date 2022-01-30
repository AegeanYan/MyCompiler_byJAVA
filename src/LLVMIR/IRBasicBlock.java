package LLVMIR;

import Backend.IRInterface;
import Frontend.IRVisitor;
import LLVMIR.BasicClass.Value;
import LLVMIR.Instr.Branch;
import LLVMIR.Instr.IRInstr;
import LLVMIR.Instr.Ret;
import LLVMIR.Type.LabelType;

import java.util.ArrayList;
import java.util.LinkedList;

public class IRBasicBlock extends Value {
    public LinkedList<IRInstr> instrs;
    public IRInstr terminator;
    public IRFunction parentFunc;
    public Integer label = 0;

    public IRBasicBlock(String label,IRFunction parent){//

        super(label+"_bb" , new LabelType());
        this.parentFunc = parent;
        this.instrs = new LinkedList<>();
        this.terminator = null;
        parent.addBlock(this);
    }
    public IRBasicBlock(IRFunction parent , int label){//

        super(String.valueOf(label)+"_bb" , new LabelType());
        this.parentFunc = parent;
        this.instrs = new LinkedList<>();
        this.terminator = null;
        this.label = label;
        parent.addBlock(this);
    }
    public IRBasicBlock(int label){
        super(String.valueOf(label) + "_bb" , new LabelType());
        this.label = label;
        this.instrs = new LinkedList<>();
        this.terminator = null;
    }
    public void setTerminator(IRInstr instr){
        if (this.terminator == null)this.terminator = instr;
    }
    public void addInstr(IRInstr instr){
        if(instr instanceof Branch || instr instanceof Ret)setTerminator(instr);
        this.instrs.add(instr);
    }
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
