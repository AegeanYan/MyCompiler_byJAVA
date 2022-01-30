package RISCV;

public interface asmVisitor {
    void visit(asmmodule node);
    void visit(asmFunction node);
    void visit(asmBlock node);
}
