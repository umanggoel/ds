package com.company.design;

public class SingletonClass {

    private static volatile SingletonClass instance;
    private Integer demo = 0;
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

    public int getDemo() {
        return demo;
    }

    public  void updateDemo() {
            this.demo++;
            System.out.println("demo" + demo);
    }

    public SingletonClass readResolve() {
        return getInstance();
    }
}
