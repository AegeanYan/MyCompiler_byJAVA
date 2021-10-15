grammar Mx_lite;

program: (declarationStmt | functionDef | classDecl | lambdaDef)*;

functionDef: returnType? Identifier '(' functionparameterDef ')' suite;

lambdaDef: '[&]' '(' functionparameterDef ')' '->' suite '(' expressionList? ')';

functionparameterDef : (varType Identifier (',' varType Identifier)*)?;

expressionList: expression (',' expression)*;

suite: '{' statement* '}';

statement:
suite               #subBlock
| declarationStmt   #declaresth
| controlStmt       #controlstmt
| expression ';'    #expressions
| ';'               #semi
;

controlStmt
: If '(' expression ')' trueStmt=statement (Else falseStmt=statement)?              #if
| Return expression? ';'                                                            #return
| For '(' init=expression? ';' cond=expression?';'step=expression?')'statement      #for
| While '(' expression ')' statement                                                #while
| Continue ';'                                                                      #continue
| Break ';'                                                                         #break
;

declarationStmt: varDef ';';

classDecl: Class Identifier '{' (functionDef | declarationStmt)* '}' ';';

expression
: primary                                                                   #primaryy
| expression '.' Identifier                                                 #dot
| array=expression '[' index=expression ']'                                 #数组
| expression '(' expressionList? ')'                                        #函数调用//函数调用
| 'new' creator                                                             #new
| expression op = ('++' | '--')                                             #右自增自减
| <assoc=right>
    op = ('++' | '--') expression                                           #左自增自减
| <assoc=right>
    op = ('+' | '-') expression                                             #左加号或减号
| <assoc=right>
    op = ('!' | '~') expression                                             #不等于
| expression op = ('*' | '/' | '%') expression                              #乘除模
| expression op = ('+' | '-') expression                                    #加减
| expression op = ('<<' | '>>') expression                                  #移位
| expression op = ('<' | '<=' | '>' | '>=') expression                      #大于小于大于等于小于等于
| expression op = ('==' | '!=') expression                                  #逻辑等于和不等于
| expression op = '&' expression                                            #and
| expression op = '^' expression                                            #xor
| expression op = '|' expression                                            #or
| expression op = '&&' expression                                           #andand
| expression op = '||' expression                                           #oror
| <assoc=right> expression '=' expression                                   #expr等于
;

varDef: varType varDeclaration (',' varDeclaration)*;
varDeclaration:Identifier ('=' expression)?;

creator: builtinType ('[' expression? ']')+
| builtinType '(' ')'
| builtinType
;

returnType: Void | varType;

varType: varType '['']' | builtinType;

builtinType : Int | Bool | StringConstant | Identifier;

primary
:'('expression')'|Identifier|literal;

literal
:DecimalInteger | True | False | StringConstant | Null | This;

//reserved words
StringConstant
:'"' (. | BackSlash | DbQuotation)*? '"';

Int : 'int';
Bool : 'bool';
Void : 'void';
True : 'true';
False : 'false';
Null : 'null';
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