package com.company.Tree;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinaryTrees {

    public static void main(String[] args) {

        UniqueBinaryTrees uniqueBinaryTrees = new UniqueBinaryTrees();
        System.out.println(uniqueBinaryTrees.numTrees(3));
    }

    public int numTrees(int n) {
        if(n == 0) return 0;
        Map<Integer,Integer> dp = new HashMap<>();
        return generateTreesRecurcively(1,n,dp);
    }

    int generateTreesRecurcively(int start, int end, Map<Integer, Integer> dp){

        int result = 0;
        if(start>end){
            return 1;
        }

        if(dp.get(end-start) != null) return dp.get(end-start);

        for(int i=start;i<=end;i++){
            int left = generateTreesRecurcively(start,i-1,dp);
            int right = generateTreesRecurcively(i+1,end,dp);
            result = result+ left*right;
            dp.put(end-start, result);

        }

        return result;
    }
}
