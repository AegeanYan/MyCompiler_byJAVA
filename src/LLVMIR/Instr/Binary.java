package LLVMIR.Instr;


import Backend.IRInterface;
import Frontend.IRBuilder;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;

public class Binary extends IRInstr{
    public enum BiOp {
        add, sub, mul, sdiv, srem,
        shl, ashr, and, or, xor
    }

    public BiOp op;
    public IRConstant rs1 , rs2;
    public VirtualReg result;
    public Binary(VirtualReg result_ , BiOp op , IRConstant rs1 , IRConstant rs2){
        assert rs1.type.isEqual(rs2.type);
        this.op = op;
        this.result = result_;
        this.rs1 = rs1;
        this.rs2 = rs2;
    }

    @Override
    public String toString(){
        return result.getName() + " = " + op + " " + rs1.type.toString() + ", " + rs1.getName() + ", " + rs2.getName();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
