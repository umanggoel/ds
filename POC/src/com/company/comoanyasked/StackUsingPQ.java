package com.company.comoanyasked;

import java.util.PriorityQueue;
import java.util.Queue;

public class StackUsingPQ {

    public static void main(String[] args) {

        Stack sc= new Stack();
        sc.push(1);
        sc.push(2);
        sc.push(3);

        System.out.println( sc.pop()); //3
        System.out.println( sc.peek()); //2
        System.out.println( sc.peek()); //2
        System.out.println( sc.pop()); //2
    }
}


class Stack {

    PriorityQueue<StackNode> q = new PriorityQueue<StackNode>((a,b) -> b.priority-a.priority);
    int priority = 0;

    public void push(int i) {
        priority++;
        q.add(new StackNode(i, priority));
    }

    public int pop(){
        priority--;
        return q.poll().value;
    }

    public int peek(){
        return q.peek().value;
    }


}

class StackNode {
    public int value;
    public int priority;

    public StackNode(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

}