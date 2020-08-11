package com.company.arrays;

public class NiceSubarrays1248 {

    public static void main(String[] args) {
            NiceSubarrays1248 n = new NiceSubarrays1248();
            int [] input = {2,2,2,1,2,2,1,2,2,2};
            n.numberOfSubarrays(input,2);
    }

    public int numberOfSubarrays(int[] nums, int k) {

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int result = 0;
        if(nums[0]%2 != 0) left[0] = 1;
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1];
            if(nums[i]%2 != 0){
                left[i] = left[i-1]+1;
            }
        }

        if(nums[nums.length-1]%2 != 0) right[nums.length-1] = 1;
        for(int i=nums.length-2;i>=0;i--){
            right[i] = right[i+1];
            if(nums[i]%2 != 0) right[i] = right[i+1]+1;
        }

        for(int i=0;i<nums.length;i++) {
            if(left[i]-right[i] == k || -left[i]+right[i] == k || left[i] ==k || right[i] ==k){
                result++;
            }
        }

        return result;
    }
}
