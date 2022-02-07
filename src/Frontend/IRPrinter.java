package Frontend;

import LLVMIR.IRBasicBlock;
import LLVMIR.IRFunction;
import LLVMIR.IRModule;
import LLVMIR.Instr.IRInstr;
import LLVMIR.Operand.VirtualReg;
import LLVMIR.Type.IRType;
import LLVMIR.Type.PointerType;
import LLVMIR.Type.StructType;
import org.antlr.v4.runtime.misc.Pair;

import java.io.PrintStream;

public class IRPrinter implements IRVisitor{
    PrintStream stream;
    public IRPrinter(PrintStream os){
        stream = os;
    }
    @Override
    public void visit(IRModule node){
        //stream.println("@llvm.global_ctors = appending global [1 x { i32, void ()*, i8* }] [{ i32, void ()*, i8* } { i32 65535, void ()* @global_var_init, i8* null }]");
        for (String name : node.builtInFunctionName){
            IRFunction func = node.getBuiltinFunc(name);
            stream.print("declare dso_local " + func.type.toString() + " @" + name);
            stream.print('(');
            for (int i = 0;i < func.args.size();++i){
                stream.print(func.args.get(i).type.toString());
                if (i != func.args.size()-1)stream.print(", ");
            }
            stream.println(')');
        }
        stream.println();
        for (String statname : node.staticDataName){
            IRType irType = node.staticData.get(statname);
            stream.println("@"+statname+" = dso_local global "+irType.toString()+" "+ irType.getZeroInit().getName());
        }

        for (Pair<String , VirtualReg> pair : node.strCons){
            String strValue = pair.a;
            VirtualReg strConstReg = pair.b;
            assert strConstReg.type instanceof PointerType;
            IRType strType;
            strType = strConstReg.type.dePointed();
            stream.println(strConstReg.getName() + " = constant " + strType.toString() + " c" + strValue);
        }
        stream.print('\n');
        for (String name : node.customClassName){
            node.customClasses.get(name).accept(this);
            stream.print('\n');
        }
        for (String name : node.customFunctionName){
            node.customFunctions.get(name).accept(this);
            stream.print('\n');
        }

    }

    @Override
    public void visit(IRFunction node) {
        stream.print("define dso_local " + node.type.toString() + " @" + node.name);
        int argsCnt = 0;
        stream.print('(');
        for (VirtualReg arg : node.args){
            stream.print(arg.toString());
            argsCnt++;
            if (argsCnt != node.args.size())stream.print(", ");
        }
        stream.print(')');
        stream.println('{');
        for (IRBasicBlock block : node.blockList){
            if (block != node.entryBlock())stream.println(block.label + ":");
            block.accept(this);
        }
        stream.println('}');
    }

    @Override
    public void visit(IRBasicBlock node) {
        for (IRInstr inst : node.instrs){
            stream.print('\t');
            stream.println(inst);
        }
    }

    @Override
    public void visit(StructType node) {
        int argscnt = 0;
        stream.print("%" + node.name + " = type { ");
        for (String id : node.idTable){
            IRType type = node.typeTable.get(id);
            stream.print(type.toString());
            argscnt ++;
            if (argscnt != node.idTable.size())stream.print(", ");
        }
        stream.println(" }");
    }
}
