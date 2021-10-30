package AST;

import Util.position;

abstract public class ASTNode{
    public position pos;

    public ASTNode(position pos){
        this.pos = pos;
    }
    public position getPos(){
        return this.pos;
    }
    abstract public void accept(ASTVisitor visitor);
}