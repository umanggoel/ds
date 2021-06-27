package com.company.arrays;

public class KthMissing {

    public static void main(String[] args) {
        KthMissing  k = new KthMissing();
        int arr[] = {2,3,4,7,11};

       System.out.println(k.findKthPositive(arr,5));
    }
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int temp[] = new int[arr[len-1]+1];

        for(int i = 0;i< len;i++) {
            if(arr[i] < arr[len-1]+1 && arr[i] > 0) temp[arr[i]] = 1;
        }

        int count = 0;
        for(int i = 1;i< temp.length;i++) {
            if(count == k) return i;
            if(temp[i] == 0) count++;
        }

        return arr[len-1]+k-count;

    }
}
