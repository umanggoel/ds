package com.company.arrays;

public class SmallestDivisor {


    public static void main(String[] args) {
        SmallestDivisor smallestDivisor= new SmallestDivisor();
        int a[] ={19};
        smallestDivisor.smallestDivisor(a,5);
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > max)  max = nums[i];
        }

        int start = 1;
        int end = max;
        int result = Integer.MAX_VALUE;
        while(start < end) {
            int mid = (start+end) / 2;
            long sum =  0;
            for(int i=0;i<nums.length;i++) {
                if(nums[i] < mid) {
                    sum = sum +1;
                } else{
                    sum = sum + nums[i]/mid;
                    if(nums[i] % mid != 0) sum++;
                }
            }

            if(sum <= threshold){
                end=mid-1;
            }else{
                start = mid+1;
            }
        }

        return start;
    }
}
