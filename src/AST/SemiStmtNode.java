package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class SemiStmtNode extends StmtNode{
    public SemiStmtNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}