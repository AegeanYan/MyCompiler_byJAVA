package AST;

import java.util.ArrayList;

import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.IRType;
import LLVMIR.Type.PointerType;
import Util.Type;
import Util.position;
public abstract class ExprNode extends ASTNode{
    public ReturnTypeNode expr_ret;//expr_ret可以是数组
    public boolean isAssignable;
    public enum Catagory{
        LVALUE , RVALUE,
    }
    public Catagory catagory;
    public VirtualReg addr;//l
    public IRConstant value;//r
    public String exprType;
    public boolean isLvalue(){
        return catagory == Catagory.LVALUE;
    }
    public IRType getValueType(){
        if (catagory == Catagory.LVALUE){
            return ((PointerType) addr.type).dePointed();
        }
        else {
            return value.type;
        }
    }
    public ExprNode(position pos){
        super(pos);
    }
}