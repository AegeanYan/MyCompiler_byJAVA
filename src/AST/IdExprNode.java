package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class IdExprNode extends ExprNode{
    public IdValNode id;
    public IdExprNode(IdValNode _id , position pos){//idexpr的返回值不能定？就是class；
        super(pos);
        id = _id;
        this.expr_ret = new ClassTypeNode("int" , new position(-1,-1));
        this.expr_ret.retType = id.name;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}