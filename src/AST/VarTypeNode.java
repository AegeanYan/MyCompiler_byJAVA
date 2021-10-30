package AST;

import java.util.ArrayList;

import Util.position;
public abstract class VarTypeNode extends ReturnTypeNode{
    public String id;
    public VarTypeNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
