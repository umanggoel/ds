package com.company.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/interval-list-intersections/
public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] a, int[][] b) {

        if(a.length == 0 || b.length == 0) return new int[0][0];

        int result[][] = new int[a.length+b.length][2];

        int count = 0;
        int i = 0, j=0;
        while(i<a.length && j<b.length){

            int startmin = Math.max(a[i][0] ,b[j][0]);
            int endmin = Math.min(a[i][1] ,b[j][1]);

            if(startmin <= endmin){
                result[count][0] = startmin;
                result[count][1] = endmin;
                count++;
            }

            if(endmin == a[i][1]){
                i++;
            }else{
                j++;
            }

        }
        return Arrays.copyOfRange(result,0,count);
    }

}
