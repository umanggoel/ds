package com.company.arrays;

import java.util.HashMap;
import java.util.Map;

public class JumpsToRechHome1654 {

    public static void main(String[] args) {
        JumpsToRechHome1654 jumpsToRechHome1654 = new JumpsToRechHome1654();
        int forbid [] = {8,3,16,6,12,20};
        jumpsToRechHome1654.minimumJumps(forbid, 15,13,11);
    }

    int result = Integer.MAX_VALUE;
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        Map<Integer, Integer> visited = new HashMap<>();
        for(Integer i: forbidden) {
            visited.put(i, -1);
        }

        result = foo(visited,a,b,x,0,0);
        if(result != Integer.MAX_VALUE) return result;

        return -1;
    }

    int foo(Map<Integer, Integer> visited, int a, int b, int x, int prev, int curr) {

        if(visited.get(curr) != null){
            if(visited.get(curr) == -1) return Integer.MAX_VALUE;
            return visited.get(curr);
        }

        if(curr == x) return 0;

        if(curr > x) {
            if(prev < 1 &&  curr-b > 0) {
                return foo(visited, a,b,x, prev+1, curr-b);
            }
            else {
                return Integer.MAX_VALUE;
            }
        }
        int forwardCount ;
        int temp = foo(visited, a,b,x, 0, curr+a);
        forwardCount = (temp == Integer.MAX_VALUE) ? Integer.MAX_VALUE : temp + 1;


        int backwardCount = Integer.MAX_VALUE;
        if(prev < 1  &&  curr-b > 0) {
            int t2 = foo(visited, a,b,x, prev+1, curr-b);
            backwardCount = (t2 == Integer.MAX_VALUE) ? Integer.MAX_VALUE : t2 + 1;
        }

        int currMin = Math.min(forwardCount, backwardCount);
        visited.put(curr, currMin);
        return currMin;
    }
}