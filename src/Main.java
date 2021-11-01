//import AST.*;
//import Frontend.*;
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

public class Main{
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
//        String name = "test.mx";
        //InputStream input = new FileInputStream(name);

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

        } catch (RuntimeException re) {
            System.err.println(re.getMessage());
            throw new RuntimeException();
        }
    }
}