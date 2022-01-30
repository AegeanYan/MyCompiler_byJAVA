package LLVMIR.BasicClass;

import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class User extends Value{
    public ArrayList<Value> operands;

    public User(String name, IRType type) {
        super(name, type);
        this.operands = new ArrayList<>();
    }

    public  void addOperand(Value operand){
        operand.addUser(this);
        this.operands.add(operand);
    }
    public Value getOperand(int index){
        return operands.get(index);
    }
}
