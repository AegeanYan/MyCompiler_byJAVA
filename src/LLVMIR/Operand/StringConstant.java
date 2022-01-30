package LLVMIR.Operand;

import LLVMIR.Type.ArrayType;
import LLVMIR.Type.IntegerType;
import LLVMIR.Type.PointerType;

public class StringConstant extends IRConstant{
    public String value;

    public StringConstant(String value){
        super("str" , new PointerType(new ArrayType(new IntegerType(8) , value.length())));
        this.value = value;
    }

    @Override
    public String getName(){
        return "@" + this.name;
    }

    @Override
    public String toString(){
        return this.getName() + " = private unnamed_addr constant " + ((PointerType)this.type).baseType.toString() + "c\"" + trans(this.value) + "\", align 1";
    }

    public String trans(String str){
        return str.replace("\\", "\\5C")
                .replace("\n", "\\0A")
                .replace("\"", "\\22")
                .replace("\t", "\\09")
                .replace("\0","\\00");
    }
}
