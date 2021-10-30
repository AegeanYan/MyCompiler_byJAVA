package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class NullValNode extends ConstantNode{
    public NullValNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}