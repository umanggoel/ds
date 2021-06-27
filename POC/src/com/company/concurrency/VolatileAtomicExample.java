package com.company.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicExample {
    public volatile Boolean flag = new Boolean(true);
    public AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) {
        VolatileAtomicExample volatileExample = new VolatileAtomicExample();
        Worker  worker = new Worker(volatileExample);
        Producer producer = new Producer(volatileExample);
        worker.start();
        producer.start();
    }
}

class Worker extends Thread {
    public VolatileAtomicExample volatileExample;

    public Worker(VolatileAtomicExample volatileExample) {
      this.volatileExample = volatileExample;
    }

    @Override
    public void run() {
        while(volatileExample.flag) {
            System.out.println("pending");
            synchronized (volatileExample){
                for(int i = 0;i< 10;i++) {
                    System.out.println("worker :"+volatileExample.count.incrementAndGet());
                }
            }

            Thread.yield();
        }
        System.out.println("completed");
    }
}

class Producer extends Thread {
    public VolatileAtomicExample volatileExample;

    public Producer(VolatileAtomicExample volatileExample) {
        this.volatileExample = volatileExample;
    }

    @Override
    public void run() {
        synchronized (volatileExample){
            for(int i = 0;i< 10;i++) {
                System.out.println("producer :"+volatileExample.count.incrementAndGet());
            }
        }

        volatileExample.flag = false;
        System.out.println("updating");
    }
}