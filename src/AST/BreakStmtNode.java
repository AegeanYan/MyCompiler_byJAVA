package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class BreakStmtNode extends CtrlStmtNode{
    public BreakStmtNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}