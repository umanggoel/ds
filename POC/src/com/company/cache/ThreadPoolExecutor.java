package com.company.cache;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPoolExecutor {
    int limit;
    Queue<Task> taskq = new LinkedList<>();
    Worker[] workers;

    public ThreadPoolExecutor(int limit) {
        this.limit = limit;
        workers= new Worker[limit];
        for(int i=0;i<limit;i++) {
            Worker temp = new Worker();
            temp.start();
            workers[i] =temp;
        }
    }

    public void submitTask(Task task) {
        synchronized(taskq){
            taskq.add(task);
        }
    }

    class Task{
        public void doWork(String str) {
            System.out.println("executing task"+this+" thread:"+str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    class Worker extends Thread{
        public void run() {
            while(true) {
                Task t = null;
                synchronized (taskq) {
                    if(taskq.isEmpty()){
                        try {
                            taskq.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    t = taskq.poll();
                    taskq.notifyAll();
                }
                if(t!=null) {
                    t.doWork(Thread.currentThread().getName());
                }
            }
        }
    }

    class Producer extends Thread{
        public void run() {
            while(true) {
                Task t = new Task();
                synchronized (taskq) {
                    taskq.add(t);
                    taskq.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3);
        (pool.new Producer()).start();
    }
}

