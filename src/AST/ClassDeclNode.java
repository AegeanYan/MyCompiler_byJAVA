package AST;

import java.util.ArrayList;
import Util.position;
public class ClassDeclNode extends DeclrNode{
    public String name;
    public ArrayList<DeclrNode> declrs = new ArrayList<>();
    public ClassDeclNode(String _name , position pos){
        super(pos);
        name = _name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
