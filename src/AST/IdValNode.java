package AST;

import java.util.ArrayList;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import Util.Type;
import Util.position;
public class IdValNode extends ASTNode{
    public String name;
    public VirtualReg addr;
    public IRConstant imm;
    public ExprNode.Catagory catagory;
    public IdValNode(String _name,position pos){
        super(pos);
        name = _name;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}