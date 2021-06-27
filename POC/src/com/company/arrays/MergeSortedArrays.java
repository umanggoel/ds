package com.company.arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int count = 0;
        int j= 0;
        int i=0;
        while(j<n && i< m){
            if(nums2[j] <= nums1[count]){
                insertAt(count, nums2[j], nums1);
                j++;
                count++;
            }else{
                i++;
                count++;
            }

        }

        if(j< n){
            for(i=j;i<n;i++){
                nums1[count] = nums2[i];
                count++;
            }
        }
    }

    private void insertAt(int index, int value, int arr[]){

        int len = arr.length;
        for(int i=len-2;i>=index;i--){
            arr[i+1] = arr[i];
        }

        arr[index] = value;
    }
}
