package LLVMIR;

import Backend.IRInterface;
import Frontend.IRVisitor;
import LLVMIR.BasicClass.User;
import LLVMIR.BasicClass.Value;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.IRType;

import java.util.ArrayList;

public class IRFunction extends User {
    public Integer regCnt = 0;
    public ArrayList<IRBasicBlock> blockList;
    public Value returnAddr;
    public boolean isBuiltin = false;
    public boolean isUsed = false;
    public ArrayList<VirtualReg> args = new ArrayList<>();

    public IRFunction(String name, IRType type) {//funcname & rettype
        super(name, type);
        this.blockList = new ArrayList<>();
        this.returnAddr = null;

    }

    public void addBlock(IRBasicBlock bb){
        blockList.add(bb);
    }
    public IRBasicBlock getEntry(){
        this.blockList.add(new IRBasicBlock(takeLabel()));
        return this.blockList.get(0);
    }

    public void addParameter(IRType typo){
        args.add(new VirtualReg(typo , takeLabel()));
    }

    public void setBuiltin(){
        this.isBuiltin = true;
    }

    public int takeLabel() {
        return regCnt++;
    }
    @Override
    public String getName(){
        return "@" + this.name;
    }
    public IRBasicBlock exitBlock(){
        return this.blockList.get(1);
    }
    public IRBasicBlock entryBlock(){
        return this.blockList.get(0);
    }
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
    public void accept(IRInterface visitor){
        visitor.visit(this);
    }
}
