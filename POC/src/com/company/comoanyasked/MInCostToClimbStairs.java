package com.company.comoanyasked;

import java.util.HashMap;
import java.util.Map;

public class MInCostToClimbStairs {


    public static void main(String[] args) {
     MInCostToClimbStairs mInCostToClimbStairs = new MInCostToClimbStairs();
      mInCostToClimbStairs.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});

    }
    Map<Integer, Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(getCost(cost, 0),getCost(cost, 1));
    }

    int getCost(int[] cost, int start) {

        if(map.get(start) != null) return map.get(start);

        if(start == cost.length-1) {
            map.put(start, cost[start]);
            return cost[start];
        }

        int result = cost[start] + Math.min(getCost(cost, start+1),
                getCost(cost, start+2));

        map.put(start, result);
        return result;
    }
}
