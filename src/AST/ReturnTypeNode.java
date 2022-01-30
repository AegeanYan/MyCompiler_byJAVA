package AST;

import java.util.ArrayList;

import LLVMIR.Type.IRType;
import Util.Type;
import Util.position;
public abstract class ReturnTypeNode extends ASTNode{
    public String retType;//retType是ruturntype的base 即不是数组
    public IRType baseType;
    public ReturnTypeNode(position pos){
        super(pos);
    }
    public boolean isEqual(ReturnTypeNode ot){
        if (this instanceof ClassTypeNode && ot instanceof ClassTypeNode)return this.retType.equals(ot.retType);
        else if (this instanceof ArrayTypeNode && ot instanceof ArrayTypeNode)return this.retType.equals(ot.retType);
        else return (this instanceof VoidTypeNode) && (ot instanceof VoidTypeNode);
    }
}
