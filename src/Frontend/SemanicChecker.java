package Frontend;


import AST.*;
import Util.Scope;
import Util.SemanticError;
import Util.globalScope;
import Util.position;

import java.util.Objects;
import java.util.Stack;

public class SemanicChecker implements ASTVisitor {
    public Scope currentScope;
    public globalScope gScope;
    public ReturnTypeNode null_type , void_type , bool_type , string_type , int_type;
    public String now_class;
    public FuncDefNode array_size;
    public Stack<ASTNode> func_stack;
    public int loops;
    position pos = new position(-1,-1);

    public SemanicChecker(globalScope gscope){
        this.gScope = gscope;
        this.currentScope = this.gScope;
        int_type = new ClassTypeNode("int" , pos);
        null_type = new ClassTypeNode("null" , pos);
        void_type = new VoidTypeNode(pos);
        bool_type = new ClassTypeNode("bool" , pos);
        string_type = new ClassTypeNode("string" , pos);
        now_class = null;
        func_stack = new Stack<>();
        loops = 0;
        array_size = new FuncDefNode(new ClassTypeNode("int" , pos) , "int" ,"size" , null  , null , pos);
    }

    @Override
    public void visit(RootNode node) {
        node.declrs.forEach(cd -> cd.accept(this));
    }

    @Override
    public void visit(DeclrNode node) {

    }

    @Override
    public void visit(DeclStmtNode node) {
        node.var_defs.forEach(cd->cd.accept(this));
    }

