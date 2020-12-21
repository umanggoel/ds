package com.company.arrays;

public class MaximumSumTriplet {


    public static void main(String[] args) {
        MaximumSumTriplet maximumSumTriplet = new MaximumSumTriplet();
        int input[] = {18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605 };
        int in1[] = {2, 5, 3, 1, 4, 9};
        maximumSumTriplet.solve(in1);
    }


    public int solve(int[] a) {

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
                    int temp = a[i] + a[j] + m;
                    if (temp > max)
                        max = temp;
                }
            }
        }

        return max;
    }

    private int max(int[] a , int start) {
        int max = Integer.MIN_VALUE;
        for(int i=start;i<a.length;i++) {
            if(a[i] > max) max = a[i];
        }
        return max;
    }
}
