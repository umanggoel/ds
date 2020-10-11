package com.company.design;

public class SingletonClass {

    private static volatile SingletonClass instance;

    private SingletonClass() {
        if(instance != null) throw  new RuntimeException("Sigleton object");
    }

    public static SingletonClass getInstance(){
        if(instance == null) {
            synchronized (SingletonClass.class){
                if(instance == null) instance = new SingletonClass();
            }
        }

        return instance;
    }

    public SingletonClass readResolve() {
        return getInstance();
    }
}
