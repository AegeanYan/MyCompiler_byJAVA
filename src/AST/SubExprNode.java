package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class SubExprNode extends ExprNode{
    public ExprNode expr;
    public SubExprNode(ExprNode _expr, position pos){
        super(pos);
        expr = _expr;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}