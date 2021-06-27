package com.company.javaserialization.serialized;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 2l;

    private int age1;
    private String name;
    transient int height;

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age1 +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
