package AST;

import java.util.ArrayList;
import Util.position;
public class IntTypeNode extends BuiltinTypeNode{
    public IntTypeNode(position pos){
        super(pos);
        this.id = "int";
        this.retType = "int";
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
