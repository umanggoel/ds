package com.company.comoanyasked;

public class RotateFunction396 {

    public static void main(String[] args) {
        RotateFunction396 rotateFunction396 = new RotateFunction396();

        int [] nums = {4,3,2,6};
        rotateFunction396.maxRotateFunction(nums);
    }

    public int maxRotateFunction(int[] nums) {

        int n = nums.length;
        if(n < 2) return 0;

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int curr = 0;
            for(int j=0;j<n;j++) {
                int index = j+i >= n ? (j+i)-n : j+i;
                curr = curr + nums[j]*index;
            }
            System.out.println(i +" : " + curr);
            max= Math.max(curr, max);
        }
        return max;
    }
}