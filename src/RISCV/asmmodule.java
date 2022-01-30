package RISCV;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class asmmodule {
    public ArrayList<Pair<String , asmFunction>> funcTable = new ArrayList<>();
    public ArrayList<Pair<String , String>> dataTabel = new ArrayList<>();
    public ArrayList<String> nameTable = new ArrayList<>();
    public asmmodule(){};
}
