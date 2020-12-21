package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {


    public static void main(String[] args) {

            ThreeSum threeSum = new ThreeSum();
            int arr[] = {-1,0,1,2,-1,-4};
            int a[] = {0,1,2};
            //threeSum.threeSum(arr);
            threeSum.threeSumClosest(a,3);
    }


    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        if(len < 3) return new ArrayList<>(result);

        for(int i = 0 ;i< len-2;i++) {
            Map<Integer, Integer> map  = new HashMap<>();
            int sum = -1*nums[i];

            int low = i+1;
            while(low < len) {
                if(map.get(sum - nums[low]) != null) {
                    result.add(Arrays.asList( -1*sum,map.get(sum - nums[low]),nums[low]));
                    map.remove(sum - nums[low]);
                }else{
                    map.put(nums[low], nums[low]);
                }
                low++;
            }
        }

        return new ArrayList<>(result);
    }

    public int threeSumClosest(int[] nums, int target) {

        int min = Integer.MAX_VALUE;
        int len = nums.length;
        int result = 0;
        for(int i =0 ;i < len-1; i++) {
            for(int j =i+1 ;j < len-1; j++) {
                for(int k =j+1 ;k < len-1; k++) {
                    int t = Math.abs(nums[i] + nums[j] + nums[k]-target);
                    if(t < min){
                        min = t;
                        result = nums[i] + nums[j] + nums[k];
                    }
                }
            }

        }

        return result;
    }
}
