package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class ExprStmtNode extends StmtNode{
    public ExprNode expr;
    public ExprStmtNode(ExprNode _expr , position pos){
        super(pos);
        expr = _expr;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}