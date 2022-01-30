//===----------------------------------------------------------------------===//
//
// This class defines the interface that one who uses a Value must implement.
// Each instance of the Value class keeps track of what User's have handles
// to it.
//
//  * Instructions are the largest class of Users.
//  * Constants may be users of other constants (think arrays and stuff)
//
//===----------------------------------------------------------------------===//
package LLVMIR.BasicClass;

import LLVMIR.Type.ArrayType;
import LLVMIR.Type.IRType;

import java.util.ArrayList;
import java.util.HashMap;

public class Value {
    public String name;
    public IRType type;
    public ArrayList<User> userList;
    public static HashMap<String , Integer> rename = new HashMap<>();

    public Value(String name , IRType type){
        this.name = name;
        this.type = type;
        this.userList = new ArrayList<>();
    }

    public String renaming(String name){//
        if (name.equals("func_main"))return "main";
        Integer count = rename.get(name);
        if (count == null)count = 0;
        else count ++;
        rename.put(name , count);
        return (count == 0) ? name : name + count;
    }

    public static void refresh(){//
        Integer count = rename.get("str");
        rename.clear();
        rename.put("str" , count);
    }
    public void addUser(User user){
        this.userList.add(user);
    }
    public String getName(){
        return "%" + this.name;
    }
    public String getTypeName(){
        return this.type.toString() + " " + this.getName();
    }

    public String toString(){
        throw new RuntimeException("using base value toString");
    }
}
