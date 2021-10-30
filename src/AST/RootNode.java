package AST;

import java.util.ArrayList;
import Util.position;

public class RootNode extends ASTNode{
    public ArrayList<DeclrNode> declrs = new ArrayList<DeclrNode>();
    public RootNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){visitor.visit(this);}
}
