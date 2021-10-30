package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class ForInitNode extends ASTNode{
    public ExprNode expr;
    public VarDefNode vardef;
    public ForInitNode(position pos){
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}