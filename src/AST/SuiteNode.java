package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class SuiteNode extends ASTNode{
    //public Type retType = null;
    public ArrayList<StmtNode> stmts = new ArrayList<>();
    //public ArrayList<Type> types = new ArrayList<>();
    public SuiteNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}