package com.company.arrays;

import java.util.Arrays;

public class RecoveredCoveredIntervals {

    public static void main(String[] args) {
        int [][] input = {{66672,75156},{59890,65654},{92950,95965},{9103,31953},{54869,69855},{33272,92693}
        ,{52631,65356},{43332,89722},{4218,57729},{20993,92876}};

        RecoveredCoveredIntervals recoveredCoveredIntervals = new RecoveredCoveredIntervals();
        recoveredCoveredIntervals.removeCoveredIntervals(input);
    }
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals == null || intervals.length < 2) return 0;
        Arrays.sort(intervals, (int[] o1, int[] o2)-> {
                    return o1[0]-o2[0];
                }
        );

        int count = 0;
        int beg = intervals[0][0];
        int end = intervals[0][1];
        for(int i= 1;i < intervals.length;i++) {
            if(beg == intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
                count++;
            }else if(intervals[i][0] > beg &&  intervals[i][1] <= end){
                count++;
            } else {
                beg = intervals[i][0];
                end = intervals[i][1];
            }
        }

        return intervals.length-count;
    }

}
