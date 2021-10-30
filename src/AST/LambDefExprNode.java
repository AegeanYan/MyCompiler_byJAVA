package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class LambDefExprNode extends ExprNode{
    public LambdaValNode lamb;
    public LambDefExprNode(LambdaValNode _lamb, position pos){
        super(pos);
        lamb = _lamb;
        this.isAssignable = false;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}