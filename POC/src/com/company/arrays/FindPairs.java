package com.company.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairs {

    public static void main(String[] args) {
        FindPairs findPairs = new FindPairs();
        findPairs.findPairs(new int[]{1,1,1,2,2}, 1);
    }

    public int findPairs(int[] nums, int k) {

        if(nums == null) return 0;
        if(nums.length < 1) return 0;
        Arrays.sort(nums);

        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0;i< nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }


        int count = 0;
        if(k==0){
            for(Integer i: map.values()){
                if(i >= 2) count++;
            }
        } else {
            for(int i=1;i<nums.length;i++) {
                while(i<nums.length && nums[i-1] == nums[i]  ) {
                    i=i+1;
                }
                if(map.get(nums[i-1]+k) != null) count++;
            }
        }

        return count;
    }
}
