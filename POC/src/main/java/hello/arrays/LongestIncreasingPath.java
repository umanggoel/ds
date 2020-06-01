package com.company.arrays;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int [][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            int [][] visited = new int[matrix.length][matrix[0].length];
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max,foo(matrix,i,j,visited,Integer.MIN_VALUE, dp));
            }
        }
        return max;
    }

    int foo(int[][] matrix, int i,int j, int[][] visited, int current, int[][] dp){
        if(i<0 || i >= matrix.length || j<0 || j >= matrix[0].length) return 0;
        if(visited[i][j] == 1) return 0;
        visited[i][j] = 1;
        int sum = 0;
        if(matrix[i][j] > current) {
            if(dp[i][j] != 0){
                sum = dp[i][j];
            } else{
                sum = 1 + Math.max(Math.max(foo(matrix,i+1,j,visited,matrix[i][j],dp),foo(matrix, i,j+1,visited,matrix[i][j],dp)),
                        Math.max(foo(matrix, i-1,j,visited,matrix[i][j],dp),foo(matrix, i,j-1,visited,matrix[i][j],dp)));
            }
        }

        visited[i][j] = 0;
        dp[i][j] = sum;
        return sum;
    }
}
