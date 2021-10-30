package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class PrefixExprNode extends ExprNode{
    public enum PreOp{
        INC , DEC
    }
    public ExprNode rhs;
    public PreOp op;
    public PrefixExprNode(ExprNode _rhs , PreOp _op, position pos){
        super(pos);
        rhs = _rhs;
        op = _op;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}