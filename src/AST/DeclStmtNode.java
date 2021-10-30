package AST;
import Util.position;

import java.util.ArrayList;

public class DeclStmtNode extends DeclrNode{
    public ArrayList<VarDefNode> var_defs;
    public DeclStmtNode(ArrayList<VarDefNode> vars , position pos){
        super(pos);
        var_defs = vars;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
