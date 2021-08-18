package com.company.comoanyasked;

class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int  end=  nums.length-1;
    
        while(start <= end) {
            int mid = start +(end-start)/2;
            if(nums[mid] == target) return mid;
            
            if(nums[mid] > nums[start]){
                if(target > nums[mid] || target < nums[start]) {
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