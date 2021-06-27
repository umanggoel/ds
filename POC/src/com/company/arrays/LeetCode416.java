package com.company.arrays;

import java.util.HashMap;
import java.util.Map;

public class LeetCode416 {

   // https://leetcode.com/problems/partition-equal-subset-sum/
   public static boolean canPartition(int[] nums) {

       int sum =0;
       for(int i=0;i<nums.length;i++) {
           sum=sum+nums[i];
       }

       if(sum%2 != 0) return false;

       int k = sum/2;

       boolean temp[][] = new boolean[nums.length][k+1];

       for(int i=1;i<=k;i++){
           if(nums[0] < i) break;
           if(nums[0] == i) temp[0][i] = true;
       }
       if(nums.length > 1){
           for(int i=1;i<nums.length;i++){
               for(int j=1;j<=k;j++){
                   if(nums[i] > j) {
                       temp[i][j] = temp[i-1][j];
                   }else if(nums[i] < j){
                       temp[i][j] = temp[i-1][j-nums[i]] || temp[i-1][j];
                   }else{
                       temp[i][j] = true;
                   }
               }
           }
       }

       for(int i=0;i<nums.length;i++){
           if(temp[i][k]) return true;
       }
       return false;

   }

   //https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
    public boolean canPartitionKSubsets(int[] nums, int s) {

        int sum =0;
        for(int i=0;i<nums.length;i++) {
            sum=sum+nums[i];
        }

        if(sum%4 != 0) return false;

        int k = sum/4;

        boolean temp[][] = new boolean[nums.length][k+1];

        for(int i=1;i<=k;i++){
            if(nums[0] < i) break;
            if(nums[0] == i) temp[0][i] = true;
        }
        if(nums.length > 1){
            for(int i=1;i<nums.length;i++){
                for(int j=1;j<=k;j++){
                    if(nums[i] > j) {
                        temp[i][j] = temp[i-1][j];
                    }else if(nums[i] < j){
                        temp[i][j] = temp[i-1][j-nums[i]] || temp[i-1][j];
                    }else{
                        temp[i][j] = true;
                    }
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(temp[i][k]) return true;
        }
        return false;

    }

}
