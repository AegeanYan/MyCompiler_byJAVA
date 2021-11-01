package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public abstract class ExprNode extends ASTNode{
    public ReturnTypeNode expr_ret;//expr_ret可以是数组
    public boolean isAssignable;
    public ExprNode(position pos){
        super(pos);
    }
}