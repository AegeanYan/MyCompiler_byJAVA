package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class ConstExprNode extends ExprNode{
    public ConstantNode cons;
    public ConstExprNode(ConstantNode _cons, position pos){
        super(pos);
        cons = _cons;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}