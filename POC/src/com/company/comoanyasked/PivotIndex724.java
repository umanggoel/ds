package com.company.comoanyasked;

public class PivotIndex724 {

    public static void main(String[] args) {
        PivotIndex724 pivotIndex724 = new PivotIndex724();
        pivotIndex724.pivotIndex(new int[]{1,7,3,6,5,6});
    }

    public int pivotIndex(int[] nums) {

        int len = nums.length;
        int sums[] = new int[len];

        sums[0] = nums[0];

        for(int i =1;i< len;i++) {
            sums[i] = sums[i-1]+nums[i];
        }

        for(int i =1;i<len-1;i++) {
            if(sums[i-1] == sums[len-1]-sums[i]) return i;
        }

        return -1;
    }
}
