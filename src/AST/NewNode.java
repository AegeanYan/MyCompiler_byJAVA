package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class NewNode extends CreatorNode{
    public BuiltinTypeNode types;
    public ArrayList<ExprNode> sizof;
    public int dims;
    public NewNode(BuiltinTypeNode ty , ArrayList<ExprNode> siz , int dim ,position pos){
        super(pos);
        types = ty;
        sizof = siz;
        dims = dim;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}