package LLVMIR;

import Backend.IRInterface;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.*;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class IRModule {
    public ArrayList<String> builtInFunctionName = new ArrayList<>();
    public ArrayList<String> customFunctionName  = new ArrayList<>();
    public ArrayList<String> customClassName  = new ArrayList<>();
    public ArrayList<String> staticDataName  = new ArrayList<>();
    public HashMap<String, IRFunction>  builtInFunctions = new HashMap<>();
    public HashMap<String, IRFunction>  customFunctions  = new HashMap<>();
    public HashMap<String, StructType> customClasses  = new HashMap<>();
    public HashMap<String, IRType>  staticData   = new HashMap<>();
    public ArrayList<Pair<String, VirtualReg>> strConstants = new ArrayList<>();
    public ArrayList<Pair<String , VirtualReg>> asmStrings = new ArrayList<>();
    public IRModule(){
        IRFunction function;
        builtInFunctionName.add("malloc");
        function = new IRFunction("malloc" , new PointerType(new IntegerType(8)));
        function.addParameter(new IntegerType(64));
        builtInFunctions.put("malloc" , function);

        builtInFunctionName.add("builtin_String_add_");
        function = new IRFunction("builtin_String_add_" , new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_add_" , function);

        builtInFunctionName.add("builtin_String_less_than_");
        function = new IRFunction("builtin_String_less_than_" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_less_than_" , function);

        builtInFunctionName.add("builtin_String_greater_than_");
        function = new IRFunction("builtin_String_greater_than_" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_greater_than_" , function);

        builtInFunctionName.add("builtin_String_greater_equal_");
        function = new IRFunction("builtin_String_greater_equal_" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_greater_equal_" , function);

        builtInFunctionName.add("builtin_String_less_equal_");
        function = new IRFunction("builtin_String_less_equal_" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_less_equal_" , function);

        builtInFunctionName.add("builtin_String_equal_");
        function = new IRFunction("builtin_String_equal_" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_equal_" , function);

        builtInFunctionName.add("builtin_String_not_equal_");
        function = new IRFunction("builtin_String_not_equal_" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_not_equal_" , function);

        builtInFunctionName.add("builtin_String_length_");
        function = new IRFunction("builtin_String_length_" , new IntegerType(32));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_length_" , function);

        builtInFunctionName.add("builtin_String_substring_");
        function = new IRFunction("builtin_String_substring_" , new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new IntegerType(32));
        function.addParameter(new IntegerType(32));
        builtInFunctions.put("builtin_String_substring_" , function);

        builtInFunctionName.add("builtin_String_parseInt_");
        function = new IRFunction("builtin_String_parseInt_" , new IntegerType(32));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_String_parseInt_" , function);

        builtInFunctionName.add("builtin_String_ord_");
        function = new IRFunction("builtin_String_ord_" , new IntegerType(32));
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new IntegerType(32));
        builtInFunctions.put("builtin_String_ord_" , function);

        builtInFunctionName.add("builtin_array_size_");
        function = new IRFunction("builtin_array_size_" , new IntegerType(32));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("builtin_array_size_" , function);

        builtInFunctionName.add("print");
        function = new IRFunction("print" , new VoidType());
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("print" , function);

        builtInFunctionName.add("println");
        function = new IRFunction("println" , new VoidType());
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("println" , function);

        builtInFunctionName.add("printInt");
        function = new IRFunction("printInt" , new VoidType());
        function.addParameter(new IntegerType(32));
        builtInFunctions.put("printInt" , function);

        builtInFunctionName.add("printlnInt");
        function = new IRFunction("printlnInt" , new VoidType());
        function.addParameter(new IntegerType(32));
        builtInFunctions.put("printlnInt" , function);

        builtInFunctionName.add("getString");
        function = new IRFunction("getString" , new PointerType(new IntegerType(8)));
        builtInFunctions.put("getString" , function);

        builtInFunctionName.add("getInt");
        function = new IRFunction("getInt" , new IntegerType(32));
        builtInFunctions.put("getInt" , function);

        builtInFunctionName.add("toString");
        function = new IRFunction("toString" , new PointerType(new IntegerType(8)));
        function.addParameter(new IntegerType(32));
        builtInFunctions.put("toString" , function);
    }

    public void addCustomFunc(IRFunction func){
        customFunctionName.add(func.name);
        customFunctions.put(func.name , func);
    }

    public IRFunction getBuiltinFunc(String name){
        return builtInFunctions.getOrDefault(name , null);
    }

    public IRFunction getCustomFunc(String name){
        return customFunctions.getOrDefault(name , null);
    }

    public IRFunction getFunc(String name){
        if (getBuiltinFunc(name) != null)return getBuiltinFunc(name);
        else return getCustomFunc(name);
    }

    public void addCustomClass(String name){
        customClassName.add(name);
        customClasses.put(name , new StructType(name));
    }

    public void addClassMember(String name , IRType baseType , String identifier){
        customClasses.get(name).addMember(identifier , baseType);
    }

    public int getClassMemberIndex(String classname , String memname){
        return customClasses.get(classname).getIndex(memname);
    }

    public IRType getClassMemberType(String classname , String memname){
        return customClasses.get(classname).getBaseType(memname);
    }

    public StructType getClass(String name){
        return customClasses.get(name);
    }

    public void addStaticData(String name , IRType basetype){
        staticDataName.add(name);
        staticData.put(name , basetype);
    }

    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
