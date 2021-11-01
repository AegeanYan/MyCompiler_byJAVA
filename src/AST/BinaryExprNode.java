package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class BinaryExprNode extends ExprNode{
    public enum BinaryOp{
        MUL,DIV,MOD,
        ADD,SUB,
        LSH,RSH,
        LT,GT,
        LEQ,GEQ,
        EQ,NEQ,
        AND,
        XOR,
        OR,
        ANDAND,
        OROR,
        ASSIGNEQ,
    }
    public ExprNode lhs;
    public ExprNode rhs;
    public BinaryOp op;
    public BinaryExprNode(ExprNode _lhs, ExprNode _rhs , BinaryOp _op, position pos){
        super(pos);
        lhs = _lhs;
        rhs = _rhs;
        op = _op;
//        this.expr_ret = lhs.expr_ret;
//        this.expr_ret.retType = lhs.expr_ret.retType;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}