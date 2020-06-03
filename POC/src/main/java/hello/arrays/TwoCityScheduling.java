package com.company.arrays;

import static java.util.Arrays.sort;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));
        int res = 0, i = 0, j = costs.length - 1;
        while(i < j) {
            res += costs[i][0];
            res += costs[j][1];
            i++;
            j--;
        }
        return res;
    }
}
