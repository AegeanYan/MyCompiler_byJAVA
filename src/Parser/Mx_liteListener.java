// Generated from /Users/luohaotian/IdeaProjects/compiler/src/Mx_lite.g4 by ANTLR 4.9.1

package Parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Mx_liteParser}.
 */
public interface Mx_liteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Mx_liteParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Mx_liteParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#subProgram}.
	 * @param ctx the parse tree
	 */
	void enterSubProgram(Mx_liteParser.SubProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#subProgram}.
	 * @param ctx the parse tree
	 */
	void exitSubProgram(Mx_liteParser.SubProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(Mx_liteParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(Mx_liteParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#lambdaDef}.
	 * @param ctx the parse tree
	 */
	void enterLambdaDef(Mx_liteParser.LambdaDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#lambdaDef}.
	 * @param ctx the parse tree
	 */
	void exitLambdaDef(Mx_liteParser.LambdaDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#functionparameterDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionparameterDef(Mx_liteParser.FunctionparameterDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#functionparameterDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionparameterDef(Mx_liteParser.FunctionparameterDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(Mx_liteParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(Mx_liteParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(Mx_liteParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(Mx_liteParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Mx_liteParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Mx_liteParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#suiteStmt}.
	 * @param ctx the parse tree
	 */
	void enterSuiteStmt(Mx_liteParser.SuiteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#suiteStmt}.
	 * @param ctx the parse tree
	 */
	void exitSuiteStmt(Mx_liteParser.SuiteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#expressionStmt}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(Mx_liteParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#expressionStmt}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(Mx_liteParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(Mx_liteParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(Mx_liteParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(Mx_liteParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(Mx_liteParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(Mx_liteParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(Mx_liteParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(Mx_liteParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(Mx_liteParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(Mx_liteParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(Mx_liteParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(Mx_liteParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(Mx_liteParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#primeStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrimeStmt(Mx_liteParser.PrimeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#primeStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrimeStmt(Mx_liteParser.PrimeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#declarationStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStmt(Mx_liteParser.DeclarationStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#declarationStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStmt(Mx_liteParser.DeclarationStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(Mx_liteParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(Mx_liteParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#subClassDecl}.
	 * @param ctx the parse tree
	 */
	void enterSubClassDecl(Mx_liteParser.SubClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#subClassDecl}.
	 * @param ctx the parse tree
	 */
	void exitSubClassDecl(Mx_liteParser.SubClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstExpr(Mx_liteParser.ConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstExpr(Mx_liteParser.ConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(Mx_liteParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(Mx_liteParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(Mx_liteParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(Mx_liteParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(Mx_liteParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(Mx_liteParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(Mx_liteParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(Mx_liteParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(Mx_liteParser.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(Mx_liteParser.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(Mx_liteParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(Mx_liteParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuffixExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixExpr(Mx_liteParser.SuffixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuffixExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixExpr(Mx_liteParser.SuffixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(Mx_liteParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(Mx_liteParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessExpr(Mx_liteParser.MemberAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessExpr(Mx_liteParser.MemberAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ThisExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(Mx_liteParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ThisExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(Mx_liteParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(Mx_liteParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(Mx_liteParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LambDefExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambDefExpr(Mx_liteParser.LambDefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LambDefExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambDefExpr(Mx_liteParser.LambDefExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(Mx_liteParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(Mx_liteParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(Mx_liteParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(Mx_liteParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WrongArrayCreator1}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterWrongArrayCreator1(Mx_liteParser.WrongArrayCreator1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code WrongArrayCreator1}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitWrongArrayCreator1(Mx_liteParser.WrongArrayCreator1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code WrongArrayCreator2}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterWrongArrayCreator2(Mx_liteParser.WrongArrayCreator2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code WrongArrayCreator2}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitWrongArrayCreator2(Mx_liteParser.WrongArrayCreator2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code NewArrayCreator}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayCreator(Mx_liteParser.NewArrayCreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewArrayCreator}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayCreator(Mx_liteParser.NewArrayCreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewClass}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(Mx_liteParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewClass}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(Mx_liteParser.NewClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewNArray}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterNewNArray(Mx_liteParser.NewNArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewNArray}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitNewNArray(Mx_liteParser.NewNArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(Mx_liteParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(Mx_liteParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(Mx_liteParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(Mx_liteParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(Mx_liteParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(Mx_liteParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinType(Mx_liteParser.BuiltinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#builtinType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinType(Mx_liteParser.BuiltinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mx_liteParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(Mx_liteParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mx_liteParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(Mx_liteParser.ConstantContext ctx);
}