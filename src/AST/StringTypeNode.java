package AST;

import java.util.ArrayList;
import Util.position;
public class StringTypeNode extends BuiltinTypeNode{
    public StringTypeNode(position pos){
        super(pos);
        this.id = "string";
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
