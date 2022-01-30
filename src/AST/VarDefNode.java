package AST;

import java.util.ArrayList;
import Util.position;
public class VarDefNode extends ASTNode{
    public VarTypeNode type;
    public String id;
    public ExprNode init;
    public boolean global = false;
    public VarDefNode(VarTypeNode _type , String _id , ExprNode _init , position pos){
        super(pos);
        type = _type;
        id = _id;
        init = _init;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
