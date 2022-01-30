package AST;

import LLVMIR.BasicClass.Value;
import LLVMIR.Operand.IRConstant;
import Util.position;

abstract public class ASTNode{
    public position pos;
    public IRConstant IROperand;

    public ASTNode(position pos){
        this.pos = pos;
        this.IROperand = null;
    }
    public position getPos(){
        return this.pos;
    }
    abstract public void accept(ASTVisitor visitor);
}