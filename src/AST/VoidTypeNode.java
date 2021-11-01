package AST;

import java.util.ArrayList;
import Util.position;
public class VoidTypeNode extends ReturnTypeNode{
    public VoidTypeNode(position pos){
        super(pos);
        this.retType = "void";
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
