package AST;

import java.util.ArrayList;
import Util.position;
public class ClassTypeNode extends BuiltinTypeNode{
    public String name;
    public ClassTypeNode(String name , position pos){
        super(pos);
        this.name = name;
        this.id = name;
        this.retType = name;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
