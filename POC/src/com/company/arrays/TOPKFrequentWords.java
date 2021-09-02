package com.company.arrays;

import java.util.*;

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

        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> map = new TreeMap();

            for(int i: nums) {
                map.put(i, map.getOrDefault(i, 0)+1);
            }

            Set<Map.Entry<Integer, Integer>> set = map.entrySet();

            int result[] = new int[set.size()];
                int count  =0;
            for(Map.Entry e: set) {
                result[count++] = (int)e.getKey();
            }

            return Arrays.copyOfRange(result, set.size()-k, set.size());

        }
}
