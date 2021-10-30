package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class UnaryExprNode extends ExprNode{
    public enum UnaryOp{
        LNOT , BNOT , //!;~
        POS , NEG , //+;-
    }
    public UnaryOp op;
    public ExprNode rhs;
    public UnaryExprNode(UnaryOp _op, ExprNode _rhs, position pos){
        super(pos);
        rhs = _rhs;
        op = _op;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}