package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class FuncCallExprNode extends ExprNode{
    public String name;
    public ExprListNode expr;
    public FuncCallExprNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}