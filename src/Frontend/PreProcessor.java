package Frontend;
import AST.*;
import Util.globalScope;
import Util.position;
import Util.SemanticError;

public class PreProcessor implements ASTVisitor{

    public globalScope gScope;
    public PreProcessor(globalScope gScope){
        this.gScope = gScope;
    }
    @Override
    public void visit(RootNode node) {
        node.declrs.forEach(cd -> cd.accept(this));
        if (!this.gScope.contain_Func("main") || !this.gScope.fetch_Func("main").retnode.isEqual(new ClassTypeNode("int" , new position(-1,-1))))throw new SemanticError("main function not found or not int" , node.getPos());
        else if (this.gScope.fetch_Func("main").paralist != null) throw new SemanticError("main funtion para is not null" , node.getPos());
    }

    @Override
    public void visit(DeclrNode node) {

    }

    @Override
    public void visit(DeclStmtNode node) {

    }

    @Override
    public void visit(FuncDefNode node) {
        if (this.gScope.contain_Func(node.name) || this.gScope.contain_Class(node.name))throw new SemanticError("Duplicate func decl" + node.name , node.getPos());
        else if (node.retnode == null) throw new SemanticError("No Rettype" + node.name , node.getPos());
        else this.gScope.add_Func(node.name , node);
    }

    @Override
    public void visit(ClassDeclNode node) {
        if (this.gScope.contain_Class(node.name) || this.gScope.contain_Func(node.name))throw new SemanticError("Duplicate decl" + node.name , node.getPos());
        else {
            globalScope class_scope = new globalScope(gScope);
            for (DeclrNode tmp: node.declrs){
                if (tmp instanceof DeclStmtNode){
                    ((DeclStmtNode) tmp).var_defs.forEach(cd->{
                        if (class_scope.contain_Var(cd.id)) throw new SemanticError("Duplicate declr var" + cd.id +"in class", tmp.getPos());
                        else class_scope.add_Var(cd.id , cd.type);
                    });
                }
            }
            node.declrs.forEach(vd->{
                if (vd instanceof FuncDefNode){
                    if (((FuncDefNode) vd).retnode == null && !((FuncDefNode) vd).name.equals(node.name)) throw new SemanticError("Invalid Constructor in class" + node.name , vd.getPos());
                    else if (class_scope.contain_Func(((FuncDefNode) vd).name)) throw new SemanticError("Duplicate Dec Func" + ((FuncDefNode) vd).name + "in class" , vd.getPos());
                    else class_scope.add_Func(((FuncDefNode) vd).name , (FuncDefNode) vd);
                }
            });
            this.gScope.add_Class(node.name , class_scope);
        }
    }

    @Override
    public void visit(VarDefNode node) {

    }

    @Override
    public void visit(ReturnTypeNode node) {

    }

    @Override
    public void visit(BuiltinTypeNode node) {

    }

    @Override
    public void visit(ArrayTypeNode node) {

    }

    @Override
    public void visit(BoolTypeNode node) {

    }

    @Override
    public void visit(ClassTypeNode node) {

    }

    @Override
    public void visit(IntTypeNode node) {

    }

    @Override
    public void visit(VoidTypeNode node) {

    }

    @Override
    public void visit(StringTypeNode node) {

    }

    @Override
    public void visit(VarTypeNode node) {

    }

    @Override
    public void visit(ContiStmtNode node) {

    }

    @Override
    public void visit(BreakStmtNode node) {

    }

    @Override
    public void visit(CondStmtNode node) {

    }

    @Override
    public void visit(CtrlStmtNode node) {

    }

    @Override
    public void visit(ExprStmtNode node) {

    }

    @Override
    public void visit(SuiteStmtNode node) {

    }

    @Override
    public void visit(ForStmtNode node) {

    }

    @Override
    public void visit(PrimeStmtNode node) {

    }

    @Override
    public void visit(RetStmtNode node) {

    }

    @Override
    public void visit(SemiStmtNode node) {

    }

    @Override
    public void visit(StmtNode node) {

    }

    @Override
    public void visit(WhileStmtNode node) {

    }

    @Override
    public void visit(UnaryExprNode node) {

    }

    @Override
    public void visit(BinaryExprNode node) {

    }

    @Override
    public void visit(ConstExprNode node) {

    }

    @Override
    public void visit(FuncCallExprNode node) {

    }

    @Override
    public void visit(IdExprNode node) {

    }

    @Override
    public void visit(IndexExprNode node) {

    }

    @Override
    public void visit(LambDefExprNode node) {

    }

    @Override
    public void visit(MemberAccessExprNode node) {

    }

    @Override
    public void visit(NewExprNode node) {

    }

    @Override
    public void visit(PrefixExprNode node) {

    }

    @Override
    public void visit(NewNode node) {

    }

    @Override
    public void visit(SubExprNode node) {

    }

    @Override
    public void visit(SuffixExprNode node) {

    }

    @Override
    public void visit(ThisExprNode node) {

    }

    @Override
    public void visit(ExprNode node) {

    }

    @Override
    public void visit(IdValNode node) {

    }

    @Override
    public void visit(IntValNode node) {

    }

    @Override
    public void visit(StringValNode node) {

    }

    @Override
    public void visit(BoolValNode node) {

    }

    @Override
    public void visit(NullValNode node) {

    }

    @Override
    public void visit(NewArrayNode node) {

    }

    @Override
    public void visit(FuncValNode node) {

    }

    @Override
    public void visit(LambdaValNode node) {

    }

    @Override
    public void visit(ThisValNode node) {

    }

    @Override
    public void visit(ConstantNode node) {

    }

    @Override
    public void visit(ParaListNode node) {

    }

    @Override
    public void visit(ExprListNode node) {

    }

    @Override
    public void visit(SuiteNode node) {

    }

    @Override
    public void visit(VarDeclNode varDeclNode) {

    }

    @Override
    public void visit(ForInitNode forInitNode) {

    }

    @Override
    public void visit(ForStopNode forStopNode) {

    }

    @Override
    public void visit(CreatorNode creatorNode) {

    }
}
