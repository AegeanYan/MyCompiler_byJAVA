package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public abstract class ConstantNode extends ASTNode{
    public Type type;
    public ConstantNode(position pos){
        super(pos);
    }
}