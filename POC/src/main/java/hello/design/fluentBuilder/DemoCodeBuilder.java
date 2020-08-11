package com.company.design.fluentBuilder;

public class DemoCodeBuilder {

    public static void main(String[] args) {
        Code c = Code.newCode("PersonNew")
                .addFields("name","String")
                .addFields("age", "int")
                .build();

        System.out.println(c);
        CreateCodeClass.generateClass(c);
    }


}
