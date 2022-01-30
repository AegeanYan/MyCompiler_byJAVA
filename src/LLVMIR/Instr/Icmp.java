package LLVMIR.Instr;

import Backend.IRInterface;
import Frontend.IRBuilder;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.IntegerType;

public class Icmp extends IRInstr{
    public enum CmpOp {
        eq, ne, sgt, slt, sge, sle
    }
    public final CmpOp op;
    public VirtualReg resultReg;
    public IRConstant rs1 , rs2;
    public Icmp(VirtualReg result , CmpOp op , IRConstant rs1 , IRConstant rs2){
        this.resultReg = result;
        this.op = op;
        this.rs1 = rs1;
        this.rs2 = rs2;
    }

    @Override
    public String toString() {
        return resultReg.getName() + " = icmp " + op.toString() +  " " + this.rs1.getTypeName() + ", " + this.rs2.getName();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
