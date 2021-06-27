package com.company.Tree;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueJava {

    public static void main(String[] args) {

        PriorityQueue<Integer> i = new PriorityQueue<>(Collections.reverseOrder());

        i.add(10);
        i.add(20);
        i.add(15);
        i.add(3);

        System.out.println(i.peek());
    }
}
