package Frontend;

import AST.*;
import LLVMIR.IRBasicBlock;
import LLVMIR.IRFunction;
import LLVMIR.IRModule;
import LLVMIR.Instr.*;
import LLVMIR.LLVMScope;
import LLVMIR.Operand.*;
import LLVMIR.Type.*;
import Util.IRError;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class IRBuilder implements ASTVisitor {
    public IRModule targetModule;
    public LLVMScope cscope;
    public HashMap<String, IRType> typeTable;
    public HashMap<String, IRFunction> funcTable;
    public HashMap<String, StringConstant> stringTable;
    public LinkedList<VarDefNode> globalInit;
    public IRBasicBlock curBlock;
    public IRFunction curFunc;
    public StructType curClass;
    boolean for_global_and_class_var;
    boolean preCheck;

    private Stack<ArrayList<IRBasicBlock>> loopContinue;
    private Stack<ArrayList<IRBasicBlock>> loopBreak;


    public IRBuilder() {
        for_global_and_class_var = false;
        this.targetModule = new IRModule();
        preCheck = false;
        this.cscope = new LLVMScope(null);
        this.typeTable = new HashMap<>();
        this.funcTable = new HashMap<>();
        this.stringTable = new HashMap<>();
        this.globalInit = new LinkedList<>();
        this.curBlock = null;
        this.curFunc = null;
        this.curClass = null;
        loopContinue = new Stack<>();
        loopBreak = new Stack<>();
    }

    @Override
    public void visit(RootNode node) {
        cscope = new LLVMScope(null);
        preCheck = true;
        for (DeclrNode declr : node.declrs) {
            if (declr instanceof ClassDeclNode) {
                targetModule.addCustomClass(((ClassDeclNode) declr).name);
            }
        }
        for (DeclrNode declr : node.declrs) {
            if (declr instanceof ClassDeclNode) {
                FuncDefNode constr = null;
                curClass = new StructType(((ClassDeclNode) declr).name);
                curFunc = new IRFunction(curClass.name + "." + curClass.name, new VoidType());
                curFunc.addParameter(new PointerType(new StructType(curClass.name)));//
                curBlock = curFunc.getEntry();
                cscope = new LLVMScope(cscope);
                VirtualReg thisStoreReg = new VirtualReg(new PointerType(new StructType(curClass.name), 2), curFunc.takeLabel());
                curBlock.addInstr(new Alloc(thisStoreReg));
                curBlock.addInstr(new Store(curFunc.args.get(0), thisStoreReg));


                cscope.addvar_to_table("this", thisStoreReg);

                for (DeclrNode tmp : ((ClassDeclNode) declr).declrs) {
                    if (tmp instanceof FuncDefNode && ((FuncDefNode) tmp).retnode == null) constr = (FuncDefNode) tmp;
                    if (tmp instanceof DeclStmtNode) tmp.accept(this);
                }

                cscope.classon = targetModule.getClass(curClass.name);
                if (constr != null) constr.accept(this);

                if (curBlock.terminator == null) curBlock.addInstr(new Ret(null));
                targetModule.addCustomFunc(curFunc);//完成所有类的构造函数

                cscope = cscope.to_parent();
                curBlock = null;
                curFunc = null;
                curClass = null;
            }
        }
        for (DeclrNode cd : node.declrs) {
            if (cd instanceof FuncDefNode) cd.accept(this);
        }
        for (DeclrNode cd : node.declrs) {
            if (cd instanceof ClassDeclNode) {
                curClass = new StructType(((ClassDeclNode) cd).name);
                for (DeclrNode declr : ((ClassDeclNode) cd).declrs) {
                    if (declr instanceof FuncDefNode && ((FuncDefNode) declr).retnode != null) declr.accept(this);
                }
                curClass = null;
            }
        }


        IRFunction globalVarDef = new IRFunction("global_var_def", new VoidType());
        curFunc = globalVarDef;
        curBlock = curFunc.getEntry();
        for (DeclrNode declr : node.declrs) {
            if (declr instanceof DeclStmtNode) declr.accept(this);
        }
        curBlock.addInstr(new Ret(null));
        targetModule.addCustomFunc(curFunc);
        curBlock = null;
        curFunc = null;


        preCheck = false;
        for (DeclrNode declr : node.declrs) declr.accept(this);
        //cscope = cscope.to_parent();
    }

    @Override
    public void visit(DeclrNode node) {

    }

    @Override
    public void visit(DeclStmtNode node) {
        if (preCheck) {//全局变量和类内变量
            node.var_defs.forEach(tmp -> {
                tmp.accept(this);
            });
        } else {
            node.var_defs.forEach(tmp -> {
                tmp.accept(this);
            });
        }
    }

    @Override
    public void visit(FuncDefNode node) {
        String name = curClass != null ? curClass.name + "." + node.name : node.name;
        //String name = node.name;
        if (preCheck) {
            if (node.retnode == null) {
                node.suite.accept(this);
            } else {
                node.retnode.accept(this);
                curFunc = new IRFunction(name, node.retnode.baseType);
                if (curClass != null) curFunc.addParameter(new PointerType(new StructType(curClass.name)));
                node.paralist.forEach(cd -> {
                    cd.type.accept(this);
                    curFunc.addParameter(cd.type.baseType);
                });
                targetModule.addCustomFunc(curFunc);
                curFunc = null;//给函数占位
            }
        } else if (node.retnode != null) {
            cscope = new LLVMScope(cscope);
            curFunc = targetModule.getCustomFunc(name);
            assert curFunc != null;
            curBlock = curFunc.getEntry();
            if (curClass != null) cscope.classon = targetModule.getClass(curClass.name);
            if (node.name.equals("main"))
                curBlock.addInstr(new Call(null, targetModule.getCustomFunc("global_var_def"), null));

            VirtualReg argReg;
            int index = 0;
            if (curClass != null) {
                argReg = new VirtualReg(new PointerType(new StructType(curClass.name), 2), curFunc.takeLabel());
                curBlock.addInstr(new Alloc(argReg));
                curBlock.addInstr(new Store(curFunc.args.get(0), argReg));
                cscope.addvar_to_table("this", argReg);
                index++;
            }
            for (; index < curFunc.args.size(); index++) {
                argReg = new VirtualReg(new PointerType(curFunc.args.get(index).type), curFunc.takeLabel());
                assert curFunc.args.get(index).type != null;
                curBlock.addInstr(new Alloc(argReg));
                curBlock.addInstr(new Store(curFunc.args.get(index), argReg));
                if (curClass != null) cscope.addvar_to_table(node.paralist.get(index - 1).id, argReg);
                else cscope.addvar_to_table(node.paralist.get(index).id, argReg);
            }
            node.suite.accept(this);
            if (curBlock.terminator == null) curBlock.addInstr(new Ret(curFunc.type.getZeroInit()));
            curBlock = null;
            curFunc = null;
            cscope = cscope.to_parent();
        }
    }

    @Override
    public void visit(ClassDeclNode node) {
        curClass = new StructType(node.name);
        for (DeclrNode declr : node.declrs) declr.accept(this);
        curClass = null;
    }

    @Override
    public void visit(VarDefNode node) {
        if (preCheck) {
            node.type.accept(this);
            if (node.init != null) node.init.accept(this);
            IRConstant load = null;
            VirtualReg ptrReg, thisStoreReg, thisReg, defReg;
            if (node.init != null) {
                if (node.init.isLvalue()) {
                    load = new VirtualReg(node.init.getValueType(), curFunc.takeLabel());//node的type转换
                    curBlock.addInstr(new Load((VirtualReg) load, node.init.addr));
                    assert node.init.addr != null;
                } else load = node.init.value;
            }


            if (curClass != null) {
                targetModule.addClassMember(curClass.name, node.type.baseType, node.id);
                if (node.init != null) {
                    thisStoreReg = cscope.getVarReg("this", true, curBlock, curFunc);
                    thisReg = new VirtualReg(new PointerType(new StructType(curClass.name)), curFunc.takeLabel());

                    ptrReg = new VirtualReg(new PointerType(node.type.baseType), curFunc.takeLabel());
                    assert node.type.baseType != null;
                    curBlock.addInstr(new Load(thisReg, thisStoreReg));
                    assert thisStoreReg != null;
                    ArrayList<IRConstant> offsets = new ArrayList<>();
                    offsets.add(new IntConstant(0));
                    offsets.add(new IntConstant(targetModule.getClassMemberIndex(curClass.name, node.id)));
                    curBlock.addInstr(new Gep(ptrReg, thisReg, offsets));
                    curBlock.addInstr(new Store(load, ptrReg));
                }
            } else {
                defReg = new VirtualReg(new PointerType(node.type.baseType), node.id);
                assert node.type.baseType != null;
                if (node.init != null) {
                    curBlock.addInstr(new Store(load, defReg));
                    cscope.addvar_to_table(node.id, defReg);
                    targetModule.addStaticData(node.id, node.type.baseType);
                } else {
                    cscope.addvar_to_table(node.id, defReg);
                    ArrayList<IRConstant> args = new ArrayList<>();
                    args.add(defReg);
                    if (node.type.baseType instanceof StructType) {
                        IRFunction constr = targetModule.getCustomFunc(((StructType) node.type.baseType).name);
                        curBlock.addInstr(new Call(null, constr, args));
                    }
                    targetModule.addStaticData(node.id, node.type.baseType);
                }

            }
            node.global = true;
        } else if (!node.global) {
            if (node.init != null) {
                node.type.accept(this);
                node.init.accept(this);
                VirtualReg allocReg;
                IRConstant assignVal;
                if (node.init.isLvalue()) {
                    assignVal = new VirtualReg(node.init.getValueType(), curFunc.takeLabel());
                    curBlock.addInstr(new Load((VirtualReg) assignVal, node.init.addr));
                    assert node.init.addr != null;
                } else assignVal = node.init.value;

                allocReg = new VirtualReg(new PointerType(node.type.baseType), curFunc.takeLabel());
                assert node.type.baseType != null;
                cscope.addvar_to_table(node.id, allocReg);
                curBlock.addInstr(new Alloc(allocReg));
                curBlock.addInstr(new Store(assignVal, allocReg));
            } else {
                node.type.accept(this);
                VirtualReg allocReg = new VirtualReg(new PointerType(node.type.baseType), curFunc.takeLabel());
                assert node.type.baseType != null;
                cscope.addvar_to_table(node.id, allocReg);
                curBlock.addInstr(new Alloc(allocReg));
            }
        }
    }

    @Override
    public void visit(ReturnTypeNode node) {
        //
    }

    @Override
    public void visit(BuiltinTypeNode node) {
        //
    }

    @Override
    public void visit(ArrayTypeNode node) {
        node.varType.accept(this);
        node.baseType = new PointerType(node.varType.baseType, node.dims);
        assert node.varType.baseType != null;
    }

    @Override
    public void visit(BoolTypeNode node) {
        node.baseType = new IntegerType(1);
    }

    @Override
    public void visit(ClassTypeNode node) {
        node.baseType = new PointerType(new StructType(node.id));
    }

    @Override
    public void visit(IntTypeNode node) {
        node.baseType = new IntegerType(32);
    }

    @Override
    public void visit(VoidTypeNode node) {
        node.baseType = new VoidType();
    }

    @Override
    public void visit(StringTypeNode node) {
        node.baseType = new PointerType(new IntegerType(8));
    }

    @Override
    public void visit(VarTypeNode node) {
        //
    }

    @Override
    public void visit(ContiStmtNode node) {
        loopContinue.peek().add(curBlock);
        curBlock.terminator = new Ret(new IntConstant(0));
    }

    @Override
    public void visit(BreakStmtNode node) {
        loopBreak.peek().add(curBlock);
        curBlock.terminator = new Ret(new IntConstant(0));
    }

    @Override
    public void visit(CondStmtNode node) {
        node.condi.accept(this);
        IRBasicBlock rootBlock, ifHeadBlock, elseHeadBlock, ifTailBlock, elseTailBlock, exitBlock;

        IRConstant lhs, rhs;
        if (node.condi.isLvalue() || node.condi.isAssignable) {
            lhs = new VirtualReg(node.condi.getValueType(), curFunc.takeLabel());
            curBlock.addInstr(new Load((VirtualReg) lhs, node.condi.addr));
            assert node.condi.addr != null;
        } else lhs = node.condi.value;
        rhs = new BoolConstant(false);
        if (lhs instanceof BoolConstant) {
            if (!((BoolConstant) lhs).value) {
                if (node.else_stmt != null) {
                    cscope = new LLVMScope(cscope);
                    node.else_stmt.accept(this);
                    cscope = cscope.to_parent();
                }
            } else {
                cscope = new LLVMScope(cscope);
                node.if_stmt.accept(this);
                cscope = cscope.to_parent();
            }
            return;
        }
        VirtualReg condReg = new VirtualReg(new BoolType(), curFunc.takeLabel());
        curBlock.addInstr(new Icmp(condReg, Icmp.CmpOp.ne, lhs, rhs));
        ifHeadBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        rootBlock = curBlock;
        curBlock = ifHeadBlock;
        cscope = new LLVMScope(cscope);
        node.if_stmt.accept(this);
        cscope = cscope.to_parent();
        ifTailBlock = curBlock;
        if (node.else_stmt != null) {
            elseHeadBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
            curBlock = elseHeadBlock;
            rootBlock.addInstr(new Branch(condReg, ifHeadBlock, elseHeadBlock));
            rootBlock.terminator = new Branch(condReg, ifHeadBlock, elseHeadBlock);
            cscope = new LLVMScope(cscope);
            node.else_stmt.accept(this);
            cscope = cscope.to_parent();
            elseTailBlock = curBlock;
            exitBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
            if (ifTailBlock.terminator == null) {
                ifTailBlock.addInstr(new Jump(exitBlock));
                ifTailBlock.terminator = new Jump(exitBlock);
            }
            if (elseTailBlock.terminator == null) {
                elseTailBlock.addInstr(new Jump(exitBlock));
                elseTailBlock.terminator = new Jump(exitBlock);
            }
            curBlock = exitBlock;
        } else {
            exitBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
            rootBlock.addInstr(new Branch(condReg, ifHeadBlock, exitBlock));
            rootBlock.terminator = new Branch(condReg, ifHeadBlock, exitBlock);
            if (ifTailBlock.terminator == null) {
                ifTailBlock.addInstr(new Jump(exitBlock));
                ifTailBlock.terminator = new Jump(exitBlock);
            }
            curBlock = exitBlock;
        }
    }

    @Override
    public void visit(CtrlStmtNode node) {
        //
    }

    @Override
    public void visit(ExprStmtNode node) {
        node.expr.accept(this);
    }

    @Override
    public void visit(SuiteStmtNode node) {
        cscope = new LLVMScope(cscope);
        node.suite.accept(this);
        cscope = cscope.to_parent();
    }

    @Override
    public void visit(ForStmtNode node) {
        loopBreak.push(new ArrayList<>());
        loopContinue.push(new ArrayList<>());
        cscope = new LLVMScope(cscope);
        IRBasicBlock condHeadBlock, condTailBlock, exeHeadBlock, exeTailBlock, increHeadBlock, increTailBlock, exitBlock;
        IRConstant condValue = null;
        VirtualReg resultReg = null;

        if (node.init != null) node.init.accept(this);
        condHeadBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock.addInstr(new Jump(condHeadBlock));
        curBlock.terminator = new Jump(condHeadBlock);
        curBlock = condHeadBlock;
        if (node.cond != null) {
            node.cond.accept(this);
            if (node.cond.isAssignable || node.cond.isLvalue()) {
                condValue = new VirtualReg(node.cond.getValueType(), curFunc.takeLabel());
                curBlock.addInstr(new Load((VirtualReg) condValue, node.cond.addr));
                assert node.cond.addr != null;
            } else condValue = node.cond.value;
            resultReg = new VirtualReg(new BoolType(), curFunc.takeLabel());
        }
        condTailBlock = curBlock;
        exeHeadBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock = exeHeadBlock;
        if (node.stmt != null) node.stmt.accept(this);
        exeTailBlock = curBlock;
        increHeadBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock = increHeadBlock;
        if (node.incre != null) {
            node.incre.accept(this);
        }
        increTailBlock = curBlock;
        exitBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        if (node.cond != null) {
            condTailBlock.addInstr(new Icmp(resultReg, Icmp.CmpOp.ne, condValue, new BoolConstant(false)));
            condTailBlock.addInstr(new Branch(resultReg, exeHeadBlock, exitBlock));
            condTailBlock.terminator = new Branch(resultReg, exeHeadBlock, exitBlock);
        } else {
            condTailBlock.addInstr(new Jump(exeHeadBlock));
            condTailBlock.terminator = new Jump(exeHeadBlock);
        }
        if (exeTailBlock.terminator == null) {
            exeTailBlock.addInstr(new Jump(increHeadBlock));
            exeTailBlock.terminator = new Jump(increHeadBlock);
        }
        if (increTailBlock.terminator == null) {
            increTailBlock.addInstr(new Jump(condHeadBlock));
            increTailBlock.terminator = new Jump(condHeadBlock);
        }
        //condTailBlock.terminator = new Jump(exeHeadBlock);

        ArrayList<IRBasicBlock> breakBlocks = loopBreak.pop();
        ArrayList<IRBasicBlock> contiBlocks = loopContinue.pop();
        for (IRBasicBlock breakBlock : breakBlocks) {
            breakBlock.addInstr(new Jump(exitBlock));
            breakBlock.terminator = new Jump(exitBlock);
        }
        for (IRBasicBlock contiBlock : contiBlocks) {
            contiBlock.addInstr(new Jump(increHeadBlock));
            contiBlock.terminator = new Jump(increHeadBlock);
        }
        curBlock = exitBlock;
        cscope = cscope.to_parent();
    }

    @Override
    public void visit(PrimeStmtNode node) {
        node.var_defs.forEach(cd -> cd.accept(this));
    }

    @Override
    public void visit(RetStmtNode node) {
        IRConstant retVal = null;
        if (node.ret != null) {
            node.ret.accept(this);
            if (node.ret.isLvalue() || node.ret.isAssignable) {
                retVal = new VirtualReg(node.ret.getValueType(), curFunc.takeLabel());
                curBlock.addInstr(new Load((VirtualReg) retVal, node.ret.addr));
                assert node.ret.addr != null;
            } else retVal = node.ret.value;
            curBlock.addInstr(new Ret(retVal, curFunc.type));
        } else curBlock.addInstr(new Ret(null));
        curBlock.terminator = new Ret(null);
    }

    @Override
    public void visit(SemiStmtNode node) {
        //
    }

    @Override
    public void visit(StmtNode node) {
        //
    }

    @Override
    public void visit(WhileStmtNode node) {
        loopBreak.push(new ArrayList<>());
        loopContinue.push(new ArrayList<>());
        IRBasicBlock condHeadBlock, condTailBlock, exeHeadBlock, exeTailBlock, exitBlock;
        IRConstant condValue;
        VirtualReg condReg;
        condHeadBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock.addInstr(new Jump(condHeadBlock));
        curBlock.terminator = new Jump(condHeadBlock);
        curBlock = condHeadBlock;
        if (node.cond != null) node.cond.accept(this);
        if (node.cond != null && (node.cond.isAssignable || node.cond.isLvalue())) {
            condValue = new VirtualReg(new BoolType(), curFunc.takeLabel());
            curBlock.addInstr(new Load((VirtualReg) condValue, node.cond.addr));
            assert node.cond.addr != null;
        } else condValue = node.cond.value;
        if (condValue instanceof BoolConstant && !((BoolConstant) condValue).value) return;
        condReg = new VirtualReg(new BoolType(), curFunc.takeLabel());
        curBlock.addInstr(new Icmp(condReg, Icmp.CmpOp.ne, condValue, new BoolConstant(false)));
        condTailBlock = curBlock;
        exeHeadBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock = exeHeadBlock;
        node.stmt.accept(this);
        exeTailBlock = curBlock;
        exitBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        condTailBlock.addInstr(new Branch(condReg, exeHeadBlock, exitBlock));
        if (exeTailBlock.terminator == null) {
            exeTailBlock.addInstr(new Jump(condHeadBlock));
            exeTailBlock.terminator = new Jump(condHeadBlock);
        }
        condTailBlock.terminator = new Branch(condReg, exeHeadBlock, exitBlock);
        ArrayList<IRBasicBlock> breakBlocks = loopBreak.pop();
        ArrayList<IRBasicBlock> contiBlocks = loopContinue.pop();
        for (IRBasicBlock breakBlock : breakBlocks) {
            breakBlock.addInstr(new Jump(exitBlock));
            breakBlock.terminator = new Jump(exitBlock);
        }
        for (IRBasicBlock contiBlock : contiBlocks) {
            contiBlock.addInstr(new Jump(condHeadBlock));
            contiBlock.terminator = new Jump(condHeadBlock);
        }
        curBlock = exitBlock;
    }

    @Override
    public void visit(UnaryExprNode node) {
        node.rhs.accept(this);
        IRConstant load, result;
        if (node.rhs.isAssignable || node.rhs.isLvalue()) {
            load = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
            curBlock.addInstr(new Load((VirtualReg) load, node.rhs.addr));
        } else load = node.rhs.value;

        if (load instanceof VirtualReg) {
            switch (node.op) {
                case LNOT: {
                    result = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
                    curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.xor, load, new BoolConstant(true)));
                    break;
                }
                case BNOT: {
                    result = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
                    curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.xor, load, new IntConstant(-1)));
                    break;
                }
                case POS: {
                    result = load;
                    break;
                }
                case NEG: {
                    result = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
                    curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.sub, new IntConstant(0), load));
                    break;
                }
                default:
                    throw new IRError("unknown unary", node.pos);
            }
        } else {
            switch (node.op) {
                case LNOT: {
                    result = new BoolConstant(!((BoolConstant) load).value);
                    break;
                }
                case BNOT: {
                    result = new IntConstant(~((IntConstant) load).value);
                    break;
                }
                case POS: {
                    result = node.rhs.value;
                    break;
                }
                case NEG: {
                    result = new IntConstant(-((IntConstant) load).value);
                    break;
                }
                default:
                    throw new IRError("unknown unary", node.pos);
            }
        }
        node.addr = null;
        node.value = result;
    }

    @Override
    public void visit(BinaryExprNode node) {
        IRConstant lhs, rhs, result = null;
        if (node.op != BinaryExprNode.BinaryOp.ANDAND && node.op != BinaryExprNode.BinaryOp.OROR && node.op != BinaryExprNode.BinaryOp.ASSIGNEQ) {
            node.lhs.accept(this);
            node.rhs.accept(this);
            if (node.lhs.isLvalue() || node.lhs.isAssignable) {
                lhs = new VirtualReg(node.lhs.getValueType(), curFunc.takeLabel());
                curBlock.addInstr(new Load((VirtualReg) lhs, node.lhs.addr));
            } else lhs = node.lhs.value;
            if (node.rhs.isLvalue() || node.rhs.isAssignable) {
                rhs = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
                curBlock.addInstr(new Load((VirtualReg) rhs, node.rhs.addr));
            } else rhs = node.rhs.value;

            if (lhs instanceof VirtualReg || rhs instanceof VirtualReg) {
                switch (node.op) {
                    case ADD: {
                        if (node.lhs.getValueType() instanceof IntegerType) {
                            result = new VirtualReg(node.lhs.getValueType(), curFunc.takeLabel());
                            curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.add, lhs, rhs));
                        } else {
                            result = new VirtualReg(new PointerType(new IntegerType(8)), curFunc.takeLabel());
                            ArrayList<IRConstant> args = new ArrayList<>();
                            args.add(lhs);
                            args.add(rhs);
                            curBlock.addInstr(new Call((VirtualReg) result, targetModule.getFunc("string_add"), args));
                        }
                        break;
                    }
                    case LT:
                    case GT:
                    case LEQ:
                    case GEQ: {
                        result = new VirtualReg(new BoolType(), curFunc.takeLabel());
                        if (node.lhs.getValueType() instanceof IntegerType) {
                            switch (node.op) {
                                case LT:
                                    curBlock.addInstr(new Icmp((VirtualReg) result, Icmp.CmpOp.slt, lhs, rhs));
                                    break;
                                case GT:
                                    curBlock.addInstr(new Icmp((VirtualReg) result, Icmp.CmpOp.sgt, lhs, rhs));
                                    break;
                                case LEQ:
                                    curBlock.addInstr(new Icmp((VirtualReg) result, Icmp.CmpOp.sle, lhs, rhs));
                                    break;
                                case GEQ:
                                    curBlock.addInstr(new Icmp((VirtualReg) result, Icmp.CmpOp.sge, lhs, rhs));
                                    break;
                            }
                        } else {
                            ArrayList<IRConstant> args = new ArrayList<>();
                            args.add(lhs);
                            args.add(rhs);
                            switch (node.op) {
                                case LT:
                                    curBlock.addInstr(new Call((VirtualReg) result, targetModule.getFunc("string_lt"), args));
                                    break;
                                case GT:
                                    curBlock.addInstr(new Call((VirtualReg) result, targetModule.getFunc("string_gt"), args));
                                    break;
                                case LEQ:
                                    curBlock.addInstr(new Call((VirtualReg) result, targetModule.getFunc("string_le"), args));
                                    break;
                                case GEQ:
                                    curBlock.addInstr(new Call((VirtualReg) result, targetModule.getFunc("string_ge"), args));
                                    break;
                            }
                        }
                        break;
                    }
                    case SUB:
                    case MUL:
                    case DIV:
                    case MOD:
                    case LSH:
                    case RSH:
                    case AND:
                    case XOR:
                    case OR: {
                        result = new VirtualReg(node.lhs.getValueType(), curFunc.takeLabel());
                        switch (node.op) {
                            case SUB:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.sub, lhs, rhs));
                                break;
                            case MUL:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.mul, lhs, rhs));
                                break;
                            case DIV:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.sdiv, lhs, rhs));
                                break;
                            case MOD:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.srem, lhs, rhs));
                                break;
                            case LSH:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.shl, lhs, rhs));
                                break;
                            case RSH:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.ashr, lhs, rhs));
                                break;
                            case AND:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.and, lhs, rhs));
                                break;
                            case XOR:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.xor, lhs, rhs));
                                break;
                            case OR:
                                curBlock.addInstr(new Binary((VirtualReg) result, Binary.BiOp.or, lhs, rhs));
                                break;
                        }
                        break;
                    }
                    case EQ:
                    case NEQ: {
                        result = new VirtualReg(new BoolType(), curFunc.takeLabel());
                        if (node.lhs.getValueType() instanceof PointerType && node.rhs.getValueType() instanceof PointerType && node.lhs.getValueType().dePointed() instanceof IntegerType && ((IntegerType) node.lhs.getValueType().dePointed()).width == 8) {
                            ArrayList<IRConstant> args = new ArrayList<>();
                            args.add(lhs);
                            args.add(rhs);
                            switch (node.op) {
                                case EQ:
                                    curBlock.addInstr(new Call((VirtualReg) result, targetModule.getFunc("string_eq"), args));
                                    break;
                                case NEQ:
                                    curBlock.addInstr(new Call((VirtualReg) result, targetModule.getFunc("string_ne"), args));
                                    break;
                            }
                        } else {
                            switch (node.op) {
                                case EQ:
                                    curBlock.addInstr(new Icmp((VirtualReg) result, Icmp.CmpOp.eq, lhs, rhs));
                                    break;
                                case NEQ:
                                    curBlock.addInstr(new Icmp((VirtualReg) result, Icmp.CmpOp.ne, lhs, rhs));
                                    break;
                            }
                        }
                        break;
                    }
                }
            } else {
                switch (node.op) {
                    case ADD: {
                        if (node.lhs.getValueType() instanceof IntegerType) {
                            long l = ((IntConstant) node.lhs.value).value;
                            long r = ((IntConstant) node.rhs.value).value;
                            result = new IntConstant(l + r);
                        } else throw new IRError("false type in contant add", node.pos);
                        break;
                    }
                    case LT:
                    case GT:
                    case LEQ:
                    case GEQ: {
                        long l, r;
                        if (node.lhs.getValueType() instanceof IntegerType) {
                            l = ((IntConstant) node.lhs.value).value;
                            r = ((IntConstant) node.rhs.value).value;
                        } else throw new IRError("false type in constant comp", node.pos);
                        switch (node.op) {
                            case LT:
                                result = new BoolConstant(l < r);
                                break;
                            case GT:
                                result = new BoolConstant(l > r);
                                break;
                            case LEQ:
                                result = new BoolConstant(l <= r);
                                break;
                            case GEQ:
                                result = new BoolConstant(l >= r);
                                break;
                        }
                        break;
                    }
                    case SUB:
                    case MUL:
                    case DIV:
                    case MOD:
                    case LSH:
                    case RSH:
                    case AND:
                    case XOR:
                    case OR: {
                        long l, r;
                        if (node.lhs.getValueType() instanceof IntegerType) {
                            l = ((IntConstant) node.lhs.value).value;
                            r = ((IntConstant) node.rhs.value).value;
                        } else throw new IRError("false type in constant calc", node.pos);
                        switch (node.op) {
                            case SUB:
                                result = new IntConstant(l - r);
                                break;
                            case MUL:
                                result = new IntConstant(l * r);
                                break;
                            case DIV:
                                result = new IntConstant(l / r);
                                break;
                            case MOD:
                                result = new IntConstant(l % r);
                                break;
                            case LSH:
                                result = new IntConstant(l << r);
                                break;
                            case RSH:
                                result = new IntConstant(l >> r);
                                break;
                            case AND:
                                result = new IntConstant(l & r);
                                break;
                            case XOR:
                                result = new IntConstant(l ^ r);
                                break;
                            case OR:
                                result = new IntConstant(l | r);
                                break;
                        }
                        break;
                    }
                    case EQ:
                    case NEQ: {
                        if (node.lhs.getValueType() instanceof IntegerType) {
                            long l = ((IntConstant) node.lhs.value).value;
                            long r = ((IntConstant) node.rhs.value).value;
                            if (node.op == BinaryExprNode.BinaryOp.EQ) result = new BoolConstant(l == r);
                            else result = new BoolConstant(l != r);
                        } else if (node.lhs.getValueType() instanceof BoolType) {
                            boolean l = ((BoolConstant) node.lhs.value).value;
                            boolean r = ((BoolConstant) node.rhs.value).value;
                            if (node.op == BinaryExprNode.BinaryOp.EQ) result = new BoolConstant(l == r);
                            else result = new BoolConstant(l != r);
                        } else result = new BoolConstant(node.op == BinaryExprNode.BinaryOp.EQ);
                        break;
                    }
                }
            }


        } else {
            if (node.op == BinaryExprNode.BinaryOp.ASSIGNEQ) {
                node.lhs.accept(this);
                node.rhs.accept(this);
                if (node.rhs.isLvalue() || node.rhs.isAssignable) {
                    rhs = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
                    curBlock.addInstr(new Load((VirtualReg) rhs, node.rhs.addr));
                } else rhs = node.rhs.value;
                curBlock.addInstr(new Store(rhs, node.lhs.addr));
            } else {
                VirtualReg firstReg, secondReg;
                IRBasicBlock rootBlock, alterBlock, resultBlock;
                node.lhs.accept(this);
                if (node.lhs.isAssignable || node.lhs.isLvalue()) {
                    lhs = new VirtualReg(node.lhs.getValueType(), curFunc.takeLabel());
                    curBlock.addInstr(new Load((VirtualReg) lhs, node.lhs.addr));
                } else lhs = node.lhs.value;
                if (lhs instanceof BoolConstant) {
                    BoolConstant tmpl = (BoolConstant) lhs;
                    if ((node.op == BinaryExprNode.BinaryOp.ANDAND && !tmpl.value) || (node.op == BinaryExprNode.BinaryOp.OROR && tmpl.value)) {
                        node.value = new BoolConstant(node.op == BinaryExprNode.BinaryOp.OROR);
                    } else {
                        node.rhs.accept(this);
                        if (node.rhs.isLvalue() || node.rhs.isAssignable) {
                            rhs = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
                            curBlock.addInstr(new Load((VirtualReg) rhs, node.rhs.addr));
                        } else rhs = node.rhs.value;
                        result = new VirtualReg(new BoolType(), curFunc.takeLabel());
                        curBlock.addInstr(new Icmp((VirtualReg) result, Icmp.CmpOp.ne, rhs, new BoolConstant(false)));
                        node.value = result;
                    }
                    node.addr = null;
                    return;
                }
                firstReg = new VirtualReg(new BoolType(), curFunc.takeLabel());
                curBlock.addInstr(new Icmp(firstReg, Icmp.CmpOp.ne, lhs, new BoolConstant(false)));
                rootBlock = curBlock;
                alterBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
                curBlock = alterBlock;
                node.rhs.accept(this);
                if (node.rhs.isAssignable || node.rhs.isLvalue()) {
                    rhs = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
                    curBlock.addInstr(new Load((VirtualReg) rhs, node.rhs.addr));
                } else rhs = node.rhs.value;
                secondReg = new VirtualReg(new BoolType(), curFunc.takeLabel());
                curBlock.addInstr(new Icmp(secondReg, Icmp.CmpOp.ne, rhs, new BoolConstant(false)));
                resultBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
                curBlock.addInstr(new Jump(resultBlock));
                if (node.op == BinaryExprNode.BinaryOp.ANDAND)
                    rootBlock.addInstr(new Branch(firstReg, alterBlock, resultBlock));
                else rootBlock.addInstr(new Branch(firstReg, resultBlock, alterBlock));
                curBlock = resultBlock;

                result = new VirtualReg(new BoolType(), curFunc.takeLabel());
                ArrayList<Pair<IRConstant, Integer>> paths = new ArrayList<>();
                if (node.op == BinaryExprNode.BinaryOp.ANDAND)
                    paths.add(new Pair<>(new BoolConstant(false), rootBlock.label));
                else paths.add(new Pair<>(new BoolConstant(true), rootBlock.label));
                paths.add(new Pair<>(secondReg, alterBlock.label));
                curBlock.addInstr(new Phi((VirtualReg) result, paths));
            }
        }
        node.addr = node.op == BinaryExprNode.BinaryOp.ASSIGNEQ ? node.lhs.addr : null;
        node.value = node.op == BinaryExprNode.BinaryOp.ASSIGNEQ ? null : result;
    }

    @Override
    public void visit(ConstExprNode node) {
        node.cons.accept(this);
        node.addr = node.cons.addr;
        node.value = node.cons.imm;
    }

    @Override
    public void visit(FuncCallExprNode node) {
        IRFunction callFunc;
        VirtualReg resultReg;
        ArrayList<IRConstant> args = new ArrayList<>();
        if (curClass != null) {
            callFunc = targetModule.getCustomFunc(curClass.name + "." + node.name);
            if (callFunc == null) callFunc = targetModule.getFunc(node.name);
            else args.add(curFunc.args.get(0));
        } else callFunc = targetModule.getFunc(node.name);
        if (callFunc == null) throw new IRError("function not found in call", node.pos);
        if (node.expr != null) {
            node.expr.accept(this);
            args.addAll(node.expr.cons);
        }
        resultReg = callFunc.type instanceof VoidType ? null : new VirtualReg(callFunc.type, curFunc.takeLabel());
        curBlock.addInstr(new Call(resultReg, callFunc, args));
        node.addr = null;
        node.value = resultReg;
    }

    @Override
    public void visit(IdExprNode node) {
        node.id.accept(this);
        node.addr = node.id.addr;
        node.value = node.id.imm;

    }

    @Override
    public void visit(IndexExprNode node) {
        VirtualReg ptrReg, thisReg;
        IRConstant offset;
        node.array.accept(this);
        node.index.accept(this);
        if (!((node.array.getValueType()) instanceof PointerType))
            throw new RuntimeException("array must be pointer type");
        if (node.index.isLvalue()) {
            offset = new VirtualReg(node.index.getValueType(), curFunc.takeLabel());
            curBlock.addInstr(new Load((VirtualReg) offset, node.index.addr));
        } else offset = node.index.value;

        thisReg = new VirtualReg(node.array.getValueType(), curFunc.takeLabel());
        curBlock.addInstr(new Load(thisReg, node.array.addr));

        ptrReg = new VirtualReg(node.array.getValueType(), curFunc.takeLabel());
        curBlock.addInstr(new Gep(ptrReg, thisReg, offset));
        node.addr = ptrReg;
        node.value = null;
    }

    @Override
    public void visit(LambDefExprNode node) {
        node.lamb.accept(this);
        node.addr = node.lamb.addr;
        node.value = node.lamb.imm;
    }

    @Override
    public void visit(MemberAccessExprNode node) {
        node.object.accept(this);
        IRConstant thisReg;
        if (node.object.isLvalue() || node.object.isAssignable) {
            thisReg = new VirtualReg(node.object.getValueType(), curFunc.takeLabel());
            curBlock.addInstr(new Load((VirtualReg) thisReg, node.object.addr));
        } else thisReg = node.object.value;
        if (!node.forfunc) {
            ReturnTypeNode obType = node.object.expr_ret;
            assert obType instanceof ClassTypeNode;
            IRType memType = targetModule.getClassMemberType(((ClassTypeNode) obType).name, node.member.name);
            assert memType != null;
            VirtualReg ptrReg = new VirtualReg(new PointerType(memType), curFunc.takeLabel());
            ArrayList<IRConstant> offsets = new ArrayList<>();
            offsets.add(new IntConstant(0));
            offsets.add(new IntConstant(targetModule.getClassMemberIndex(((ClassTypeNode) obType).name, node.member.name)));
            curBlock.addInstr(new Gep(ptrReg, thisReg, offsets));
            node.addr = ptrReg;
            node.value = null;
        } else {
            IRFunction func = null;
            VirtualReg resultReg;
            ArrayList<IRConstant> funcArgs;
            if (node.exprlist != null) {
                node.exprlist.accept(this);
                funcArgs = new ArrayList<>(node.exprlist.cons);
            } else funcArgs = new ArrayList<>();
            if (node.object.expr_ret instanceof ClassTypeNode && !((ClassTypeNode) node.object.expr_ret).name.equals("int") && !((ClassTypeNode) node.object.expr_ret).name.equals("bool") && !((ClassTypeNode) node.object.expr_ret).name.equals("string")) {
                funcArgs.add(0, thisReg);
                String className = ((ClassTypeNode) node.object.expr_ret).name;
                func = targetModule.getCustomFunc(className + "." + node.member.name);
            } else {
                if (node.member.name.equals("size")) {
                    VirtualReg thisCastReg;
                    thisCastReg = new VirtualReg(new PointerType(new IntegerType(8)), curFunc.takeLabel());
                    curBlock.addInstr(new Bitcast((VirtualReg) thisReg, thisCastReg));
                    funcArgs.add(thisCastReg);
                    func = targetModule.getBuiltinFunc("array_size");
                } else {
                    if (node.member.name.equals("length")) func = targetModule.getBuiltinFunc("string_length");
                    else if (node.member.name.equals("substring"))
                        func = targetModule.getBuiltinFunc("string_subString");
                    else if (node.member.name.equals("parseInt")) func = targetModule.getBuiltinFunc("string_parseInt");
                    else if (node.member.name.equals("ord")) func = targetModule.getBuiltinFunc("string_ord");
                    else throw new IRError("unknown func in memberaccess", node.pos);
                    funcArgs.add(0, thisReg);
                }
            }
            resultReg = null;
            assert func != null;
            if (!(func.type instanceof VoidType)) resultReg = new VirtualReg(func.type, curFunc.takeLabel());
            curBlock.addInstr(new Call(resultReg, func, funcArgs));
            node.addr = null;
            node.value = resultReg;
        }
    }

    @Override
    public void visit(NewExprNode node) {
        node.creator.accept(this);
        assert node.creator instanceof NewNode;
        node.addr = ((NewNode) node.creator).addr;
        node.value = ((NewNode) node.creator).value;
    }

    @Override
    public void visit(PrefixExprNode node) {
        Binary.BiOp binarOp = node.op == PrefixExprNode.PreOp.INC ? Binary.BiOp.add : Binary.BiOp.sub;
        node.rhs.accept(this);
        VirtualReg loadReg, resultReg;
        loadReg = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
        curBlock.addInstr(new Load(loadReg, node.rhs.addr));
        resultReg = new VirtualReg(node.rhs.getValueType(), curFunc.takeLabel());
        curBlock.addInstr(new Binary(resultReg, binarOp, loadReg, new IntConstant(1)));
        curBlock.addInstr(new Store(resultReg, node.rhs.addr));
        node.addr = node.rhs.addr;
        node.value = null;
    }

    @Override
    public void visit(NewNode node) {
        if (node.dims != 0) {
            node.types.accept(this);
            IRType bottomType = null;
            ArrayList<IRConstant> sizes = new ArrayList<>();
            IRConstant indexValue = null;
            VirtualReg thisReg, thisStoreReg;
            if (node.types instanceof IntTypeNode) bottomType = new IntegerType(32);
            else if (node.types instanceof BoolTypeNode) bottomType = new BoolType();
            else if (node.types instanceof StringTypeNode) bottomType = new PointerType(new IntegerType(8));
            else if (node.types instanceof ClassTypeNode) {
                assert targetModule.getClass(((ClassTypeNode) node.types).name) != null;
                bottomType = new PointerType(targetModule.getClass(((ClassTypeNode) node.types).name));

            }
            if (node.sizof.size() != node.dims) {
                assert bottomType != null;
                bottomType = new PointerType(bottomType, node.dims - node.sizof.size());
            }
            for (int i = 0; i < node.sizof.size(); ++i) {
                node.sizof.get(i).accept(this);
                if (node.sizof.get(i).isLvalue() || node.sizof.get(i).isAssignable) {
                    indexValue = new VirtualReg(new IntegerType(32), curFunc.takeLabel());
                    curBlock.addInstr(new Load((VirtualReg) indexValue, node.sizof.get(i).addr));
                } else indexValue = node.sizof.get(i).value;
                sizes.add(indexValue);
            }
            thisReg = allocaNewArray(node, bottomType, sizes, 0);
            assert thisReg.type != null;
            thisStoreReg = new VirtualReg(new PointerType(thisReg.type), curFunc.takeLabel());
            curBlock.addInstr(new Alloc(thisStoreReg));
            curBlock.addInstr(new Store(thisReg, thisStoreReg));
            node.addr = thisStoreReg;
            node.value = null;
        } else {
            IRFunction constr;
            VirtualReg thisStoreReg, thisReg, mallocReg;
            ArrayList<IRConstant> mallocArgs = new ArrayList<>();
            ArrayList<IRConstant> constrArgs = new ArrayList<>();
            assert node.types instanceof ClassTypeNode;
            constr = targetModule.getFunc(((ClassTypeNode) node.types).name + "." + ((ClassTypeNode) node.types).name);

            mallocReg = new VirtualReg(new PointerType(new IntegerType(8)), curFunc.takeLabel());

            mallocArgs.add(new IntConstant(targetModule.getClass(((ClassTypeNode) node.types).name).byteSize()));
            curBlock.addInstr(new Call(mallocReg, targetModule.getFunc("malloc"), mallocArgs));
            thisReg = new VirtualReg(new PointerType(new StructType(((ClassTypeNode) node.types).name)), curFunc.takeLabel());
            curBlock.addInstr(new Bitcast(mallocReg, thisReg));

            thisStoreReg = new VirtualReg(new PointerType(new StructType(((ClassTypeNode) node.types).name), 2), curFunc.takeLabel());
            curBlock.addInstr(new Alloc(thisStoreReg));

            constrArgs.add(thisReg);
            curBlock.addInstr(new Call(null, constr, constrArgs));
            curBlock.addInstr(new Store(thisReg, thisStoreReg));
            node.addr = thisStoreReg;
            node.value = null;
        }
    }



    @Override
    public void visit(SubExprNode node) {
        node.expr.accept(this);
        node.addr = node.expr.addr;
        node.value = node.expr.value;
    }

    @Override
    public void visit(SuffixExprNode node) {
        Binary.BiOp binarOp = node.op == SuffixExprNode.SufOp.INC ? Binary.BiOp.add : Binary.BiOp.sub;
        node.lhs.accept(this);
        IRConstant loadReg, resultReg;
        if (node.lhs.isAssignable || node.lhs.isLvalue()) {
            loadReg = new VirtualReg(node.lhs.getValueType(), curFunc.takeLabel());
            curBlock.addInstr(new Load((VirtualReg) loadReg, node.lhs.addr));
        } else loadReg = node.lhs.value;
        resultReg = new VirtualReg(node.lhs.getValueType(), curFunc.takeLabel());
        curBlock.addInstr(new Binary((VirtualReg) resultReg, binarOp, loadReg, new IntConstant(1)));
        curBlock.addInstr(new Store((VirtualReg) resultReg, node.lhs.addr));
        node.addr = null;
        node.value = loadReg;
    }

    @Override
    public void visit(ThisExprNode node) {
        node.thi.accept(this);
        node.addr = null;
        node.value = node.thi.imm;
    }

    @Override
    public void visit(ExprNode node) {

    }

    @Override
    public void visit(IdValNode node) {
        node.addr = cscope.getVarReg(node.name, true, curBlock, curFunc);
        node.imm = null;
    }

    @Override
    public void visit(IntValNode node) {
        node.addr = null;
        node.imm = new IntConstant(node.value);
    }

    @Override
    public void visit(StringValNode node) {
        String constantName = ".str." + targetModule.strCons.size();
        String strValue = node.value.substring(1, node.value.length() - 1);
        StringBuilder llvmStr = new StringBuilder("\"");
        int i, strLength = 0;
        for (i = 0; i < strValue.length(); ++i) {
            if (strValue.charAt(i) == '\\') {
                i++;
                if (strValue.charAt(i) == '\\') llvmStr.append("\\5C");
                else if (strValue.charAt(i) == '\"') llvmStr.append("\\22");
                else if (strValue.charAt(i) == 'n') llvmStr.append("\\0A");
                else if (strValue.charAt(i) == '0') llvmStr.append("\\00");
            } else llvmStr.append(strValue.charAt(i));
            strLength++;
        }
        llvmStr.append("\\00\"");
        strLength++;
        VirtualReg strConstReg = new VirtualReg(new PointerType(new ArrayType(new IntegerType(8), strLength)), constantName);
        targetModule.strCons.add(new Pair<>(llvmStr.toString(), strConstReg));
        targetModule.asmStrings.add(new Pair<>("\"" + strValue + "\"", strConstReg));
        VirtualReg strReg = new VirtualReg(new PointerType(new IntegerType(8)), curFunc.takeLabel());
        curBlock.addInstr(new Bitcast(strConstReg, strReg));
        node.addr = null;
        node.imm = strReg;
    }

    @Override
    public void visit(BoolValNode node) {
        node.addr = null;
        node.imm = new BoolConstant(node.value);
    }

    @Override
    public void visit(NullValNode node) {
        node.addr = null;
        node.imm = new NullConstant();
    }

    @Override
    public void visit(FuncValNode node) {
        //
    }

    @Override
    public void visit(LambdaValNode node) {
        //不要求
    }

    @Override
    public void visit(ThisValNode node) {
        VirtualReg thisStoreReg = cscope.getVarReg("this", true, curBlock, curFunc);
        VirtualReg thisReg = new VirtualReg(new PointerType(new StructType(curClass.name)), curFunc.takeLabel());
        curBlock.addInstr(new Load(thisReg, thisStoreReg));
        node.addr = null;
        node.imm = thisReg;
    }

    @Override
    public void visit(ConstantNode node) {
        //
    }

    @Override
    public void visit(ParaListNode node) {
        //
    }

    @Override
    public void visit(ExprListNode node) {
        IRConstant expr;
        for (ExprNode exp : node.exprs) {
            exp.accept(this);
            if (exp.isLvalue() || exp.isAssignable) {
                expr = new VirtualReg(exp.getValueType(), curFunc.takeLabel());
                curBlock.addInstr(new Load((VirtualReg) expr, exp.addr));
            } else expr = exp.value;
            node.cons.add(expr);
        }
    }

    @Override
    public void visit(SuiteNode node) {
        cscope = new LLVMScope(cscope);
        for (StmtNode stmt : node.stmts) {
            if (curBlock.terminator == null) stmt.accept(this);
        }
        cscope = cscope.to_parent();
    }

    @Override
    public void visit(VarDeclNode varDeclNode) {
        //
    }

    @Override
    public void visit(ForInitNode forInitNode) {

    }

    @Override
    public void visit(ForStopNode forStopNode) {

    }

    @Override
    public void visit(CreatorNode creatorNode) {

    }

    VirtualReg allocaNewArray(NewNode node, IRType bottomType, ArrayList<IRConstant> sizes, int depth) {
        ArrayList<IRConstant> mallocArgs = new ArrayList<>();
        IRConstant indexSize, byteSize, arraySize, mallocSize;
        VirtualReg mallocReg, sizeReg, arrayReg, thisReg, iterStoreReg, iterReg, iterExtReg, iterLoadReg, iterPlusReg, condReg, indexPtrReg, elementReg;
        IRBasicBlock rootBlock, condBlock, exeHeadBlock, exeTailBlock, increBlock, exitBlock;
        IRType depthIRType = depth == node.sizof.size() - 1 ? bottomType : new PointerType(bottomType, node.sizof.size() - 1 - depth);
        byteSize = new IntConstant(depthIRType.byteSize());
        indexSize = sizes.get(depth);
        if (indexSize instanceof IntConstant)
            arraySize = new IntConstant(((IntConstant) byteSize).value * ((IntConstant) indexSize).value);
        else {
            arraySize = new VirtualReg(new IntegerType(32), curFunc.takeLabel());
            curBlock.addInstr(new Binary((VirtualReg) arraySize, Binary.BiOp.mul, indexSize, byteSize));
        }
        mallocSize = new VirtualReg(new IntegerType(32), curFunc.takeLabel());
        curBlock.addInstr(new Binary((VirtualReg) mallocSize, Binary.BiOp.add, arraySize, new IntConstant(4)));
        mallocArgs.add(mallocSize);
        mallocReg = new VirtualReg(new PointerType(new IntegerType(8)), curFunc.takeLabel());
        curBlock.addInstr(new Call(mallocReg, targetModule.getFunc("malloc"), mallocArgs));
        sizeReg = new VirtualReg(new PointerType(new IntegerType(32)), curFunc.takeLabel());
        curBlock.addInstr(new Bitcast(mallocReg, sizeReg));
        curBlock.addInstr(new Store(sizes.get(depth), sizeReg));
        arrayReg = new VirtualReg(new PointerType(new IntegerType(8)), curFunc.takeLabel());
        curBlock.addInstr(new Gep(arrayReg, mallocReg, new IntConstant(4)));
        thisReg = new VirtualReg(new PointerType(depthIRType), curFunc.takeLabel());
        curBlock.addInstr(new Bitcast(arrayReg, thisReg));
        if (depth == node.sizof.size() - 1) return thisReg;

        iterStoreReg = new VirtualReg(new PointerType(new IntegerType(32)), curFunc.takeLabel());
        curBlock.addInstr(new Alloc(iterStoreReg));
        curBlock.addInstr(new Store(new IntConstant(0), iterStoreReg));
        rootBlock = curBlock;
        condBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock = condBlock;
        iterReg = new VirtualReg(new IntegerType(32), curFunc.takeLabel());
        curBlock.addInstr(new Load(iterReg, iterStoreReg));


        condReg = new VirtualReg(new BoolType(), curFunc.takeLabel());
        exeHeadBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock = exeHeadBlock;
        elementReg = allocaNewArray(node, bottomType, sizes, depth + 1);
        exeTailBlock = curBlock;
        indexPtrReg = new VirtualReg(new PointerType(depthIRType), curFunc.takeLabel());
        curBlock.addInstr(new Gep(indexPtrReg, thisReg, iterReg));
        curBlock.addInstr(new Store(elementReg, indexPtrReg));
        increBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock = increBlock;
        iterLoadReg = new VirtualReg(new IntegerType(32), curFunc.takeLabel());
        curBlock.addInstr(new Load(iterLoadReg, iterStoreReg));
        iterPlusReg = new VirtualReg(new IntegerType(32), curFunc.takeLabel());
        curBlock.addInstr(new Binary(iterPlusReg, Binary.BiOp.add, iterReg, new IntConstant(1)));
        curBlock.addInstr(new Store(iterPlusReg, iterStoreReg));
        exitBlock = new IRBasicBlock(curFunc, curFunc.takeLabel());
        curBlock = exitBlock;
        rootBlock.addInstr(new Jump(condBlock));
        condBlock.addInstr(new Icmp(condReg, Icmp.CmpOp.slt, iterReg, indexSize));
        condBlock.addInstr(new Branch(condReg, exeHeadBlock, exitBlock));
        exeTailBlock.addInstr(new Jump(increBlock));
        increBlock.addInstr(new Jump(condBlock));
        return thisReg;
    }
}