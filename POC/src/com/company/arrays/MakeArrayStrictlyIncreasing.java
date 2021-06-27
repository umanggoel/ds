package com.company.arrays;

import java.util.Arrays;

public class MakeArrayStrictlyIncreasing {

    public static void main(String[] args) {
        MakeArrayStrictlyIncreasing makeArrayStrictlyIncreasing = new MakeArrayStrictlyIncreasing();
        int arr[] = {1,5,3,6,7};
        int arr2[] = {4,3,1};
        makeArrayStrictlyIncreasing.makeArrayIncreasing(arr, arr2);
    }

    public int makeArrayIncreasing(int[] arr, int[] arr2) {

        if(arr == null) return 0;

        Arrays.sort(arr2);
        int len = arr.length;
        if(arr.length <= 2 ) return 0;

        int leftMax[] = new int[len];
        int rightSmall[] = new int[len];

        leftMax[0] = arr[0];
        rightSmall[len-1] = arr[len-1];

        for(int i=1;i<len;i++) {
            if(arr[i] > leftMax[i-1]){
                leftMax[i] = arr[i];
            } else{
                leftMax[i] = leftMax[i-1];
            }
        }


        for(int i=len-2;i>=0;i--) {
            if(arr[i] < rightSmall[i+1]){
                rightSmall[i] = arr[i];
            } else{
                rightSmall[i] = rightSmall[i+1];
            }
        }

        int count = 0;
        for(int i=1;i<=len-2;i++) {
            if(leftMax[i-1] > arr[i] || rightSmall[i+1] < arr[i]) {
                for(int j = 0;j<arr2.length;j++) {
                    if(leftMax[i-1] < arr2[j] && rightSmall[i+1] > arr2[j]){
                        arr[i] = arr2[j];
                        leftMax[i] = Math.max(leftMax[i-1], arr[i]);
                        rightSmall[i] = Math.min(rightSmall[i+1], arr[i]);
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
        for(int i = 1;i< arr.length;i++) {
            if(arr[i]<=arr[i-1]) return -1;
        }

        return count;
    }
}
