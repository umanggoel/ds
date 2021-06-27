package com.company.design.fluentBuilder;

public class Demo {

    public static void main(String[] args) {
        Person p = Person.employmentBuilder()
                .positon("manager")
                .name("Umang")
                .build();

        Person p2 = Person.newPerson()
                .name("Umang")
                .build();

        System.out.println(p);
        System.out.println(p2);

    }
}
