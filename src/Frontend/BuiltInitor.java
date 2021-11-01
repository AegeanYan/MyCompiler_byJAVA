package Frontend;

import Util.globalScope;
import  AST.*;
import Util.position;

import java.util.ArrayList;

public class BuiltInitor {
    public globalScope init (globalScope initScope){
        ArrayList<VarDefNode> vardef_list = new ArrayList<>();
        vardef_list.add(new VarDefNode(new ClassTypeNode("string" , new position(-1 , -1)) , "str" , null , new position(-1 , -1)));
        FuncDefNode func = new FuncDefNode(new VoidTypeNode(new position(-1, -1)) ,"void" ,"print" , vardef_list , null , new position(-1,-1));
        initScope.add_Func("print" , func);

        func = new FuncDefNode(new VoidTypeNode(new position(-1,-1)) , "void" , "println" , vardef_list , null , new position(-1, -1));
        initScope.add_Func("println" , func);

        vardef_list = new ArrayList<>();
        vardef_list.add(new VarDefNode(new ClassTypeNode("int" , new position(-1 , -1)) , "n" , null , new position(-1 , -1)));
        func = new FuncDefNode(new VoidTypeNode(new position(-1 , -1)) , "void" , "printInt" , vardef_list , null , new position(-1 , -1));
        initScope.add_Func("printInt" , func);

        func = new FuncDefNode(new VoidTypeNode(new position(-1,-1)) , "void" , "printlnInt" , vardef_list , null , new position(-1, -1));
        initScope.add_Func("printlnInt" , func);

        func = new FuncDefNode(new ClassTypeNode("string" , new position(-1,-1)) , "string" , "getString" , null , null , new position(-1 , -1));
        initScope.add_Func("getString" , func);

        func = new FuncDefNode(new ClassTypeNode("int" , new position(-1,-1)) , "int" , "getInt" , null , null , new position(-1 , -1));
        initScope.add_Func("getInt" , func);

        vardef_list = new ArrayList<>();
        vardef_list.add(new VarDefNode(new ClassTypeNode("int" , new position(-1,-1)) , "i" , null , new position(-1,-1)));
        func = new FuncDefNode(new ClassTypeNode("string" , new position(-1,-1)) , "string" , "toString" , vardef_list , null , new position(-1 , -1));
        initScope.add_Func("toString" , func);

        initScope.add_Class("bool" , new globalScope(initScope));
        initScope.add_Class("int" , new globalScope(initScope));
        globalScope class_scope = new globalScope(initScope);
        vardef_list = new ArrayList<>();
        class_scope.add_Func("length" , new FuncDefNode(new ClassTypeNode("int" , new position(-1 , -1)) , "int" , "length" , null , null , new position(-1 , -1)));
        vardef_list.add(new VarDefNode(new ClassTypeNode("int" , new position(-1 , -1)) , "left" , null , new position(-1 , -1)));
        vardef_list.add(new VarDefNode(new ClassTypeNode("int" , new position(-1,-1)) , "right" , null , new position(-1,-1)));
        class_scope.add_Func("substring" , new FuncDefNode(new ClassTypeNode("string" , new position(-1 , -1)) , "string" , "substring" , vardef_list , null , new position(-1 , -1)) );
        class_scope.add_Func("parseInt" , new FuncDefNode(new ClassTypeNode("int" , new position(-1,-1)) , "int" , "parseInt" , null , null , new position(-1 , -1)));
        vardef_list = new ArrayList<>();
        vardef_list.add(new VarDefNode(new ClassTypeNode("int" , new position(-1,-1)) , "pos" , null , new position(-1,-1)));
        class_scope.add_Func("ord" ,new FuncDefNode(new ClassTypeNode("int" , new position(-1,-1)) , "int" , "ord" , vardef_list , null ,new position(-1,-1)));

        initScope.add_Class("string" , class_scope);
        return initScope;
    }
}
