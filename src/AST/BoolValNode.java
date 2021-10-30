package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class BoolValNode extends ConstantNode{
    public boolean value;
    public BoolValNode(boolean _value,position pos){
        super(pos);
        value = _value;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}