package com.company.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class RussionDoll {

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0]-o2[0];
            }
        });

        int rows = envelopes.length;
        int temp[] = new int[rows];
        int j=0;
        for(int i=1;i<rows;i++){
            while(j<i){
                if(envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]){
                    temp[i] = Math.max(temp[i],temp[j]+1);
                }
                j++;
            }
            j = 0;
        }

        int max =Integer.MIN_VALUE;

        for(int i=0;i<rows;i++){
            max = Math.max(max,temp[i]);
        }

        return max+1;
    }
}
