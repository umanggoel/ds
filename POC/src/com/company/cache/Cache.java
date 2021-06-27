package com.company.cache;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<T, K> {

   private ConcurrentHashMap<T, K> map = new ConcurrentHashMap();
   private Deque<T> q = new LinkedList<>();
   private int size;

    protected Cache(int size) {
        this.size = size;
    }

    protected K get(T key) {
        if(map.get(key) != null){

            q.removeLast();
            q.addFirst(key);
            return map.get(key);
        }
        return null;
    }

    protected void put(T key, K object) {
        if(map.get(key) != null){
            q.removeLast();
            q.addFirst(key);
            map.put(key, object);
        }
        if(map.size() == size){
           T temp = q.removeLast();
           map.remove(temp);
        }

        map.put(key, object);
        q.addFirst(key);

    }

    protected void evict() {
        map = new ConcurrentHashMap();
    }
}
