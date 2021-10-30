package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class ForStmtNode extends StmtNode{
    public ForInitNode init;
    public ForStopNode cond;
    public ExprNode incre;
    public StmtNode stmt;
    public ForStmtNode(ForInitNode _init, ForStopNode _cond, ExprNode _incre, StmtNode _stmt ,position pos){
        super(pos);
        init = _init;
        cond = _cond;
        incre = _incre;
        stmt = _stmt;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}