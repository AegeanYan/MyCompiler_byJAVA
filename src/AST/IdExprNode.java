package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class IdExprNode extends ExprNode{
    public IdValNode id;
    public IdExprNode(IdValNode _id , position pos){
        super(pos);
        id = _id;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}