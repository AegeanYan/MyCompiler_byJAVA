package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class StringValNode extends ConstantNode{
    public String value;
    public StringValNode(String _value,position pos){
        super(pos);
        value = _value;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}