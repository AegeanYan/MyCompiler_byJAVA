package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class SuiteStmtNode extends StmtNode{
    public SuiteNode suite;
    public SuiteStmtNode(SuiteNode _suite ,position pos){
        super(pos);
        suite = _suite;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}