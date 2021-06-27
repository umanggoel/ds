package com.company.comoanyasked;

public class UniquePathsWithObstacles {


    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();

        int a[][] = {
        {0, 0, 1, 0, 1, 1, 1, 1},
        {0, 1, 0, 1, 0, 0, 1, 1},
        {0, 0, 1, 0, 0, 0, 0, 1}};
        uniquePathsWithObstacles.uniquePathsWithObstacles(a);
    }
    public int uniquePathsWithObstacles(int[][] a) {

        int r = a.length;
        int c = a[0].length;
        int temp [][] = new int[r][c];

        if(a[0][0] == 0) temp[0][0] = 1;
        for(int i=1;i<r;i++) {
            if(a[i][0] == 0) temp[i][0] = temp[i-1][0];
        }

        for(int i=1;i<c;i++) {
            if(a[0][i] == 0) temp[0][i] = temp[0][i-1];
        }

        for(int i = 1;i< r;i++) {
            for(int j=1;j< c;j++) {
                if(a[i][j] == 0) temp[i][j] = temp[i-1][j] + temp[i][j-1];
            }
        }

        return temp[r-1][c-1];
    }
}
