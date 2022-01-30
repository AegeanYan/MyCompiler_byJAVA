package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Type.IntegerType;
import LLVMIR.Type.VoidType;

public class Branch extends IRInstr{
    public IRConstant cond;
    public IRBasicBlock thenBlock , elseBlock;
    public Branch(IRConstant _cond , IRBasicBlock thenB , IRBasicBlock elseB){
        this.cond = _cond;
        this.thenBlock = thenB;
        this.elseBlock = elseB;
    }



    @Override
    public String toString(){
        return "br" + cond.toString() + ", label" + thenBlock.getName() + ", label" + elseBlock.getName();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
