package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class ConstExprNode extends ExprNode{
    public ConstantNode cons;
    public ConstExprNode(ConstantNode _cons, position pos){
        super(pos);
        cons = _cons;
        position po = new position(-1,-1);
        if (cons instanceof IntValNode){
            this.expr_ret = new ClassTypeNode("int" , po);
            this.expr_ret.retType = "int";
        }else if (cons instanceof StringValNode){
            this.expr_ret = new ClassTypeNode("string" , po);
            this.expr_ret.retType = "string";
        }else if (cons instanceof BoolValNode){
            this.expr_ret = new ClassTypeNode("bool" , po);
            this.expr_ret.retType = "bool";
        }else if (cons instanceof NullValNode){
            this.expr_ret = new ClassTypeNode("null" , po);
            this.expr_ret.retType = "null";
        }
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}