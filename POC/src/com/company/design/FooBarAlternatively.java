package com.company.design;

public class FooBarAlternatively {

    private int n;
    class Task{
        int i = 1;
    }
    private Task t = new Task();

    public FooBarAlternatively(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (t) {
                while(t.i == 1) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                t.i = 1;
                printFoo.run();
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (t) {
                while(t.i == 0) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                t.i = 0;
                printBar.run();
                notifyAll();
            }
        }
    }

}
