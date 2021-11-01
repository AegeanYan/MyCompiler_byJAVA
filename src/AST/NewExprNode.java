package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class NewExprNode extends ExprNode{
    public CreatorNode creator;
    public NewExprNode(CreatorNode _creator, position pos){
        super(pos);
        creator = _creator;
        if (creator instanceof NewNode){
            if (((NewNode) creator).dims != 0)this.expr_ret = new ArrayTypeNode(((NewNode) creator).types , ((NewNode) creator).dims ,new position(-1 , -1));
            else this.expr_ret = ((NewNode) creator).types;
            this.expr_ret.retType = ((NewNode) creator).types.retType;
        }
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}