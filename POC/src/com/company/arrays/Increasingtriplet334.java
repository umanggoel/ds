package com.company.arrays;

public class Increasingtriplet334 {

    public static void main(String[] args) {
        Increasingtriplet334 increasingtriplet334 = new Increasingtriplet334();
        int arr[] = {1,5,0,4,1,3};
        increasingtriplet334.increasingTriplet(arr);

    }

    public boolean increasingTriplet(int[] nums) {
        return solve(nums);
    }

    public boolean solve(int[] a) {

        int len = a.length;
        int max = Integer.MIN_VALUE;
        int rightMax[] = new int[len];
        rightMax[len-1] = a[len-1];
        for(int i = len-2;i>=0;i--) {
            if(a[i] > rightMax[i+1]) {
                rightMax[i] = a[i];
            }else{
                rightMax[i] = rightMax[i+1];
            }
        }

        for(int i = 0;i<len-3;i++) {
            for(int j=i+1;j<len-2;j++){
                int m = rightMax[j+1];
                if(a[i]<a[j] && a[j] < m) {
                    return true;
                }
            }
        }

        return false;
    }
}
