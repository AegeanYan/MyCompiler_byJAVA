package AST;

import java.util.ArrayList;

import LLVMIR.Operand.IRConstant;
import Util.Type;
import Util.position;
public class ExprListNode extends ASTNode{
    public ArrayList<ExprNode> exprs = new ArrayList<>();
    public ArrayList<IRConstant> cons = new ArrayList<>();
    public ExprListNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}