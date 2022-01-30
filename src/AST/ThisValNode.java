package AST;

import java.util.ArrayList;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import Util.Type;
import Util.position;
public class ThisValNode extends ASTNode{
    public VirtualReg addr;
    public IRConstant imm;
    public ExprNode.Catagory catagory;
    public ThisValNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}