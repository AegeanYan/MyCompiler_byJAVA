package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class ThisExprNode extends ExprNode{
    public ThisValNode thi;
    public ThisExprNode(ThisValNode _thi, position pos){
        super(pos);
        thi = _thi;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}