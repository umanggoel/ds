package com.company.arrays;

public class MinLenSubArray {

    public int minSubArrayLen(int k, int[] nums) {

        if(nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end<nums.length){
            while(sum < k && end<nums.length){
                sum = sum+nums[end];
                end++;
            }

            while(sum >= k){
                if(end-start < min){
                    min = end-start;
                }
                sum = sum - nums[start];
                start++;
            }
        }

        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}
