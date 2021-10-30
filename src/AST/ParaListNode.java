package AST;

import java.util.ArrayList;
import Util.Type;
import Util.position;
public class ParaListNode extends ASTNode{
    public ArrayList<VarTypeNode> par = new ArrayList<>();
    //public ArrayList<Type> types = new ArrayList<>();
    //public ArrayList<String> ids = new ArrayList<>();
    public ArrayList<VarDeclNode> decls = new ArrayList<>();
    public ParaListNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
