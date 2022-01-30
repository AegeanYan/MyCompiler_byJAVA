//import AST.*;
//import Frontend.*;
import LLVMIR.IRBasicBlock;
import LLVMIR.IRFunction;
import LLVMIR.IRModule;
import LLVMIR.Type.VoidType;
import Util.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import Parser.Mx_liteParser;
import Parser.Mx_liteLexer;
import Frontend.*;
import AST.*;
import java.io.FileInputStream;
import java.io.*;
import RISCV.*;
import Backend.*;
public class Main{
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
        boolean debug = false;
        String name = "test.yx";
        if (debug)input = new FileInputStream(name);
        String asmOutputfile = "output.s";
        String LLVMoutputfile = "llvm.ll";
        PrintStream asmOutput = new PrintStream(asmOutputfile);
        PrintStream llvmOutput = new PrintStream(LLVMoutputfile);
//        if (debug){
//            asmOutput = System.out;
//            llvmOutput = System.out;
//        }
        boolean Semantic = false;
        for (String str : args){
            if (str.equals("-fsyntax-only")){
                Semantic = true;
                break;
            }
        }
        try{
            Mx_liteLexer lexer = new Mx_liteLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            Mx_liteParser parser = new Mx_liteParser(new CommonTokenStream(lexer));

            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());

            ParseTree parseTreeRoot = parser.program();

            ASTBuilder test = new ASTBuilder();
            RootNode rt = (RootNode) test.visit(parseTreeRoot);

            globalScope gscope = new globalScope(null);
            BuiltInitor initialer = new BuiltInitor();
            gscope = initialer.init(gscope);
            PreProcessor preProcessor = new PreProcessor(gscope);
            preProcessor.visit(rt);
            SemanicChecker semanicChecker = new SemanicChecker(gscope);
            semanicChecker.visit(rt);

            if (Semantic)return;

            IRBuilder irBuilder = new IRBuilder();
            rt.accept(irBuilder);
            IRModule module = irBuilder.targetModule;
            IRPrinter printer = new IRPrinter(llvmOutput);
            printer.visit(module);

            AsmBuilder asmBuilder = new AsmBuilder();
            module.accept(asmBuilder);
            asmmodule asmmodule = asmBuilder.getRoot();
            AsmPrinter asmPrinter = new AsmPrinter(asmOutput);
            asmPrinter.visit(asmmodule);

        } catch (RuntimeException re) {
            System.err.println(re.getMessage());
            throw new RuntimeException();
        }

    }
}