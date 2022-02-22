package RISCV.Operand;

import java.util.ArrayList;
import java.util.Arrays;

public class PhysicalReg {
    public String name;
    public boolean busy;
    public static ArrayList<String> RegsName = new ArrayList<>(Arrays.asList(
            "zero","ra","sp","gp","tp","t0","t1","t2","s0","s1","a0","a1","a2","a3","a4","a5","a6","a7",
            "s2","s3","s4","s5","s6","s7","s8","s9","s10","s11","t3","t4","t5","t6"
    ));
    public static String[] aRegs = {
            "a0","a1","a2","a3","a4","a5","a6","a7"
    };
    public static String[] sRegs = {
            "s0","s1","s2","s3","s4","s5","s6","s7","s8","s9","s10","s11"
    };
    public PhysicalReg(String name){
        this.name = name;
        this.busy = false;
    }
    public void use(){
        if (busy)throw new RuntimeException("reg had been used");
        else this.busy = true;
    }
    public void free(){
        if (!busy)throw new RuntimeException("reg hadn't been used");
        this.busy = false;
    }
    public String toString(){
        return this.name;
    }
}
