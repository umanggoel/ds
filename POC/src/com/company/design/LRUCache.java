package com.company.design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    Deque<Integer> queue = new LinkedList<>();
    HashMap<Integer, Integer> cache= new HashMap();
    int cacheSize;

    public LRUCache(int capacity) {
        this.cacheSize = capacity;
    }

    public int get(int key) {
        if(cache.get(key) != null) {
            queue.remove(key);
            queue.addFirst(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.get(key) != null) {
            cache.put(key, value);
            queue.remove(key);
            queue.addFirst(key);
            return;
        }
        if(cache.size()  == cacheSize) {
            Integer last = queue.removeLast();
            cache.remove(last);
        }

        cache.put(key, value);
        queue.addFirst(key);
    }
}
