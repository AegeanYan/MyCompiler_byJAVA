package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.IRType;

public class Zext {
    VirtualReg resultReg;
    IRConstant oprand;
    public Zext(VirtualReg result , IRConstant oprand){
        this.resultReg = result;
        this.oprand = oprand;
    }

//    @Override
//    public String toString(){
//        return this.resultReg.getName() + " = zext " + this.oprand.getTypeName() + " to " + this.resultReg.type.toString();
//    }

}
