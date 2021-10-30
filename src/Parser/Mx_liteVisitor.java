// Generated from /Users/luohaotian/IdeaProjects/compiler/src/Mx_lite.g4 by ANTLR 4.9.1

package Parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Mx_liteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Mx_liteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Mx_liteParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#subProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubProgram(Mx_liteParser.SubProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(Mx_liteParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#lambdaDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaDef(Mx_liteParser.LambdaDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#functionparameterDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionparameterDef(Mx_liteParser.FunctionparameterDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(Mx_liteParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(Mx_liteParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Mx_liteParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(Mx_liteParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(Mx_liteParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(Mx_liteParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(Mx_liteParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(Mx_liteParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link Mx_liteParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(Mx_liteParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#forinit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForinit(Mx_liteParser.ForinitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#forstop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstop(Mx_liteParser.ForstopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#declarationStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStmt(Mx_liteParser.DeclarationStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(Mx_liteParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#subClassDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubClassDecl(Mx_liteParser.SubClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExpr(Mx_liteParser.ConstExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(Mx_liteParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(Mx_liteParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(Mx_liteParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(Mx_liteParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccessExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessExpr(Mx_liteParser.MemberAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(Mx_liteParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ThisExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpr(Mx_liteParser.ThisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(Mx_liteParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(Mx_liteParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LambDefExpr}
	 * labeled alternative in {@link Mx_liteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambDefExpr(Mx_liteParser.LambDefExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(Mx_liteParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(Mx_liteParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WrongArrayCreator1}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrongArrayCreator1(Mx_liteParser.WrongArrayCreator1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code WrongArrayCreator2}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrongArrayCreator2(Mx_liteParser.WrongArrayCreator2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code NewArrayCreator}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayCreator(Mx_liteParser.NewArrayCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewClass}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClass(Mx_liteParser.NewClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewNArray}
	 * labeled alternative in {@link Mx_liteParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewNArray(Mx_liteParser.NewNArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(Mx_liteParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(Mx_liteParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(Mx_liteParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#builtinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinType(Mx_liteParser.BuiltinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mx_liteParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(Mx_liteParser.ConstantContext ctx);
}