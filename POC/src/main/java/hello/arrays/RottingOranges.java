package com.company.arrays;

public class RottingOranges {


    public int orangesRotting(int[][] matrix) {

        if(matrix.length == 0) return 0;
        int [][] dp = new int[matrix.length][matrix[0].length];
        int[][] distances = new int[matrix.length][matrix[0].length];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            int [][] visited = new int[matrix.length][matrix[0].length];
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 1){
                    distances[i][j] = foo(matrix,i,j,visited,Integer.MIN_VALUE, dp);
                }
            }
        }

        for(int i=0;i<distances.length;i++){
            for(int j=0;j<distances[0].length;j++){
                if(distances[i][j] == -1) {
                    return -1;
                }
                if(distances[i][j] != 0){
                    min = Math.min(distances[i][j],min);
                }
            }
        }

        return min;
    }

    int foo(int[][] matrix, int i,int j, int[][] visited, int current, int[][] dp){
        if(i<0 || i >= matrix.length || j<0 || j >= matrix[0].length) return -1;
        if(matrix[i][j] == 2) return 1;
        if(visited[i][j] == 1) return 0;
        visited[i][j] = 1;

        int min = Integer.MAX_VALUE;
        if(matrix[i][j] == 1) {
            int value = foo(matrix,i+1,j,visited,matrix[i][j],dp);
            if(value != -1){
                min = Math.min(min,value);
            }
            value =foo(matrix, i,j+1,visited,matrix[i][j],dp);
            if(value != -1){
                min = Math.min(min,value);
            }
            value =foo(matrix, i-1,j,visited,matrix[i][j],dp);
            if(value != -1){
                min = Math.min(min,value);
            }
            value =foo(matrix, i,j-1,visited,matrix[i][j],dp);
            if(value != -1){
                min = Math.min(min,value);
            }
            // }
        }

        visited[i][j] = 0;
        if(min < Integer.MAX_VALUE){
            return min;
        }
      //  dp[i][j] = sum;
        return -1;
    }
}
