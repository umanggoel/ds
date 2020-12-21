package com.company.arrays;

//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class MaxJI {

    public static void main(String[] args) {

        int max = Integer.MIN_VALUE;
        int[] a  = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int i=0;
        int j= a.length-1;

        while(i < j) {
            if(a[j] > a[i]) {
                max = Math.max(max, j-i);
            }
            i++;
        }

        i=0;
        j= a.length-1;
        while(i < j) {
            if(a[j] > a[i]) {
                max = Math.max(max, j-i);
            }
            j--;

        }

        System.out.println(max);
    }


}
