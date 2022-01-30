package Backend;
import RISCV.*;
import RISCV.Inst.RISCVInst;
import org.antlr.v4.runtime.misc.Pair;

import java.io.PrintStream;

public class AsmPrinter implements asmVisitor{
    public PrintStream os;
    public AsmPrinter(PrintStream os){
        this.os = os;
    }
    @Override
    public void visit(asmmodule node) {
        os.println("\t.text");
        for (Pair<String , asmFunction> pair : node.funcTable){
            pair.b.accept(this);
        }
        os.println();
        printa(node);
        os.println();
        printstr(node);
        os.println("\t.section\t\".note.GNU-stack\",\"\",@progbits");
    }

    @Override
    public void visit(asmFunction node) {
        os.println("\t.globl\t"+node.name);
        os.println("\t.p2align\t2");
        os.println("\t.type\t"+node.name+",@function");
        os.println(node.name+":");
        for (asmBlock block : node.blockTable){
            if (block != node.blockTable.getFirst())os.println(block.getLabel() + ":");
            block.accept(this);
        }
        os.println();
    }

    @Override
    public void visit(asmBlock node) {
        for (RISCVInst inst : node.InstTable){
            os.println("\t" + inst);
        }
    }

    public void printa(asmmodule node){
        os.println("\t.section\t.bss,\"aw\",@nobits");
        for (String name : node.nameTable){
            os.println("\t.type\t"+name+",@object");
            os.println("\t.globl\t"+name);
            os.println(name+":");
            os.println("\t.word\t0");
            os.println("\t.size\t"+name+", 4");
            os.println();
        }
    }

    public void printstr(asmmodule node){
        os.println("\t.section\t.rodata,\"a\",@progbits");
        for (Pair<String, String> pair : node.dataTabel) {
            String strName  = pair.a;
            String strValue = pair.b;
            os.println("\t.type\t"+strName+",@object");
            os.println("\t.globl\t"+strName);
            os.println(strName+": ");
            os.println("\t.asciz\t"+strValue);
            os.println("\t.size\t"+strName+", "+(strValue.length()+1));
            os.println();
        }
    }
}
