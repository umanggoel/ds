package com.company.google;

import java.util.HashMap;
import java.util.Map;

public class Leet1296 {

    public static void main(String[] args) {
        Leet1296 leet1296 = new Leet1296();
        int test1[] = {1,2,3,3,4,4,5,6};
        leet1296.isPossibleDivide(test1,4);
    }


    public boolean isPossibleDivide(int[] nums, int k) {

        if(k > nums.length || nums.length%k != 0) return false;

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            min = Math.min(min,nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        String s = new String();
        s ="1234";
        s.substring(1);
        Map<Integer, int[]> map1 = new HashMap<>();
        while(!map.isEmpty()){

            if(map.get(min)  == 1){
                map.remove(min);
            }else{
                map.put(min, map.get(min)-1);
            }
            for(int i=1;i<k;i++){
                if(map.get(min+i) == null) return false;
                int count = map.get(min+i)-1;
                if(count == 0){
                    map.remove(min+i);
                } else{
                    map.put(min+i, count);
                }
            }

            min = extractMin(map);
        }

        return true;

    }

    private int extractMin(Map<Integer, Integer> map){
        if(map.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;

        for(Integer entry: map.keySet()){
            min = Math.min(min, entry);
        }

        return min;
    }
}
