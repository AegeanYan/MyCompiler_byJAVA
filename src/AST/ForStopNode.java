package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class ForStopNode extends ASTNode{
    public ExprNode expr;
    public ForStopNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}