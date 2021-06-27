package com.company.numbers;

public class knapsack01 {

    public int getmaxwt(int[][] weights, int capacity) {

        int dp[][] = new int[weights.length + 1][capacity + 1];

        for (int i = 0; i < weights.length + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < capacity + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < weights.length + 1; i++) {

            for (int j = 1; j < capacity + 1; j++) {
                if (weights[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(weights[i][1] + dp[i - 1][j - weights[i][0]], dp[i - 1][j]);
                }
            }
        }

        return dp[weights.length][capacity];
    }
}
