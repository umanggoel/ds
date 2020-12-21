package com.company.arrays;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> q;
    int size;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue(k);
        size = k;

        for(Integer i:  nums){
            q.add(i);
            if(q.size() > k) q.poll();
        }
    }

    public int add(int val) {
        q.add(val);
        if(q.size() > size) q.poll();

        return q.peek();
    }
}