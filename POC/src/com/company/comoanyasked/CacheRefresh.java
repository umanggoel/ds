package com.company.comoanyasked;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CacheRefresh {

    Map<Integer, Integer> map = new HashMap<>();
    Date d = new Date();

    void reset() {
        Date curr = new Date();
        if (curr.getTime() - d.getTime() <= 100) return;
        synchronized (map) {
            if (curr.getTime() - d.getTime() <= 100) return;
            System.out.println("updating cache");
            map = new HashMap<>();
            d = new Date();
            map.notifyAll();
        }
    }

    int getData(int key) {
        reset();
        return map.get(key);
    }
}
