package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.IRType;
import LLVMIR.Type.PointerType;

public class Alloc extends IRInstr{
    public VirtualReg allocReg;

    public Alloc(VirtualReg reg){
        allocReg = reg;
    }



    @Override
    public String toString(){
        //PointerType pointerType = (PointerType) allocReg.type;
        return allocReg.getName() + " = alloca " + allocReg.type.dePointed().toString() + " , align " + allocReg.type.dePointed().byteSize();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
