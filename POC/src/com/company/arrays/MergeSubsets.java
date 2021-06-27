package com.company.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.sort;

public class MergeSubsets {

    public static void merge(int[][] intervals) {
        sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int end = intervals[0][1];
        for(int i=1;i<4;i++){
            if(intervals[i][0]>=end){
                end = intervals[i][1];
            }
        }
    }

    public static void nonOverlapping(int[][] intervals) {
        sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int count = 1;
        int end = intervals[0][1];
        for(int i=1;i<4;i++){
            if(intervals[i][0]>=end){
                count++;
                end = intervals[i][1];
            }
        }

        System.out.println("no of non overlapping intervals : " + count);
    }


    public static int[][] mergeSubsets(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        List<Integer> start = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();
        int end = intervals[0][1];
        start.add(intervals[0][0]);
        endList.add(end);
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                end = intervals[i][1];
                start.add(intervals[i][0]);
                endList.add(intervals[i][1]);
                count++;
            } else {
                endList.set(count,intervals[i][1]);
            }
        }

        int results[][] = new int[start.size()][2];
        for(int i=0;i<start.size();i++){
            results[i][0] = start.get(i);
            results[i][1] = endList.get(i);
        }
        return results;
    }

    public static int[][] mergeIterval(int[][] it) {

        int start = it[0][0];
        int end =it[1][0];
        for(int i=1 ; i<it[0].length;i++){
            if(it[0][i] <= it[1][i-1]){
                end = it[1][i];
            } else{
                System.out.println(start +" "+ end);
                start = it[0][i];
                end = it[1][i];
            }
        }
        return it;
    }
}
