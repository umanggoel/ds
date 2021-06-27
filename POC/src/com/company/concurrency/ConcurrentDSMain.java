package com.company.concurrency;

public class ConcurrentDSMain{

    public static void main(String[] args) {
        ConcurrentDSThread thread = new ConcurrentDSThread();

        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);

        t1.start();
        t2.start();
    }
}

class ConcurrentDSThread implements Runnable{

    ConcurrentDS concurrentDS = new ConcurrentDS(7);

    @Override
    public void run() {
        concurrentDS.insert((int)Math.random());
    }
}
