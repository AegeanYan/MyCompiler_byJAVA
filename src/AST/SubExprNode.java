package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class SubExprNode extends ExprNode{
    public ExprNode expr;
    public SubExprNode(ExprNode _expr, position pos){
        super(pos);
        expr = _expr;
//        this.expr_ret = _expr.expr_ret;
//        this.expr_ret.retType = _expr.expr_ret.retType;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}