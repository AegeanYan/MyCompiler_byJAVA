package Util;

import AST.ReturnTypeNode;
import AST.VarTypeNode;
import MIR.register;
import Util.error.semanticError;

import java.util.HashMap;

public class Scope {

    public HashMap<String, VarTypeNode> Var_Table;
    public Scope parentScope;


    public Scope(Scope parentScope) {
        Var_Table = new HashMap<>();
        this.parentScope = parentScope;
    }

    public Scope parentScope() {
        return parentScope;
    }

    public VarTypeNode fetch_VarType(String id){
        if (Var_Table.containsKey(id))return Var_Table.get(id);
        else if (this.parentScope != null) return parentScope.fetch_VarType(id);
        else return null;
    }



    public boolean contain_Var(String id){
        return Var_Table.containsKey(id);
    }

    public void add_Var(String id , VarTypeNode type){
        Var_Table.put(id,  type);
    }
}
