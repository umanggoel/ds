package com.company.comoanyasked;

public class SearchRotatedArray33 {


    public static void main(String[] args) {
        SearchRotatedArray33 searchRotatedArray33= new SearchRotatedArray33();
        searchRotatedArray33.search(new int[]{4,5,6,7,0,1,2}, 0);
    }

    public int search(int[] nums, int target) {

        int start = 0;
        int  end=  nums.length-1;

        while(start <= end) {
            int mid = start +(end-start)/2;
            if(nums[mid] == target) return mid;

            if(nums[mid] > nums[0]){
                if(target >= nums[mid] || target < nums[0]) {
                    start = mid+1;
                }
            }else{
                if(target > nums[end] || target < nums[mid]){
                    end = mid-1;
                }
            }
        }

        return -1;
    }

}