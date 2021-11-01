package Frontend;

import AST.*;
import Parser.Mx_liteBaseVisitor;
import Parser.Mx_liteVisitor;
import Parser.Mx_liteParser;
import Util.SemanticError;
import Util.Type;
import Util.globalScope;
import Util.position;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ASTBuilder extends Mx_liteBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(Mx_liteParser.ProgramContext ctx) {
        RootNode root = new RootNode(new position(ctx));
        for (Mx_liteParser.SubProgramContext elements : ctx.subProgram()){
            if (elements.declarationStmt() != null) root.declrs.add((DeclStmtNode)visit(elements.declarationStmt()));
            if (elements.functionDef() != null) root.declrs.add((FuncDefNode)visit(elements.functionDef()));
            if (elements.classDecl() != null) root.declrs.add((ClassDeclNode)visit(elements.classDecl()));
        }
        return root;
    }

    @Override
    public ASTNode visitFunctionDef(Mx_liteParser.FunctionDefContext ctx) {
        ReturnTypeNode retype = (ctx.returnType() == null) ? null : (ReturnTypeNode) visit(ctx.returnType());
        String name = ctx.Identifier().toString();
        SuiteNode suite = (SuiteNode) visit(ctx.suite());
        String id;
        if (retype instanceof VoidTypeNode){id = "void";retype.retType = "void";}
        else if (retype instanceof IntTypeNode){id = "int";retype.retType = "int";}
        else if (retype instanceof BoolTypeNode){id = "bool";retype.retType = "bool";}
        else if (retype instanceof ClassTypeNode){id = ((ClassTypeNode) retype).id;retype.retType = id;}
        else if (retype instanceof ArrayTypeNode){id = ((ArrayTypeNode) retype).varType.id;retype.retType = id;}
        else id = null;
        //ParaListNode para = (ctx.functionparameterDef() == null) ? null : (ParaListNode) visit(ctx.functionparameterDef());
        ArrayList<VarDefNode> var_defs = new ArrayList<VarDefNode>();
        if (ctx.functionparameterDef() == null)return new FuncDefNode(retype , id , name , null , suite , new position(ctx));
        else {
            List<Mx_liteParser.VarTypeContext> vtp = ctx.functionparameterDef().varType();
            List<Mx_liteParser.VarDeclarationContext> vdp = ctx.functionparameterDef().varDeclaration();
            for (int i = 0;i < vtp.size();i++){
                if (vdp.get(i).expression() != null) var_defs.add(new VarDefNode((VarTypeNode) visit(vtp.get(i)) , vdp.get(i).Identifier().toString() , (ExprNode) visit(vdp.get(i).expression()) , new position(ctx)));
                else var_defs.add(new VarDefNode((VarTypeNode) visit(vtp.get(i)) , vdp.get(i).Identifier().toString() , null , new position(ctx)));
            }
        }
        return new FuncDefNode(retype ,id , name , var_defs , suite , new position(ctx));
    }

    @Override
    public ASTNode visitLambdaDef(Mx_liteParser.LambdaDefContext ctx) {
        ArrayList<VarDefNode> var_defs = new ArrayList<>();
        SuiteNode suite = (SuiteNode) visit(ctx.suite());
        ExprListNode exprList = (ctx.expressionList() == null) ? null : (ExprListNode)visit(ctx.expressionList());
        if (ctx.functionparameterDef() == null)return new LambdaValNode(null , suite , exprList , new position(ctx));
        else {
            List<Mx_liteParser.VarTypeContext> vtp = ctx.functionparameterDef().varType();
            List<Mx_liteParser.VarDeclarationContext> vdp = ctx.functionparameterDef().varDeclaration();
            for (int i = 0;i < vtp.size();i++){
                if (vdp.get(i).expression() != null) var_defs.add(new VarDefNode((VarTypeNode) visit(vtp.get(i)) , vdp.get(i).Identifier().toString() , (ExprNode) visit(vdp.get(i).expression()) , new position(ctx)));
                else var_defs.add(new VarDefNode((VarTypeNode) visit(vtp.get(i)) , vdp.get(i).Identifier().toString() , null , new position(ctx)));
            }
        }
        return new LambdaValNode(var_defs , suite , exprList , new position(ctx));//visit lambdadef时候返回一个lambdaval
    }

    @Override
    public ASTNode visitFunctionparameterDef(Mx_liteParser.FunctionparameterDefContext ctx) {
//        ArrayList<VarTypeNode> varlist = new ArrayList<>();
//        ArrayList<String> namelist = new ArrayList<>();
//        List<Mx_liteParser.VarTypeContext> vtp = ctx.varType();
//        List<TerminalNode> namep = ctx.Identifier();
        if (ctx.varType() == null)return null;
        ParaListNode para = new ParaListNode(new position(ctx));
        ctx.varType().forEach(cd -> para.par.add((VarTypeNode) visit(cd)));
        ctx.varDeclaration().forEach(vd -> para.decls.add((VarDeclNode) visit(vd)));
        return para;//应该用不到了，所有的paralist的地方直接用链表做了
    }

    @Override
    public ASTNode visitExpressionList(Mx_liteParser.ExpressionListContext ctx) {
        ExprListNode exprListNode = new ExprListNode(new position(ctx));
        ctx.expression().forEach(cd -> exprListNode.exprs.add((ExprNode) visit(cd)));
        return exprListNode;
    }

    @Override
    public ASTNode visitSuite(Mx_liteParser.SuiteContext ctx) {
        SuiteNode suite = new SuiteNode(new position(ctx));
        ctx.statement().forEach(cd -> {
            suite.stmts.add((StmtNode) visit(cd));
        });//这个地方变量声明是primenode而不是declstmt
        return suite;
    }

    @Override
    public ASTNode visitIfStmt(Mx_liteParser.IfStmtContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expression());
        StmtNode if_stmt = (StmtNode) visit(ctx.statement(0));
        StmtNode else_stmt = (ctx.statement(1) == null) ? null : (StmtNode) visit(ctx.statement(1));
        return new CondStmtNode(expr,if_stmt,else_stmt,new position(ctx));
    }

    @Override
    public ASTNode visitReturnStmt(Mx_liteParser.ReturnStmtContext ctx) {
        ExprNode expr = (ctx.expression() == null) ? null : (ExprNode) visit(ctx.expression());
        return new RetStmtNode(expr,new position(ctx));
    }

    @Override
    public ASTNode visitForStmt(Mx_liteParser.ForStmtContext ctx) {
//        ForInitNode init = (ctx.forinit() == null) ? null : (ForInitNode) visit(ctx.forinit());
//        ForStopNode stop = (ctx.forstop() == null) ? null : (ForStopNode) visit(ctx.forstop());
//        ExprNode expr = (ctx.expression() == null) ? null : (ExprNode) visit(ctx.expression());
        ASTNode init = (ctx.init == null) ? null :  visit(ctx.init);
        ExprNode stop = (ctx.cond == null) ? null : (ExprNode) visit(ctx.cond);
        ExprNode step = (ctx.step == null) ? null : (ExprNode) visit(ctx.step);
        return new ForStmtNode(init,stop,step,(StmtNode) visit(ctx.statement()) , new position(ctx));
    }

    @Override
    public ASTNode visitWhileStmt(Mx_liteParser.WhileStmtContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expression());
        StmtNode stmt = (StmtNode) visit(ctx.statement());
        return new WhileStmtNode(expr,stmt,new position(ctx));
    }

    @Override
    public ASTNode visitContinueStmt(Mx_liteParser.ContinueStmtContext ctx) {
        return new ContiStmtNode(new position(ctx));
    }

    @Override
    public ASTNode visitBreakStmt(Mx_liteParser.BreakStmtContext ctx) {
        return new BreakStmtNode(new position(ctx));
    }

    @Override
    public ASTNode visitDeclarationStmt(Mx_liteParser.DeclarationStmtContext ctx) {
//        VarTypeNode varType = (VarTypeNode) visit(ctx.varDef().varType());
//        ArrayList<VarDefNode> var_defs = new ArrayList<>();
//        for (Mx_liteParser.VarDeclarationContext element : ctx.varDef().varDeclaration()){
//            String id = element.Identifier().getText();
//            ExprNode init = (element.expression() == null) ? null : (ExprNode) visit(element.expression());
//            var_defs.add(new VarDefNode(varType , id , init , new position(ctx)));
//        }
//        return new DeclStmtNode(var_defs , new position(ctx));
        return visit(ctx.varDef());
    }

    @Override
    public ASTNode visitClassDecl(Mx_liteParser.ClassDeclContext ctx) {
        ClassDeclNode clas = new ClassDeclNode((ctx.Identifier().toString()) , new position(ctx));
        for (Mx_liteParser.SubClassDeclContext elements : ctx.subClassDecl()){
            if (elements.declarationStmt() != null)clas.declrs.add((DeclStmtNode) visit(elements.declarationStmt()));
            else if (elements.functionDef() != null)clas.declrs.add((FuncDefNode) visit(elements.functionDef()));
        }
        return clas;
    }

    @Override
    public ASTNode visitConstExpr(Mx_liteParser.ConstExprContext ctx) {
        return new ConstExprNode(((ConstantNode) visit(ctx.constant())),new position(ctx));
    }

    @Override
    public ASTNode visitIdExpr(Mx_liteParser.IdExprContext ctx) {
        return new IdExprNode(new IdValNode(ctx.Identifier().toString() , new position(-1,-1)) , new position(ctx));
    }

    @Override
    public ASTNode visitSubExpr(Mx_liteParser.SubExprContext ctx) {
        return new SubExprNode((ExprNode) visit(ctx.expression()) , new position(ctx));
    }

    @Override
    public ASTNode visitBinaryExpr(Mx_liteParser.BinaryExprContext ctx) {
        String op = ctx.op.getText();
        BinaryExprNode.BinaryOp operat = switch (op){
            case ">" -> BinaryExprNode.BinaryOp.GT;
            case "<" -> BinaryExprNode.BinaryOp.LT;
            case ">=" -> BinaryExprNode.BinaryOp.GEQ;
            case "<=" -> BinaryExprNode.BinaryOp.LEQ;
            case "==" -> BinaryExprNode.BinaryOp.EQ;
            case "!=" -> BinaryExprNode.BinaryOp.NEQ;
            case ">>" -> BinaryExprNode.BinaryOp.RSH;
            case "<<" -> BinaryExprNode.BinaryOp.LSH;
            case "*" -> BinaryExprNode.BinaryOp.MUL;
            case "/" -> BinaryExprNode.BinaryOp.DIV;
            case "%" -> BinaryExprNode.BinaryOp.MOD;
            case "+" -> BinaryExprNode.BinaryOp.ADD;
            case "-" -> BinaryExprNode.BinaryOp.SUB;
            case "&" -> BinaryExprNode.BinaryOp.AND;
            case "^" -> BinaryExprNode.BinaryOp.XOR;
            case "|" -> BinaryExprNode.BinaryOp.OR;
            case "&&" -> BinaryExprNode.BinaryOp.ANDAND;
            case "||" -> BinaryExprNode.BinaryOp.OROR;
            case "=" -> BinaryExprNode.BinaryOp.ASSIGNEQ;
            default -> throw new RuntimeException("[debug] binar");
        };
        return new BinaryExprNode(((ExprNode) visit(ctx.expression(0))) , (ExprNode) visit(ctx.expression(1)) , operat , new position(ctx));
    }

    @Override
    public ASTNode visitNewExpr(Mx_liteParser.NewExprContext ctx) {
        return new NewExprNode((CreatorNode) visit(ctx.creator()) , new position(ctx));
    }

    @Override
    public ASTNode visitMemberAccessExpr(Mx_liteParser.MemberAccessExprContext ctx) {
        ExprListNode exprlist = (ctx.expressionList() == null) ? null : (ExprListNode) visit(ctx.expressionList());
        MemberAccessExprNode ret = new MemberAccessExprNode(((ExprNode) visit(ctx.expression())) , new IdValNode(ctx.Identifier().toString() , new position(ctx)) , exprlist , new position(ctx));
        if (ctx.LeftParen().size() == 0){
            ret.forfunc = false;
        }
        else {
            ret.forfunc = true;
        }
        return ret;
    }

    @Override
    public ASTNode visitUnaryExpr(Mx_liteParser.UnaryExprContext ctx) {
        String op = ctx.op.getText();
        UnaryExprNode.UnaryOp operat = switch (op){
            case "!" -> UnaryExprNode.UnaryOp.LNOT;
            case "~" -> UnaryExprNode.UnaryOp.BNOT;
            case "+" -> UnaryExprNode.UnaryOp.POS;
            case "-" -> UnaryExprNode.UnaryOp.NEG;
            default -> throw new RuntimeException("[debug] unar");
        };
        return new UnaryExprNode(operat , (ExprNode) visit(ctx.expression()) , new position(ctx));
    }

    @Override
    public ASTNode visitThisExpr(Mx_liteParser.ThisExprContext ctx) {
        return new ThisExprNode(((ThisValNode) visit(ctx.This())) , new position(ctx));
    }

    @Override
    public ASTNode visitIndexExpr(Mx_liteParser.IndexExprContext ctx) {
        return new IndexExprNode(((ExprNode) visit(ctx.array)),(ExprNode) visit(ctx.index),new position(ctx));
    }

    @Override
    public ASTNode visitFuncCallExpr(Mx_liteParser.FuncCallExprContext ctx) {
        FuncCallExprNode funcall = new FuncCallExprNode(new position(ctx));
        funcall.name = (String) ctx.Identifier().toString();
        funcall.expr = (ctx.expressionList() == null) ? null : (ExprListNode) visit(ctx.expressionList());

        return funcall;
    }

    @Override
    public ASTNode visitLambDefExpr(Mx_liteParser.LambDefExprContext ctx) {
        return new LambDefExprNode(((LambdaValNode) visit(ctx.lambdaDef())) , new position(ctx));
    }

    @Override
    public ASTNode visitVarDef(Mx_liteParser.VarDefContext ctx) {
        VarTypeNode varType = (VarTypeNode) visit(ctx.varType());
        ArrayList<VarDefNode> var_defs = new ArrayList<>();
        for (Mx_liteParser.VarDeclarationContext element : ctx.varDeclaration()){
            String id = element.Identifier().getText();
            ExprNode init = (element.expression() == null) ? null : (ExprNode) visit(element.expression());
            var_defs.add(new VarDefNode(varType , id , init , new position(ctx)));
        }
        return new DeclStmtNode(var_defs , new position(ctx));//访问vardef返回一个Declstmtnode
    }

    @Override
    public ASTNode visitVarDeclaration(Mx_liteParser.VarDeclarationContext ctx) {
        ExprNode expr = (ctx.expression() == null) ? null : (ExprNode) visit(ctx.expression());
        return new VarDeclNode(visit(ctx.Identifier()).toString() , expr , new position(ctx));
    }

    @Override
    public ASTNode visitWrongArrayCreator1(Mx_liteParser.WrongArrayCreator1Context ctx) {
        throw new RuntimeException("[Bug] wrongarray1");
    }

    @Override
    public ASTNode visitWrongArrayCreator2(Mx_liteParser.WrongArrayCreator2Context ctx) {
        throw new RuntimeException("[bug] wrongarray2");
    }

    @Override
    public ASTNode visitNewArrayCreator(Mx_liteParser.NewArrayCreatorContext ctx) {
        ArrayList<ExprNode> siz = new ArrayList<ExprNode>();
        ctx.expression().forEach(cd -> siz.add((ExprNode) visit(cd)));
        int dim = (ctx.getChildCount() - siz.size() - 1) / 2;
        return new NewNode((BuiltinTypeNode) visit(ctx.builtinType()) , siz , dim , new position(ctx));
    }

    @Override
    public ASTNode visitNewClass(Mx_liteParser.NewClassContext ctx) {
        return new NewNode((BuiltinTypeNode) visit(ctx.builtinType()) , null , 0 , new position(ctx));
    }

    @Override
    public ASTNode visitNewNArray(Mx_liteParser.NewNArrayContext ctx) {
        return new NewNode((BuiltinTypeNode) visit(ctx.builtinType()) , null , 0 , new position(ctx));
    }

    @Override
    public ASTNode visitReturnType(Mx_liteParser.ReturnTypeContext ctx) {
//        if (ctx.Void() != null) return new VoidTypeNode(new position(ctx));
//        else if (ctx.varType().arrayType() != null)return new ArrayTypeNode((VarTypeNode) visit(ctx.varType()) , new position(ctx));
//        else if (ctx.varType().builtinType() != null){
//            if (ctx.varType().builtinType().Int() != null)return new IntTypeNode(new position(ctx));
//            else if (ctx.varType().builtinType().Bool() != null)return new BoolTypeNode(new position(ctx));
//            else if (ctx.varType().builtinType().String() != null)return new StringTypeNode(new position(ctx));
//            else return new ClassTypeNode(ctx.varType().builtinType().Identifier().toString() , new position(ctx));
//        }else return null;
        if (ctx.Void() != null) return new VoidTypeNode(new position(ctx));
        else if (ctx.varType() != null) return visit(ctx.varType());
        else return null;
    }

    @Override
    public ASTNode visitVarType(Mx_liteParser.VarTypeContext ctx) {
//        if (ctx.arrayType() != null){
//            return new ArrayTypeNode((VarTypeNode) visit(ctx) , new position(ctx));
//        }else {
//            if (ctx.builtinType().Int() != null)return new IntTypeNode(new position(ctx));
//            else if (ctx.builtinType().Bool() != null)return new BoolTypeNode(new position(ctx));
//            else if (ctx.builtinType().String() != null)return new StringTypeNode(new position(ctx));
//            else return new ClassTypeNode(ctx.builtinType().Identifier().toString() , new position(ctx));
//        }
        if (ctx.arrayType() != null)return visit(ctx.arrayType());
        else if (ctx.builtinType() != null)return visit(ctx.builtinType());
        else return null;
    }

    @Override
    public ASTNode visitArrayType(Mx_liteParser.ArrayTypeContext ctx) {
        VarTypeNode type;
        if (ctx.arrayType() != null)type = (VarTypeNode) visit(ctx.arrayType());
        else type = (VarTypeNode) visit(ctx.builtinType());
        return new ArrayTypeNode(type , new position(ctx));
    }

    @Override
    public ASTNode visitBuiltinType(Mx_liteParser.BuiltinTypeContext ctx) {
        position pos = new position(ctx);
        if (ctx.Int() != null)return new IntTypeNode(pos);
        else if (ctx.Bool() != null) return new BoolTypeNode(pos);
        else if (ctx.String() != null) return new StringTypeNode(pos);
        else if (ctx.Identifier() != null) return new ClassTypeNode(ctx.Identifier().toString() , pos);
        else return null;
    }

    @Override
    public ASTNode visitConstant(Mx_liteParser.ConstantContext ctx) {
        position pos = new position(ctx);
        if (ctx.DecimalInteger() != null) return new IntValNode(Long.parseLong(ctx.DecimalInteger().toString()), new position(ctx));
        else if (ctx.StringConstant() != null) return new StringValNode(ctx.StringConstant().toString() , new position(ctx));
        else if (ctx.Boolconstant() != null) {
            if (Objects.equals(ctx.Boolconstant().toString(), "true"))return new BoolValNode(true , new position(ctx));
            else return new BoolValNode(false , new position(ctx));
        }
        else if (ctx.Nullconstant() != null) return new NullValNode(new position(ctx));
        else return null;
    }
    @Override
    public ASTNode visitPrimeStmt(Mx_liteParser.PrimeStmtContext ctx) {
        VarTypeNode varType = (VarTypeNode) visit(ctx.varDef().varType());
        ArrayList<VarDefNode> var_defs = new ArrayList<>();
        for (Mx_liteParser.VarDeclarationContext element : ctx.varDef().varDeclaration()){
            String id = element.Identifier().getText();
            ExprNode init = (element.expression() == null) ? null : (ExprNode) visit(element.expression());
            var_defs.add(new VarDefNode(varType , id , init , new position(ctx)));
        }
        return new PrimeStmtNode(var_defs , new position(ctx));//访问vardef返回一个Declstmtnode
    }
    @Override
    public ASTNode visitExpressionStmt(Mx_liteParser.ExpressionStmtContext ctx) {
        return new ExprStmtNode((ExprNode) visit(ctx.expression()) , new position(ctx));
    }
    @Override
    public ASTNode visitSuiteStmt(Mx_liteParser.SuiteStmtContext ctx) {
        return new SuiteStmtNode((SuiteNode) visit(ctx.suite()) , new position(ctx));
    }
    @Override
    public ASTNode visitSuffixExpr(Mx_liteParser.SuffixExprContext ctx) {
        String op = ctx.op.getText();
        SuffixExprNode.SufOp operat = switch (op){
            case "++" -> SuffixExprNode.SufOp.INC;
            case "--" -> SuffixExprNode.SufOp.DEC;
            default -> throw new RuntimeException("[debug] Suffix");
        };
        return new SuffixExprNode((ExprNode) visit(ctx.expression()),operat , new position(ctx));
    }
    @Override
    public ASTNode visitPrefixExpr(Mx_liteParser.PrefixExprContext ctx) {
        String op = ctx.op.getText();
        PrefixExprNode.PreOp operat = switch (op){
            case "++" -> PrefixExprNode.PreOp.INC;
            case "--" -> PrefixExprNode.PreOp.DEC;
            default -> throw new RuntimeException("[debug] Prefix");
        };
        return new PrefixExprNode((ExprNode) visit(ctx.expression()) , operat , new position(ctx));
    }
}
