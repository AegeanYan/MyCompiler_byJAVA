package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class CondStmtNode extends StmtNode{
    public ExprNode condi;
    public StmtNode if_stmt;
    public StmtNode else_stmt;
    public CondStmtNode(ExprNode _condi,StmtNode _if_stmt,StmtNode _else_stmt, position pos){
        super(pos);
        condi = _condi;
        if_stmt = _if_stmt;
        else_stmt = _else_stmt;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}