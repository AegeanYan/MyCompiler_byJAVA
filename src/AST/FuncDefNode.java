package AST;

import java.util.ArrayList;

import Util.Type;
import Util.position;
public class FuncDefNode extends DeclrNode{
    public ReturnTypeNode retnode;
    public String basic_type;
    public String name;
    public ArrayList<VarDefNode> paralist;
    public SuiteNode suite;
    public boolean hasreturn;
    public FuncDefNode(ReturnTypeNode _retnode ,String basica , String _name , ArrayList<VarDefNode> _paralist, SuiteNode _suite , position pos){
        super(pos);
        basic_type = basica;
        name = _name;
        retnode = _retnode;
        paralist = _paralist;
        suite = _suite;
    }

    @Override
    public  void accept(ASTVisitor visitor){visitor.visit(this);}
}
