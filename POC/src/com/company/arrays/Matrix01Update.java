package com.company.arrays;

public class Matrix01Update {

    public static void main(String[] args) {
        Matrix01Update matrix01Update = new Matrix01Update();
        int a[][] = {{0,1,0,1,0,1},{1,0,0,0,1,1},{1,1,1,1,1,1},{1,1,1,1,0,1}};
        matrix01Update.updateMatrix(a);
    }

    int dp[][];
    public int[][] updateMatrix(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;
        int result[][] = new int[row][col];

        dp = new int[row][col];
        for(int i = 0;i< row;i++) {
            for(int j = 0;j<col;j++) {
                if(mat[i][j] == 1)  result[i][j] = foo(mat, row, col, i, j, result);
            }
        }
        return result;
    }

    int foo(int[][] mat, int row, int col, int i, int j, int result[][]){

        if(i < 0 || j< 0 || i>=row || j>=col || mat[i][j] == -1) return -1;
        if(mat[i][j] == 0) return 0;

        mat[i][j] = -1;
        int min = Integer.MAX_VALUE;
        int t = foo(mat, row, col, i+1, j, result);
        if(t >= 0) min = Math.min(min, t);

        int b = foo(mat, row, col, i-1, j, result);
        if(b >= 0) min = Math.min(min, b);

        int l = foo(mat, row, col, i, j+1, result);
        if(l >= 0) min = Math.min(min, l);

        int r = foo(mat, row, col, i, j-1, result);
        if(r >= 0) min = Math.min(min, r);

        mat[i][j] = 1;

        return min+1;
    }
}