    @Override
    public void visit(FuncDefNode node) {
        currentScope = new Scope(currentScope);
        func_stack.push(node);
        if (node.retnode != null && !(node.retnode instanceof VoidTypeNode) && !gScope.contain_Class(node.basic_type))throw new SemanticError("Undefined func retype" + node.name , node.pos);
        if (node.paralist != null)node.paralist.forEach(cd->cd.accept(this));
        if (node.suite.stmts != null)node.suite.stmts.forEach(cd->cd.accept(this));
        if (node.retnode != null && !(Objects.equals(node.basic_type, "void")) && !node.name.equals("main") && !node.hasreturn)throw new SemanticError("lack return" + node.name , node.pos);
        func_stack.pop();
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(ClassDeclNode node) {

    }

    @Override
    public void visit(VarDefNode node) {
        if (currentScope.contain_Var(node.id))throw new SemanticError("Duplicate Var name" + node.id , node.pos);
        else if (!gScope.contain_Class(node.type.id))throw new SemanticError("no such Class" + node.type.id , node.pos);
        else {
            if (node.init != null){
                node.init.accept(this);
                if (!node.init.expr_ret.isEqual(null_type) && !node.init.expr_ret.isEqual(node.type)) throw new SemanticError("Type not same in vardecl"+node.id , node.pos);
            }
            currentScope.add_Var(node.id , node.type);
        }
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
        if (func_stack.empty())throw new SemanticError("need a func to return", node.pos);
        if (func_stack.peek() instanceof FuncDefNode){
            FuncDefNode retfunc = (FuncDefNode) func_stack.peek();
            if (node.ret == null){
                if (retfunc.retnode != null && ! (Objects.equals(retfunc.basic_type, "void")))throw new SemanticError("return type not same"+retfunc.name , node.pos);
            }else {
                node.ret.accept(this);
                if (retfunc.retnode == null || (!retfunc.retnode.isEqual(node.ret.expr_ret) && !retfunc.retnode.isEqual(null_type)))throw new SemanticError("return type not same"+retfunc.name , node.pos);
            }
        }else {
            LambdaValNode retLamb = (LambdaValNode) func_stack.peek();
            if (node.ret == null)throw new SemanticError("Lamb must a return" , node.pos);
            node.ret.accept(this);
            if (retLamb.returnTypeNode == null)retLamb.returnTypeNode = node.ret.expr_ret;
            else if (!retLamb.returnTypeNode.isEqual(node.ret.expr_ret))throw new SemanticError("Lambda two returntype" , node.pos);
        }
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
        FuncDefNode base;
        if (node.)
    }

    @Override
    public void visit(IdExprNode node) {
        ReturnTypeNode id_type = currentScope.fetch_VarType(node.id.name);
        if (id_type == null)throw new SemanticError("Undefined var"+node.id.name , node.pos);
        node.isAssignable = true;
        node.expr_ret = id_type;
    }

    @Override
    public void visit(IndexExprNode node) {
        node.array.accept(this);
        if (!(node.array.expr_ret instanceof ArrayTypeNode))throw new SemanticError("Try to index not array type" , node.pos);
        node.index.accept(this);
        if (!node.index.expr_ret.isEqual(int_type))throw new SemanticError("Intex not int" , node.pos);
        if (((ArrayTypeNode)node.array.expr_ret).dims == 1) node.expr_ret = new ClassTypeNode(node.array.expr_ret.retType , node.pos);
        else node.expr_ret = new ArrayTypeNode()
    }

    @Override
    public void visit(LambDefExprNode node) {
        node.lamb.accept(this);
        node.expr_ret = node.lamb.returnTypeNode;
    }

    @Override
    public void visit(MemberAccessExprNode node) {
//        node.object.accept(this);
//        if (node.object.expr_ret instanceof ArrayTypeNode){
//            if (!node.forfunc)throw new SemanticError("Array has no members" , node.pos);
//            if (!node.member.name.equals("size"))throw new SemanticError("Array has only size() func" , node.pos);
//            node.funcInfo = array_size;
//        }else {
//            if (node.forfunc){
//                node.funcInfo = gScope.Class_Table.get(node.object.expr_ret.retType).fetch_Func(node.member.name);
//                if (node.funcInfo == null)throw new SemanticError("Class" + node.object.expr_ret.retType + "has no such func"+node.member.name , node.pos);
//            }else {
//                node.expr_ret = gScope.Class_Table.get(node.object.expr_ret.retType).Var_Table.get(node.member.name);
//                if (node.expr_ret == null)throw new SemanticError("Class"+node.object.expr_ret.retType +"has no such var" + node.member.name , node.pos);
//                node.isAssignable = true;
//            }
//        }

    }

    @Override
    public void visit(NewExprNode node) {
        node.creator.accept(this);
        if (node.creator instanceof NewNode){
            if(((NewNode) node.creator).dims > 0)node.expr_ret = new ArrayTypeNode(((NewNode) node.creator).types , ((NewNode) node.creator).dims , node.pos);
            else node.expr_ret = new ClassTypeNode(((NewNode) node.creator).types.id , node.pos);
            node.isAssignable = false;
        }
    }

    @Override
    public void visit(PrefixExprNode node) {

    }

    @Override
    public void visit(NewNode node) {
        if (!gScope.contain_Class(node.types.id))throw new SemanticError("Undefined var in new" , node.pos);
        if (node.sizof != null){
            node.sizof.forEach(cd->{
                cd.accept(this);
                if (!cd.expr_ret.isEqual(int_type)) throw new SemanticError("Array size should be int" , node.pos);
            });
        }
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
    public void visit(FuncValNode node) {

    }

    @Override
    public void visit(LambdaValNode node) {
        currentScope = new Scope(currentScope);
        func_stack.push(node);
        if (node.var_defs != null)node.var_defs.forEach(cd->cd.accept(this));
        if (node.exprListNode != null)node.exprListNode.exprs.forEach(cd->cd.accept(this));
        if (node.var_defs == null || node.exprListNode == null){
            if (!(node.var_defs == null && node.exprListNode == null))throw new SemanticError("Lambda var error" , node.pos);
        }else {
            if (node.var_defs.size() != node.exprListNode.exprs.size())throw new SemanticError("Lambda var error", node.pos);
            for (int i = 0;i < node.var_defs.size();++i){
                if (!node.var_defs.get(i).type.isEqual(node.exprListNode.exprs.get(i).expr_ret))throw new SemanticError("Lambda var error" , node.pos);
            }
        }
        node.suiteNode.stmts.forEach(cd->cd.accept(this));
        if (node.returnTypeNode == null)throw new SemanticError("Lambda no ret" , node.pos);
        func_stack.pop();
        currentScope = currentScope.parentScope;
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
