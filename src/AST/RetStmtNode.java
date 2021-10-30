package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class RetStmtNode extends StmtNode{
    public ExprNode ret;
    public RetStmtNode(ExprNode _ret, position pos){
        super(pos);
        ret = _ret;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}