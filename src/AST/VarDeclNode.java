package AST;
import Util.position;
public class VarDeclNode extends ASTNode{
    public String name;
    public ExprNode expr;
    public VarDeclNode(String _name , ExprNode _expr , position pos){
        super(pos);
        name = _name;
        expr = _expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
