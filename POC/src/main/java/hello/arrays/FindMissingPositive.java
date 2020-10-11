package com.company.arrays;

public class FindMissingPositive {

        public int firstMissingPositive(int[] nums) {

            int len = nums.length;
            int [] temp = new int[len+1];

            for(int i=0;i<nums.length;i++){
                if(nums[i] <= len && nums[i] > 0) temp[nums[i]] = 1;
            }

            int i = 1;
            for(;i<len+1;){
                if(temp[i] == 0) return i;
                i=i+1;
            }

            return i;

        }
}
