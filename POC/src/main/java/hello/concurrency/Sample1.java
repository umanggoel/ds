package com.company.concurrency;

public class Sample1 {

    public static void main(String[] args) {

        Counter c = new Counter();
        c.i = 1;
        PrintABC a = new PrintABC(c,20,1);
        PrintABC b = new PrintABC(c,20,2);
        PrintABC ab = new PrintABC(c,20,3);
        a.start();
        b.start();
        ab.start();
    }

}


class PrintABC extends Thread {

    private final Counter c ;
    private final int max ;
    private int next;

    public PrintABC(Counter c, int max, int inc) {
        this.c = c;
        this.max = max;
        next = inc;
    }

    @Override
    public void run() {

        while(next <= max) {
            synchronized (c) {
                while(c.i != next){
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.getName() + ":-"  + next);
                c.i = c.i+1;
                next = next+3;
                c.notifyAll();
            }
        }
    }
}

class Counter {
    int i;
}