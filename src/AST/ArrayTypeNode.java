package AST;

import java.util.ArrayList;
import Util.position;
public class ArrayTypeNode extends VarTypeNode{
    public VarTypeNode varType;
    public int dims;
    public ArrayTypeNode(VarTypeNode _varType , position pos){
        super(pos);
        if (_varType instanceof ArrayTypeNode){
            varType = ((ArrayTypeNode) _varType).varType;    //继承了
            dims = ((ArrayTypeNode) _varType).dims + 1;
        }
        else {
            varType = _varType;
            dims = 1;
        }
        this.id = varType.id;
    }
    public ArrayTypeNode(VarTypeNode _varType , int dim , position pos){
        super(pos);
        varType = _varType;
        dims = dim;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
