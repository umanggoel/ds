package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {

    public static void main(String[] args) {
        InsertInterval57 insertInterval57 =new InsertInterval57();

           int[][] intervals = {{1,3},{6,9}};
          int[] newintervals = {2,5};
         //  int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
         // int[] newintervals = {4,8};

       // int[][] intervals = {};
       // int[] newintervals = {4,7};
        insertInterval57.insert(intervals, newintervals);

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int len = intervals.length;

        if(len == 0){
            int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
        }

        int i = 0;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList();

        while(i < len && newInterval[0] > intervals[i][1]) {
            i++;
        }

        for(int j =0;j<i;j++) {
            start.add(intervals[j][0]);
            end.add(intervals[j][1]);
        }

        if(len > 0) {
            int start1 = i >= 0 ? Math.min(intervals[i][0], newInterval[0]) : newInterval[0];
            int end1 = i >= 0 ? Math.max(intervals[i][1], newInterval[1]) : newInterval[1];
            i++;
            while (i < len) {
                if (intervals[i][0] > end1) {
                    break;
                }
                end1 = Math.max(intervals[i][1], end1);
                i++;
            }
            start.add(start1);
            end.add(end1);

            for (int j = i; j < len; j++) {
                start.add(intervals[j][0]);
                end.add(intervals[j][1]);
            }
        }else{
            start.add(newInterval[0]);
            end.add(newInterval[1]);
        }

        int[][] result = new int[start.size()][2];

        for(int j=0;j< start.size();j++) {
            result[j][0] = start.get(j);
            result[j][1] = end.get(j);
        }

        return result;
    }
}