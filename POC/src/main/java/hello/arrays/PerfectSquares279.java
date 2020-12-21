package com.company.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfectSquares279 {


    public static void main(String[] args) {
        PerfectSquares279 perfectSquares279 = new PerfectSquares279();
        perfectSquares279.numSquares(12);
    }

    public int numSquares(int n) {

        if (n <= 0) return 0;
        int x = 1;
        List<Integer> list = new ArrayList<>();

        while (x * x <= n) {
            list.add(x * x);
            x++;
        }

        int dp[][] = new int[list.size() + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[1][i] = i;
        }

        int row = 2;
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            for (int j = 1; j <= n; j++) {
                if (val > j) {
                    dp[row][j] = dp[row - 1][j];
                } else {
                    dp[row][j] = Math.min(dp[row - 1][j], dp[row][j - val] + 1);
                }
            }
            row++;
        }

        return dp[list.size()][n];

    }
}
