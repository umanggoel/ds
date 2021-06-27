package com.company.design.fluentBuilder;

import java.io.PrintStream;

public class CreateCodeClass {

    public static void generateClass(Code c) {
        try(PrintStream p = new PrintStream(c.getClassName()+".java")){
            p.print(c);
        } catch (Exception e){

        }
    }
}
