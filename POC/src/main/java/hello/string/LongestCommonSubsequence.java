package com.company.string;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String a, String b) {
        int rows = a.length()+1;
        int cols = b.length()+1;
        int dp[][] = new int[rows][cols];
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]+1);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[rows-1][cols-1];

    }
}
