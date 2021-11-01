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
        //
    }

    @Override
    public void visit(DeclStmtNode node) {
        node.var_defs.forEach(cd->cd.accept(this));
    }

    @Override
    public void visit(FuncDefNode node) {
        currentScope = new Scope(currentScope);
        func_stack.push(node);
        if (node.retnode != null && !(node.retnode instanceof VoidTypeNode) && !gScope.contain_Class(node.retnode.retType))throw new SemanticError("Undefined func retype " + node.name , node.pos);
        if (node.paralist != null)node.paralist.forEach(cd->cd.accept(this));
        if (node.suite.stmts != null)node.suite.stmts.forEach(cd->{if (cd!=null)cd.accept(this);});
        if (node.retnode != null && !(Objects.equals(node.retnode.retType, "void")) && !node.name.equals("main") && !node.hasreturn)throw new SemanticError("lack return " + node.name , node.pos);
        func_stack.pop();
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(ClassDeclNode node) {
        currentScope = gScope.Class_Table.get(node.name);
        now_class = node.name;
        for (DeclrNode decl : node.declrs){
            if (decl instanceof DeclStmtNode){
                for (VarDefNode vardef : ((DeclStmtNode) decl).var_defs){
                    if (!gScope.contain_Class(vardef.type.id))throw new SemanticError("Undefined class"+vardef.type.id , node.pos);
                    if (vardef.init != null){
                        vardef.init.accept(this);
                        if (!vardef.init.expr_ret.retType.equals("null") && !vardef.init.expr_ret.isEqual(null_type) && !vardef.init.expr_ret.isEqual(vardef.type) && !vardef.init.expr_ret.retType.equals(vardef.type.retType))throw new SemanticError("type not match in class" , node.pos);
                    }
                }
            }
            if (decl instanceof FuncDefNode){
                decl.accept(this);
                if (((FuncDefNode) decl).retnode != null && ((FuncDefNode) decl).name.equals(node.name))throw new SemanticError("Constructor error" , node.pos);
            }
        }
        currentScope = currentScope.parentScope;
        now_class = null;
    }

    @Override
    public void visit(VarDefNode node) {
        if (currentScope.contain_Var(node.id) || gScope.contain_Class(node.id))throw new SemanticError("Duplicate Var name" + node.id , node.pos);
        else if (!gScope.contain_Class(node.type.id))throw new SemanticError("no such Class" + node.type.id , node.pos);
        else {
            if (node.init != null){
                node.init.accept(this);
                if (!node.init.expr_ret.retType.equals("null") && !node.init.expr_ret.isEqual(null_type) && !node.init.expr_ret.isEqual(node.type) && !node.init.expr_ret.retType.equals(node.type.retType)) throw new SemanticError("Type not same in vardecl"+node.id , node.pos);
                if (node.type instanceof ArrayTypeNode){
                    if (!(node.init.expr_ret instanceof ArrayTypeNode) || ((ArrayTypeNode) node.type).dims != ((ArrayTypeNode) node.init.expr_ret).dims)throw new SemanticError("Type dismatch in vardecl"+node.id , node.pos);
                }
            }
            currentScope.add_Var(node.id , node.type);
        }
    }

    @Override
    public void visit(ReturnTypeNode node) {
        //
    }

    @Override
    public void visit(BuiltinTypeNode node) {
        //
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
        if (loops == 0)throw new SemanticError("continue false" , node.pos);
    }

    @Override
    public void visit(BreakStmtNode node) {
        if (loops == 0)throw new SemanticError("break false" , node.pos);
    }

    @Override
    public void visit(CondStmtNode node) {
        if (node.condi == null)throw new SemanticError("cond in IF null" , node.pos);
        node.condi.accept(this);
        if (!node.condi.expr_ret.retType.equals("bool") && !node.condi.expr_ret.isEqual(bool_type))throw new SemanticError("cond in IF not bool" , node.pos);
        currentScope = new Scope(currentScope);
        if (node.if_stmt != null)node.if_stmt.accept(this);
        currentScope = currentScope.parentScope;
        currentScope = new Scope(currentScope);
        if (node.else_stmt != null){node.else_stmt.accept(this);}
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(CtrlStmtNode node) {
        //
    }

    @Override
    public void visit(ExprStmtNode node) {
        node.expr.accept(this);
    }

    @Override
    public void visit(SuiteStmtNode node) {
        currentScope = new Scope(currentScope);
        if (node.suite.stmts != null)node.suite.stmts.forEach(cd->{if (cd != null)cd.accept(this);});
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(ForStmtNode node) {
        currentScope = new Scope(currentScope);
        loops++;
        if (node.init != null){
            if (!(node.init instanceof BinaryExprNode) && !(node.init instanceof DeclStmtNode))throw new SemanticError("init false" , node.pos);
            node.init.accept(this);
        }
        if (node.cond != null){
            node.cond.accept(this);
            if (!node.cond.expr_ret.isEqual(bool_type) && !node.cond.expr_ret.retType.equals("bool"))throw new SemanticError("cond false" , node.pos);
        }
        if (node.incre != null)node.incre.accept(this);
        if (!(node.stmt instanceof SemiStmtNode) && !(node.stmt == null)){
            if (node.stmt instanceof SuiteStmtNode) ((SuiteStmtNode) node.stmt).suite.stmts.forEach(cd->cd.accept(this));
            else node.stmt.accept(this);
        }
        loops--;
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(PrimeStmtNode node) {
        node.var_defs.forEach(cd->cd.accept(this));
    }

    @Override
    public void visit(RetStmtNode node) {
        if (func_stack.empty())throw new SemanticError("need a func to return", node.pos);
        if (func_stack.peek() instanceof FuncDefNode){
            FuncDefNode retfunc = (FuncDefNode) func_stack.peek();
            if (node.ret == null){
                if (retfunc.retnode != null && ! (Objects.equals(retfunc.retnode.retType, "void")))throw new SemanticError("return type not same"+retfunc.name , node.pos);
            }else {
                node.ret.accept(this);
                if (retfunc.retnode == null || retfunc.retnode.retType.equals("null") || (!retfunc.retnode.retType.equals(node.ret.expr_ret.retType) && !retfunc.retnode.isEqual(node.ret.expr_ret) && !(node.ret.expr_ret == null) && !(node.ret.expr_ret.retType.equals("null"))))throw new SemanticError("return type not same"+retfunc.name , node.pos);
                if (node.ret.expr_ret == null || node.ret.expr_ret.retType.equals("null")){
                    if (!(retfunc.retnode instanceof ArrayTypeNode) && !(retfunc.retnode instanceof ClassTypeNode))throw new SemanticError("null meet error" , node.pos);
                }
            }
            retfunc.hasreturn = true;
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
        //
    }

    @Override
    public void visit(StmtNode node) {
        //
    }

    @Override
    public void visit(WhileStmtNode node) {
        loops++;
        if (node.cond == null)throw new SemanticError("infinite loop" , node.pos);
        node.cond.accept(this);
        if (!node.cond.expr_ret.isEqual(bool_type) && !node.cond.expr_ret.retType.equals("bool"))throw new SemanticError("while para should be bool" , node.pos);
        if (!(node.stmt instanceof SemiStmtNode) && node.stmt != null){
            currentScope = new Scope(currentScope);
            node.stmt.accept(this);
            currentScope = currentScope.parentScope;
        }
        loops--;
    }

    @Override
    public void visit(UnaryExprNode node) {
        node.rhs.accept(this);
        switch (node.op){
            case NEG,POS,BNOT ->{
                if (!node.rhs.expr_ret.retType.equals("int") && !node.rhs.expr_ret.isEqual(int_type))throw new SemanticError("op should be int" , node.pos);
            }
            case LNOT -> {
                if (!node.rhs.expr_ret.retType.equals("bool") && !node.rhs.expr_ret.isEqual(bool_type)) throw new SemanticError("op should be bool" , node.pos);
            }
        }
        node.expr_ret = node.rhs.expr_ret;
        node.isAssignable = false;
    }

    @Override
    public void visit(BinaryExprNode node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        if (!node.lhs.expr_ret.retType.equals(node.rhs.expr_ret.retType) && !node.lhs.expr_ret.isEqual(node.rhs.expr_ret) && node.op != BinaryExprNode.BinaryOp.ASSIGNEQ && node.op != BinaryExprNode.BinaryOp.EQ && node.op != BinaryExprNode.BinaryOp.NEQ)throw new SemanticError("type dismatch in Binarexpr 1" , node.pos);
        ReturnTypeNode ltype = node.lhs.expr_ret;
        node.isAssignable = false;
        switch (node.op){
            case ADD , GT , LT , GEQ , LEQ-> {
                if (!ltype.retType.equals("int") && !ltype.isEqual(int_type) && !ltype.isEqual(string_type) && !ltype.retType.equals("string"))throw new SemanticError("add gt lt geq leq false" , node.pos);
            }
            case SUB , MUL , DIV , MOD , LSH , RSH , XOR , OR -> {
                if (!ltype.retType.equals("int") && !ltype.isEqual(int_type))throw new SemanticError("sub... false" , node.pos);
            }
            case ANDAND , OROR -> {
                if (!ltype.retType.equals("bool") && !ltype.isEqual(bool_type))throw new SemanticError("andand... false" , node.pos);
            }
            case ASSIGNEQ -> {
                if (!node.lhs.isAssignable)throw new SemanticError("not assignable in binar" , node.pos);
                if (!ltype.retType.equals(node.rhs.expr_ret.retType) && !ltype.isEqual(node.rhs.expr_ret) && !node.rhs.expr_ret.isEqual(null_type))throw new SemanticError("dismatched assign" , node.pos);
                if (ltype instanceof ArrayTypeNode){
                    if (!(node.rhs.expr_ret instanceof ArrayTypeNode) || !(((ArrayTypeNode) ltype).dims == ((ArrayTypeNode) node.rhs.expr_ret).dims))throw new SemanticError("dismatched assign" , node.pos);
                }
                if (node.rhs.expr_ret.retType.equals("null") && node.rhs.expr_ret.isEqual(null_type)){
                    if (ltype.isEqual(int_type) || ltype.isEqual(bool_type) || ltype.isEqual(null_type))throw new SemanticError("null cannot be assigned to ..." , node.pos);
                }
                node.isAssignable = true;
            }
            case EQ , NEQ ->{
                if (!ltype.retType.equals(node.rhs.expr_ret.retType) && !ltype.isEqual(node.rhs.expr_ret) && !node.rhs.expr_ret.isEqual(null_type) && !node.rhs.expr_ret.retType.equals("null"))throw new SemanticError("dismatched eq" , node.pos);
            }
        }
        switch (node.op){
            case ADD , SUB , MUL , DIV , MOD , LSH , RSH , AND , XOR , OR , ASSIGNEQ-> node.expr_ret = ltype;
            case GT , LT , GEQ  , LEQ , EQ , NEQ , ANDAND , OROR-> node.expr_ret = bool_type;
        }
    }

    @Override
    public void visit(ConstExprNode node) {
        //
    }

    @Override
    public void visit(FuncCallExprNode node) {
        FuncDefNode checkBase;
        String funcName = node.name;
        if (now_class == null){
            checkBase = gScope.fetch_Func(funcName);
        }else {
            checkBase = gScope.Class_Table.get(now_class).fetch_Func(funcName);
            if (checkBase == null)checkBase = gScope.fetch_Func(funcName);
        }
        if (checkBase == null)throw new SemanticError("have no this func"+funcName , node.pos);
        if (node.expr != null && node.expr.exprs != null)node.expr.exprs.forEach(cd -> cd.accept(this));
        if (checkBase.paralist == null || node.expr == null || node.expr.exprs == null){
            if (!((checkBase.paralist == null || checkBase.paralist.size() == 0) && node.expr == null))throw new SemanticError("wrong para in callfunc"+funcName , node.pos);
        }else {
            if (checkBase.paralist.size() != node.expr.exprs.size())throw new SemanticError("wrong para in callfunc"+funcName , node.pos);
            for (int i = 0; i < checkBase.paralist.size();++i){
                if (!checkBase.paralist.get(i).type.retType.equals(node.expr.exprs.get(i).expr_ret.retType) && !checkBase.paralist.get(i).type.isEqual(node.expr.exprs.get(i).expr_ret) && !node.expr.exprs.get(i).expr_ret.isEqual(null_type) && !node.expr.exprs.get(i).expr_ret.retType.equals("null"))throw new SemanticError("wrong para in callfunc"+funcName , node.pos);
            }
        }
        node.expr_ret = checkBase.retnode;
        node.expr_ret.retType = checkBase.retnode.retType;
        node.isAssignable = false;
    }

    @Override
    public void visit(IdExprNode node) {
        ReturnTypeNode id_type = currentScope.fetch_VarType(node.id.name);
        if (id_type == null)throw new SemanticError("Undefined var"+node.id.name , node.pos);
        node.isAssignable = true;
        node.expr_ret = id_type;
        node.expr_ret.retType = id_type.retType;
    }

    @Override
    public void visit(IndexExprNode node) {
        node.array.accept(this);
        if (!(node.array.expr_ret instanceof ArrayTypeNode))throw new SemanticError("Try to index not array type" , node.pos);
        node.index.accept(this);
        if ((!node.index.expr_ret.retType.equals("int") && !node.index.expr_ret.isEqual(int_type)) || node.index.expr_ret instanceof ArrayTypeNode)throw new SemanticError("Intex not int" , node.pos);
        if (((ArrayTypeNode)node.array.expr_ret).dims == 1) node.expr_ret = new ClassTypeNode(node.array.expr_ret.retType , node.pos);
        else node.expr_ret = new ArrayTypeNode(new ClassTypeNode(node.array.expr_ret.retType , pos) , ((ArrayTypeNode) node.array.expr_ret).dims - 1 , node.pos);
        node.expr_ret.retType = node.array.expr_ret.retType;
        node.isAssignable = true;
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
        node.object.accept(this);
        if (!gScope.contain_Class(node.object.expr_ret.retType))throw new SemanticError("no such class" + node.object.expr_ret.retType , node.pos);
        ClassDeclNode classdec;
        if (node.object.expr_ret instanceof ArrayTypeNode){
            if (!node.forfunc)throw new SemanticError("Array has no member" , node.pos);
            if (!node.member.name.equals("size"))throw new SemanticError("Array has only size" , node.pos);
            if (node.exprlist != null)throw new SemanticError("Arraysize have no para" ,  node.pos);
            node.funcInfo = array_size;
            node.expr_ret = int_type;
            node.expr_ret.retType = "int";
        }else {
            if (node.forfunc){
                node.funcInfo = gScope.Class_Table.get(node.object.expr_ret.retType).fetch_Func(node.member.name);
                if (node.funcInfo == null)throw new SemanticError("Class"+node.object.expr_ret.retType + "has no func" + node.member.name , node.pos);
                node.expr_ret = node.funcInfo.retnode;
                node.expr_ret.retType = node.funcInfo.retnode.retType;
            }else{
                node.expr_ret = gScope.Class_Table.get(node.object.expr_ret.retType).Var_Table.get(node.member.name);
                if (node.expr_ret == null)throw new SemanticError("Class" + node.object.expr_ret.retType + "has no var" + node.member.name , node.pos);
                node.isAssignable = true;
            }
        }
    }

    @Override
    public void visit(NewExprNode node) {
        node.creator.accept(this);
        if (node.creator instanceof NewNode){
            if(((NewNode) node.creator).dims > 0){node.expr_ret = new ArrayTypeNode(((NewNode) node.creator).types , ((NewNode) node.creator).dims , node.pos);node.expr_ret.retType = ((NewNode) node.creator).types.retType;}
            else node.expr_ret = new ClassTypeNode(((NewNode) node.creator).types.id , node.pos);
            node.isAssignable = false;
        }
    }

    @Override
    public void visit(PrefixExprNode node) {
        node.rhs.accept(this);
        if (!node.rhs.isAssignable)throw new SemanticError("not assignable int pre " , node.pos);
        switch (node.op){
            case INC , DEC ->{
                if (!node.rhs.expr_ret.retType.equals("int") && !node.rhs.expr_ret.isEqual(int_type))throw new SemanticError("op should be int" , node.pos);
            }
        }
        node.expr_ret = node.rhs.expr_ret;
        node.expr_ret.retType = node.rhs.expr_ret.retType;
        node.isAssignable = true;
    }

    @Override
    public void visit(NewNode node) {
        if (!gScope.contain_Class(node.types.id))throw new SemanticError("Undefined var in new" , node.pos);
        if (node.sizof != null){
            node.sizof.forEach(cd->{
                cd.accept(this);
                if (!cd.expr_ret.retType.equals("int") && !cd.expr_ret.isEqual(int_type)) throw new SemanticError("Array size should be int" , node.pos);
            });
        }
    }

    @Override
    public void visit(SubExprNode node) {
        node.expr.accept(this);
        node.expr_ret = node.expr.expr_ret;
        node.expr_ret.retType = node.expr.expr_ret.retType;
        node.isAssignable = node.expr.isAssignable;
    }

    @Override
    public void visit(SuffixExprNode node) {
        node.lhs.accept(this);
        if (!node.lhs.isAssignable)throw new SemanticError("not assignable in suf " , node.pos);
        switch (node.op){
            case INC , DEC ->{
                if (!node.lhs.expr_ret.retType.equals("int") && !node.lhs.expr_ret.isEqual(int_type))throw new SemanticError("op should be int" , node.pos);
            }
        }
        node.expr_ret = node.lhs.expr_ret;
        node.expr_ret.retType = node.lhs.expr_ret.retType;
        node.isAssignable = false;
    }

    @Override
    public void visit(ThisExprNode node) {
        if (now_class == null)throw new SemanticError("This only in classdef" , node.pos);
        node.expr_ret = new ClassTypeNode(now_class , node.pos);
        node.isAssignable = false;
    }

    @Override
    public void visit(ExprNode node) {
        //
    }

    @Override
    public void visit(IdValNode node) {
        //
    }

    @Override
    public void visit(IntValNode node) {
        //
    }

    @Override
    public void visit(StringValNode node) {
        //
    }

    @Override
    public void visit(BoolValNode node) {
        //
    }

    @Override
    public void visit(NullValNode node) {
        //
    }

    @Override
    public void visit(FuncValNode node) {
        //
    }

    @Override
    public void visit(LambdaValNode node) {
        currentScope = new Scope(currentScope);
        func_stack.push(node);
        if (node.var_defs != null)node.var_defs.forEach(cd->cd.accept(this));
        if (node.exprListNode != null)node.exprListNode.exprs.forEach(cd->cd.accept(this));
        if (node.var_defs == null || node.exprListNode == null){
            if (!((node.var_defs == null || node.var_defs.size() == 0) && (node.exprListNode == null || node.exprListNode.exprs.size() == 0)))throw new SemanticError("Lambda var error" , node.pos);
        }else {
            if (node.var_defs.size() != node.exprListNode.exprs.size())throw new SemanticError("Lambda var error", node.pos);
            for (int i = 0;i < node.var_defs.size();++i){
                if (!node.var_defs.get(i).type.isEqual(node.exprListNode.exprs.get(i).expr_ret) && !node.var_defs.get(i).type.retType.equals(node.exprListNode.exprs.get(i).expr_ret.retType))throw new SemanticError("Lambda var error" , node.pos);
            }
        }
        node.suiteNode.stmts.forEach(cd->cd.accept(this));
        if (node.returnTypeNode == null)throw new SemanticError("Lambda no ret" , node.pos);
        func_stack.pop();
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(ThisValNode node) {
        //
    }

    @Override
    public void visit(ConstantNode node) {
        //
    }

    @Override
    public void visit(ParaListNode node) {
        //
    }

    @Override
    public void visit(ExprListNode node) {
        //
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
