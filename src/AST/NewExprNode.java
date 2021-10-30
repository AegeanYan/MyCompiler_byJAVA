package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class NewExprNode extends ExprNode{
    public CreatorNode creator;
    public NewExprNode(CreatorNode _creator, position pos){
        super(pos);
        creator = _creator;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}