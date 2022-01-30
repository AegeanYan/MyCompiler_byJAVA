package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.User;
import LLVMIR.IRBasicBlock;
import LLVMIR.Type.IRType;

public abstract class IRInstr {
    abstract public String toString();
    abstract public void accept(IRInterface visitor);
}
