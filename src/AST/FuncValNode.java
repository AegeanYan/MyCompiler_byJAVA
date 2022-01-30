package AST;

import java.util.ArrayList;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import Util.Type;
import Util.position;
public class FuncValNode extends ASTNode{
    public String name;
    public ExprListNode exprlist;
    public VirtualReg addr;
    public IRConstant imm;
    public ExprNode.Catagory catagory;
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