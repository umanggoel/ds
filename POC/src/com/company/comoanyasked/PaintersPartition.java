package com.company.comoanyasked;

public class PaintersPartition {


    public static void main(String[] args) {
        PaintersPartition paintersPartition = new PaintersPartition();
       // int a[] ={10,20,40,50};
        //int a[] = { 640, 435, 647, 352, 8, 90, 960, 329, 859};
        //int a[] = {1000000, 1000000};
       // System.out.println(paintersPartition.paint(1,1,a));

    }
    public int paint(int A, int B, int[] c) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i:c) {
            sum =sum+i;
            max = Math.max(max, i);
        }


        int start  = max;
        int end = sum;
        while(start < end) {
            int n = 1;
            int mid = (start+end) /2;
            int s = 0;
            for(int i:c) {
                s = s+i;
                if(s > mid) {
                    s = i;
                    n++;
                }
            }


            if(n <= A) {
                end = mid;
            }else{
                start = mid+1;
            }

        }

        return B*((start+end)/2);
    }
}
