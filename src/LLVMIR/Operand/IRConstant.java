package LLVMIR.Operand;

import LLVMIR.BasicClass.User;
import LLVMIR.Type.IRType;

public abstract class IRConstant extends User {
    public IRConstant(String name , IRType type){
        super(name, type);
    }
}
