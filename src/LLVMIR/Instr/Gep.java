package LLVMIR.Instr;

import Backend.IRInterface;
import LLVMIR.BasicClass.Value;
import LLVMIR.IRBasicBlock;
import LLVMIR.IRFunction;
import LLVMIR.Operand.IRConstant;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class Gep extends IRInstr{
    public VirtualReg resultReg;
    public IRConstant indexSrc;
    public ArrayList<IRConstant> indexOffsets = new ArrayList<>();
    public Gep(VirtualReg result , IRConstant indexs , ArrayList<IRConstant> indexo){
        this.resultReg = result;
        this.indexSrc  = indexs;
        this.indexOffsets = indexo;
    }
    public Gep(VirtualReg result , IRConstant indexs , IRConstant indexo){
        this.resultReg = result;
        this.indexSrc = indexs;
        this.indexOffsets.add(indexo);
    }

    @Override
    public String toString(){
        StringBuilder raw = new StringBuilder();
        raw.append(this.resultReg.getName()).append(" = getelementptr inbounds ").append(this.indexSrc.type.dePointed().toString())
                .append(", ").append(indexSrc.toString());
        for (int i = 0 ; i < indexOffsets.size(); ++i){
            raw.append(", ").append(this.indexOffsets.get(i).toString());
        }
        return raw.toString();
    }
    @Override
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
