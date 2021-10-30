package AST;
import Util.position;
public class BoolTypeNode extends BuiltinTypeNode{
    public BoolTypeNode(position pos){
        super(pos);
        this.id = "bool";
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
