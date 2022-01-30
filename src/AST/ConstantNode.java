package AST;

import java.util.ArrayList;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import Util.Type;
import Util.position;
public abstract class ConstantNode extends ASTNode{
    public VirtualReg addr;
    public IRConstant imm;
    public ExprNode.Catagory catagory;
    public ConstantNode(position pos){
        super(pos);
    }
}