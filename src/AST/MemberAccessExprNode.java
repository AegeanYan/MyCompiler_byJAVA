package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class MemberAccessExprNode extends ExprNode{
    public ExprNode object;
    public IdValNode member;
    public ExprListNode exprlist;
    public FuncDefNode funcInfo;
    public boolean forfunc = false;
    public MemberAccessExprNode(ExprNode _object , IdValNode _member , ExprListNode _exprlist, position pos){
        super(pos);
        object = _object;
        member = _member;
        exprlist = _exprlist;
        funcInfo = null;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}