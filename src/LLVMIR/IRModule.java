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

        builtInFunctionName.add("string_add");
        function = new IRFunction("string_add" , new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_add" , function);

        builtInFunctionName.add("string_lt");
        function = new IRFunction("string_lt" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_lt" , function);

        builtInFunctionName.add("string_gt");
        function = new IRFunction("string_gt" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_gt" , function);

        builtInFunctionName.add("string_ge");
        function = new IRFunction("string_ge" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_ge" , function);

        builtInFunctionName.add("string_le");
        function = new IRFunction("string_le" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_le" , function);

        builtInFunctionName.add("string_eq");
        function = new IRFunction("string_eq" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_eq" , function);

        builtInFunctionName.add("string_ne");
        function = new IRFunction("string_ne" , new BoolType());
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_ne" , function);

        builtInFunctionName.add("string_length");
        function = new IRFunction("string_length" , new IntegerType(32));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_length" , function);

        builtInFunctionName.add("string_subString");
        function = new IRFunction("string_subString" , new PointerType(new IntegerType(8)));
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new IntegerType(32));
        function.addParameter(new IntegerType(32));
        builtInFunctions.put("string_subString" , function);

        builtInFunctionName.add("string_parseInt");
        function = new IRFunction("string_parseInt" , new IntegerType(32));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("string_parseInt" , function);

        builtInFunctionName.add("string_ord");
        function = new IRFunction("string_ord" , new IntegerType(32));
        function.addParameter(new PointerType(new IntegerType(8)));
        function.addParameter(new IntegerType(32));
        builtInFunctions.put("string_ord" , function);

        builtInFunctionName.add("array_size");
        function = new IRFunction("array_size" , new IntegerType(32));
        function.addParameter(new PointerType(new IntegerType(8)));
        builtInFunctions.put("array_size" , function);

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
