package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class FuncValNode extends ASTNode{
    public String name;
    public ExprListNode exprlist;
    public FuncValNode(String _name , ExprListNode _exprlist,position pos){
        super(pos);
        name = _name;
        exprlist = _exprlist;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}