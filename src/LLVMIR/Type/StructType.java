package LLVMIR.Type;

import Frontend.IRVisitor;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.NullConstant;

import java.util.ArrayList;
import java.util.HashMap;

public class StructType extends IRType{
    public HashMap<String , IRType>typeTable;
    public HashMap<String , Integer>indexTable;
    public ArrayList<String> idTable;
    public Integer count;
    public String name;

    public StructType(String name){
        this.typeTable = new HashMap<>();
        this.indexTable = new HashMap<>();
        this.idTable = new ArrayList<>();
        this.count = 0;
        this.name = name;
    }
    public StructType addMember(String identifier , IRType type){
        if (!idTable.contains(identifier)){
            typeTable.put(identifier , type);
            indexTable.put(identifier , count++);
            idTable.add(identifier);
        }
        return this;
    }

    public int getIndex(String id){
        return indexTable.get(id);
    }

    public IRType getBaseType(String id){
        return typeTable.get(id);
    }
    @Override
    public int byteSize() {
        int sum = 0;
        for (IRType type : typeTable.values()){
            if(type instanceof BoolType)sum += 1;
            else sum += type.byteSize();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "%" + name;
    }

    @Override
    public boolean isEqual(IRType ot) {
        return (ot instanceof StructType) && ((StructType) ot).name.equals(this.name);
    }

    @Override
    public IRConstant getZeroInit() {
        return new NullConstant();
    }

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
