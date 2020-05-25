package com.company.arrays;

public class MaxProduct {

    public static int maxProduct(int[] nums) {

        if(nums.length == 0) return 0;
        int gMax = Integer.MIN_VALUE;
        int currmax = nums[0];
        int currmin = nums[0];
        for(int i = 1;i<nums.length;i++){

            currmax = Math.max(nums[i],Math.max(currmax*nums[i],currmin*nums[i]));
            currmin = Math.min(Math.min(currmin,nums[i]), currmin*nums[i]);
            gMax = Math.max(gMax, currmax);
        }
        gMax = Math.max(gMax, currmax);
        return gMax;
    }
}
