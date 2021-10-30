package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public abstract class StmtNode extends ASTNode{
    public Type retType;
    public StmtNode(position pos){
        super(pos);
    }
}
