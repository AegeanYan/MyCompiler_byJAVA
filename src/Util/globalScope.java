package Util;

import Util.error.semanticError;
import AST.*;
import java.util.HashMap;

public class globalScope extends Scope {
    public HashMap<String , FuncDefNode> Func_Table;
    public HashMap<String , globalScope> Class_Table;

    public globalScope(Scope parentScope) {
        super(parentScope);
        Func_Table = new HashMap<>();
        Class_Table = new HashMap<>();
    }

    public boolean contain_Func(String id){return Func_Table.containsKey(id);}
    public boolean contain_Class(String id){return Class_Table.containsKey(id);}
    public void add_Func(String id , FuncDefNode node){Func_Table.put(id , node);}
    public void add_Class(String id , globalScope scope){Class_Table.put(id , scope);}

    public FuncDefNode fetch_Func(String id){
        if (contain_Func(id))return this.Func_Table.get(id);
        else return null;
    }
}
