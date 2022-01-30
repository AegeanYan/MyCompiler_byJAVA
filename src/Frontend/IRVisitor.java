package Frontend;

import LLVMIR.IRBasicBlock;
import LLVMIR.IRFunction;
import LLVMIR.IRModule;
import LLVMIR.Type.StructType;

public interface IRVisitor {
    public void visit(IRModule node);
    public void visit(IRFunction node);
    public void visit(IRBasicBlock node);
    public void visit(StructType node);
}
