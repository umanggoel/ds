package com.company.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {

    public int longestConsecutive(int[] nums) {

        int max = Integer.MIN_VALUE;
        Set<Integer> map =new HashSet<>();

        for(int i=0;i<nums.length;i++){
            map.add(nums[i]);
        }
        if(map.size() == 0) return 0;
        if(map.size() == 1) return 1;
        for(Integer key : map){
            if(!map.contains(key-1)){
                int count = 1;
                int value = key;
                while(map.contains(value+1)){
                    value++;
                    count++;
                }
                max = Math.max(count,max);
            }
        }


        return max;
    }
}
