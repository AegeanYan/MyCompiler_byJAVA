package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class IntValNode extends ConstantNode{
    public long value;

    public IntValNode(long _value,position pos){
        super(pos);
        value = _value;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}