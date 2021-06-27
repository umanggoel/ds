package com.company.google;

import java.util.HashMap;
import java.util.Map;

public class LeetCode914 {
    public boolean hasGroupsSizeX(int[] deck) {

        if(deck.length <= 1) return false;

        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<deck.length;i++){
            count.put(deck[i], count.getOrDefault(deck[i],0)+1);
        }


        int min = 0;
        for(Integer i:count.values()){
            min = gcd(min,i);
        }

        if(min < 2) return false;

        for(Integer i: count.values()){
            if(i%min != 0) return false;
        }

        return true;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
