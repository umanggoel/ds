package com.company.comoanyasked;

import java.util.TreeMap;

public class HandOfStraights {

    public static void main(String[] args) {
        HandOfStraights handOfStraights = new HandOfStraights();
        int hand[] = {1,2,3,4,5};
        handOfStraights.isNStraightHand(hand, 4);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {

        TreeMap<Integer, Integer> map = new TreeMap();

        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        int curr = groupSize;
        while (map.size() > 0) {
            curr = groupSize;
            int temp = map.firstKey();
            curr--;
            map.put(temp, map.get(temp) - 1);
            if (map.get(temp) == 0) map.remove(temp);
            while (curr > 0) {
                if (map.ceilingKey(temp+1) == null || map.ceilingKey(temp+1) != temp + 1) {
                    break;
                } else {
                    curr--;
                    temp = map.ceilingKey(temp+1);
                    map.put(temp, map.get(temp) - 1);
                    if (map.get(temp) == 0) map.remove(temp);
                }
            }

            if (curr != 0) {
                break;
            }
        }

        if (curr != 0) return false;
        return true;
    }
}
