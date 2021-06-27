package com.company.concurrency;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentDS {

    Map<Integer, Integer> map = new ConcurrentHashMap<>();
    int arr[];
    int size;
    Integer currIndex;
    Random rand = new Random();

    ConcurrentDS(int size) {
        this.size = size;
        this.arr = new int[size];
        currIndex = 0;
    }

    public void insert(int val) {
        synchronized (currIndex) {
            if(currIndex == size) return;
            arr[currIndex] = val;
            map.put(val, currIndex++);
        }
    }

    public void remove(int val) {
        Integer index = map.get(val);
        if(index == null) return;
        synchronized (currIndex) {
            arr[index] = arr[currIndex-1];
            currIndex--;
            map.put(arr[index], index);
        }
    }

    public int getRandom() {
        if(currIndex == 0) return -1;
        return arr[rand.nextInt(currIndex)];
    }

}
