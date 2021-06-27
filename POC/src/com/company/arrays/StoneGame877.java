package com.company.arrays;

import java.util.Arrays;

public class StoneGame877 {


    public static void main(String[] args) {
            StoneGame877 stoneGame877 = new StoneGame877();
            int[] piles = {5,3,4,5};
            stoneGame877.stoneGame(piles);
    }

    int[] prefixSum;
    final int INF = Integer.MAX_VALUE;
    int[][] memo;


    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        memo = new int[n][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, INF);
        }

        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }

        int diff = findDifference(0, piles.length - 1, true);
        if (diff <= 0) return false;
        return true;
    }

    private int findDifference(int start, int end, boolean alice) {
        if (start == end) {
            return 0;
        }
        if (memo[start][end] != INF) {
            return memo[start][end];
        }
        int difference;
        int scoreRemoveFirst = prefixSum[end + 1] - prefixSum[start + 1];
        int scoreRemoveLast = prefixSum[end] - prefixSum[start];

        if (alice) {
            difference = Math.max(
                    findDifference(start + 1, end, !alice) + scoreRemoveFirst,
                    findDifference(start, end - 1, !alice) + scoreRemoveLast);
        } else {
            difference = Math.min(
                    findDifference(start + 1, end, !alice) - scoreRemoveFirst,
                    findDifference(start, end - 1, !alice) - scoreRemoveLast);
        }

        memo[start][end] = difference;

        return difference;
    }

}