package Backend;

import LLVMIR.IRBasicBlock;
import LLVMIR.IRFunction;
import LLVMIR.IRModule;
import LLVMIR.Instr.*;

public interface IRInterface {
    void visit(IRModule node);
    void visit(IRFunction node);
    void visit(IRBasicBlock node);

    void visit(Alloc node);
    void visit(Binary node);
    void visit(Bitcast node);
    void visit(Branch node);
    void visit(Call node);
    void visit(Gep node);
    void visit(Icmp node);
    void visit(Jump node);
    void visit(Load node);
    void visit(Phi node);
    void visit(Ret node);
    void visit(Store node);

}
