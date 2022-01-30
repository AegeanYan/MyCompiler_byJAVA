package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;

public class Load extends IRInstr{
    public VirtualReg resultReg;
    public IRConstant addr;
    public Load(VirtualReg result , IRConstant addr){
        this.resultReg = result;
        this.addr = addr;
    }

    @Override
    public String toString(){
        return this.resultReg.getName() + " = load " + this.addr.type.dePointed().toString() + ", " + this.addr.toString() + ", align " + this.resultReg.type.byteSize();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
