package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class PrimeStmtNode extends StmtNode{
    public VarDefNode varDef;
    public PrimeStmtNode(VarDefNode _varDef , position pos){
        super(pos);
        varDef = _varDef;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}