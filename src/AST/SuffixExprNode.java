package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class SuffixExprNode extends ExprNode{
    public enum SufOp{
        INC , DEC
    }
    public ExprNode lhs;
    public SufOp op;
    public SuffixExprNode(ExprNode _lhs, SufOp _op , position pos){
        super(pos);
        lhs = _lhs;
        op = _op;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}