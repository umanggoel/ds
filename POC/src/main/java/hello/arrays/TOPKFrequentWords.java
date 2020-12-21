package com.company.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-words/
public class TOPKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String i : words) {
            map.put(i , map.getOrDefault(i,0)+1);
        }

        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                        w2.compareTo(w1) : map.get(w1) - map.get(w2) );

        for (String n: map.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        List<String> top = new ArrayList<>();
        for(int i = k - 1; i >= 0; --i) {
            top.add(heap.poll());
        }

        Collections.reverse(top);

        return top;
    }
}
