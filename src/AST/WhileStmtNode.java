package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class WhileStmtNode extends StmtNode{
    public ExprNode cond;
    public StmtNode stmt;
    public WhileStmtNode(ExprNode _cond, StmtNode _stmt, position pos){
        super(pos);
        cond = _cond;
        stmt = _stmt;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}