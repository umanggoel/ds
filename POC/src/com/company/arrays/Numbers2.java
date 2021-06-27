package com.company.arrays;

public class Numbers2 {

    public int singleNonDuplicate(int[] nums) {

        int len = nums.length;
        int start =0;
        int end = len-1;
        if(len == 1){
            return nums[0];
        }

       return binarySearch(nums,start,end);

    }

    private int binarySearch(int nums[], int start, int end){
        if(end < start) return -1;
        int len = end-start+1;
        if(len == 1) return nums[start];
        if(len == 2) return -1;
        int mid = (int)Math.ceil((start+end)/2);
        if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
            return nums[mid];
        }else if(nums[mid] == nums[mid-1]){
            return Math.max(binarySearch(nums,start,mid-2),binarySearch(nums,mid+1,end));
        }else{
            return Math.max(binarySearch(nums,start,mid-1),binarySearch(nums,mid+2,end));
        }
    }
}

