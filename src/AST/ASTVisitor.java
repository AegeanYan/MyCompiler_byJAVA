package AST;

public interface ASTVisitor {
    void visit(RootNode node);

    void visit(DeclrNode node);
    void visit(DeclStmtNode node);
    void visit(FuncDefNode node);
    void visit(ClassDeclNode node);
    void visit(VarDefNode node);

    void visit(ReturnTypeNode node);
    void visit(BuiltinTypeNode node);
    void visit(ArrayTypeNode node);
    void visit(BoolTypeNode node);
    void visit(ClassTypeNode node);
    void visit(IntTypeNode node);
    void visit(VoidTypeNode node);
    void visit(StringTypeNode node);
    void visit(VarTypeNode node);

    void visit(ContiStmtNode node);
    void visit(BreakStmtNode node);
    void visit(CondStmtNode node);
    void visit(CtrlStmtNode node);
    void visit(ExprStmtNode node);
    void visit(SuiteStmtNode node);
    void visit(ForStmtNode node);
    void visit(PrimeStmtNode node);
    void visit(RetStmtNode node);
    void visit(SemiStmtNode node);
    void visit(StmtNode node);
    void visit(WhileStmtNode node);

    void visit(UnaryExprNode node);
    void visit(BinaryExprNode node);
    void visit(ConstExprNode node);
    void visit(FuncCallExprNode node);
    void visit(IdExprNode node);
    void visit(IndexExprNode node);
    void visit(LambDefExprNode node);
    void visit(MemberAccessExprNode node);
    void visit(NewExprNode node);
    void visit(PrefixExprNode node);
    void visit(NewNode node);
    void visit(SubExprNode node);
    void visit(SuffixExprNode node);
    void visit(ThisExprNode node);
    void visit(ExprNode node);

    void visit(IdValNode node);
    void visit(IntValNode node);
    void visit(StringValNode node);
    void visit(BoolValNode node);
    void visit(NullValNode node);
    void visit(FuncValNode node);
    void visit(LambdaValNode node);
    void visit(ThisValNode node);
    void visit(ConstantNode node);

    void visit(ParaListNode node);
    void visit(ExprListNode node);
    void visit(SuiteNode node);

    void visit(VarDeclNode varDeclNode);

    void visit(ForInitNode forInitNode);

    void visit(ForStopNode forStopNode);

    void visit(CreatorNode creatorNode);
}
