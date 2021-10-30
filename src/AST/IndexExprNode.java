package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class IndexExprNode extends ExprNode{
    public ExprNode array;
    public ExprNode index;
    public IndexExprNode(ExprNode _array , ExprNode _index, position pos){
        super(pos);
        array = _array;
        index = _index;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}