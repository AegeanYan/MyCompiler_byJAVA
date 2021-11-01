package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class PrimeStmtNode extends StmtNode{
    public ArrayList<VarDefNode> var_defs;
    public PrimeStmtNode(ArrayList<VarDefNode> vars , position pos){
        super(pos);
        var_defs = vars;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}