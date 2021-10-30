package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class ExprListNode extends ASTNode{
    public ArrayList<ExprNode> exprs = new ArrayList<>();
    public ExprListNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}