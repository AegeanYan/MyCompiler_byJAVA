grammar Mx_lite;

@header{
package Parser;
}
program: subProgram*;
subProgram : declarationStmt | functionDef | classDecl;

functionDef: returnType? Identifier '(' functionparameterDef ')' suite;  //可以是构造函数

lambdaDef: '[&]' '(' functionparameterDef ')' '->' suite '(' expressionList? ')';

functionparameterDef : (varType varDeclaration (',' varType varDeclaration)*)?;

expressionList: expression (',' expression)*;

suite: '{' statement* '}';

statement
: suite
| declarationStmt
| controlStmt
| expression ';'
| ';'
;

controlStmt
: If '(' expression ')' trueStmt=statement (Else falseStmt=statement)?              #IfStmt
| Return expression? ';'                                                            #ReturnStmt
| For '(' init=forinit? ';' cond=forstop?';'step=expression?')'statement      #ForStmt
| While '(' expression ')' statement                                                #WhileStmt
| Continue ';'                                                                      #ContinueStmt
| Break ';'                                                                         #BreakStmt
;

forinit:expression | varDef;

forstop:expression;

declarationStmt: varDef ';';

classDecl: Class Identifier '{' subClassDecl* '}' ';';

subClassDecl:functionDef | declarationStmt;

expression
: Identifier            #IdExpr
| constant              #ConstExpr
| 'new' creator         #NewExpr
| Identifier '('expressionList?')'  #FuncCallExpr
| lambdaDef                  #LambDefExpr
| This                  #ThisExpr
| '('expression')'      #SubExpr
| expression '.' Identifier ('('expressionList?')')?                                                #MemberAccessExpr
| expression '.' '('Identifier ('('expressionList?')')? ')'                                                #MemberAccessExpr
| array=expression '[' index=expression ']'                                 #IndexExpr
//| expression '(' expressionList? ')'                                        #FunctionCallExpr

| expression op = ('++' | '--')                                             #UnaryExpr
| <assoc=right>
    op = ('++' | '--') expression                                           #UnaryExpr
| <assoc=right>
    op = ('+' | '-') expression                                             #UnaryExpr
| <assoc=right>
    op = ('!' | '~') expression                                             #UnaryExpr
| expression op = ('*' | '/' | '%') expression                              #BinaryExpr
| expression op = ('+' | '-') expression                                    #BinaryExpr
| expression op = ('<<' | '>>') expression                                  #BinaryExpr
| expression op = ('<' | '<=' | '>' | '>=') expression                      #BinaryExpr
| expression op = ('==' | '!=') expression                                  #BinaryExpr
| expression op = '&' expression                                            #BinaryExpr
| expression op = '^' expression                                            #BinaryExpr
| expression op = '|' expression                                            #BinaryExpr
| expression op = '&&' expression                                           #BinaryExpr
| expression op = '||' expression                                           #BinaryExpr
| <assoc=right> expression '=' expression                                   #BinaryExpr
;

varDef: varType varDeclaration (',' varDeclaration)*;
varDeclaration:Identifier ('=' expression)?;

creator
: builtinType ('['']')+('['expression']')*                   #WrongArrayCreator1
| builtinType ('['expression']')+('['']')+('['expression']')+ #WrongArrayCreator2
| builtinType ('['expression']')+('['']')*                    #NewArrayCreator
| builtinType '(' ')'                                         #NewClass
| builtinType                                                 #NewNArray
;

returnType: Void | varType;

varType: arrayType | builtinType;

arrayType: builtinType '[' ']' | arrayType '[' ']';

builtinType : Int | Bool | String | Identifier;   //identifier是class

constant
:DecimalInteger
| StringConstant
| Boolconstant
| Nullconstant
;

Boolconstant
: True | False;

Nullconstant: Null;
//reserved words
StringConstant
:'"' (. | BackSlash | DbQuotation)*? '"';

Int : 'int';
Bool : 'bool';
Void : 'void';
True : 'true';
False : 'false';
Null : 'null';
String : 'string';
If : 'if';
Else : 'else';
Return : 'return';
Class : 'class';
While : 'while';
For : 'for';
Break : 'break';
Continue : 'continue';
New : 'new';
This : 'this';
Dot : '.';
LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';
Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';
Plus : '+'; SelfPlus : '++'; Minus : '-'; SelfMinus : '--';
Mul : '*';
Div : '/';
Mod : '%';
And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||'; Caret : '^'; Not : '!'; Tilde : '~';
Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';
Assign : '=';
Equal : '==';
NotEqual : '!=';
BackSlash : '\\\\';
DbQuotation : '\\"';

Identifier
: [a-zA-Z] [a-zA-Z_0-9]* ;
//N
DecimalInteger
: [1-9] [0-9]* | '0'
;
Whitespace
: [ \t]+ -> skip
;
Newline
    :   (   '\r' '\n'?
        |   '\n'
)
-> skip
;
BlockComment
: '/*' .*? '*/' -> skip                   //？使得不贪婪了
;
LineComment
: '//' ~[\r\n]* -> skip
;