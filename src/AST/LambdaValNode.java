package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class LambdaValNode extends ASTNode{
    //public ParaListNode paraListNode;
    public ArrayList<VarDefNode> var_defs = new ArrayList<>();
    public SuiteNode suiteNode;
    public ExprListNode exprListNode;
    public ReturnTypeNode returnTypeNode;
    public LambdaValNode(ArrayList<VarDefNode> var, SuiteNode _suiteNode , ExprListNode _exprListNode , position pos){
        super(pos);
//        paraListNode = _paralistNode;
        var_defs = var;
        suiteNode = _suiteNode;
        exprListNode = _exprListNode;
    }
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}