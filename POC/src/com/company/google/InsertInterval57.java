package com.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval57 {

    public static void main(String[] args) {
        InsertInterval57 insertInterval57 = new InsertInterval57();
        int intervals[][] = {{1,3},{6,9}};
        int newInterval[] = {2,5};
        insertInterval57.insert(intervals,newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int l = intervals.length;
        int temp[][] =new int[l+1][2];
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<l;i++){
            temp[i] = intervals[i];
        }

        temp[l] = newInterval;

        Arrays.sort( temp, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0]-o2[0];
            }
        });

        int start = temp[0][0];
        int end = temp[0][1];

        for(int i=1;i<=l;i++){
            if(end >= temp[i][0]){
                end = Math.max(end,temp[i][1]);
            }else{
                result.add(Arrays.asList(start,end));
                start = temp[i][0];
                end = temp[i][1];

            }
        }

        result.add(Arrays.asList(start,end));

        int finalResult[][] = new int[result.size()][2];

        for(int i=0;i<result.size();i++) {
            finalResult[i][0] = result.get(i).get(0);
            finalResult[i][1] = result.get(i).get(1);
        }


        return finalResult;
    }
}
