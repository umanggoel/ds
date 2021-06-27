package com.company.arrays;

public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j = 0; j< grid[0].length;j++){
                temp[i][j] = -1;
            }
        }

        int result = minSum(0,0,grid,temp);
        return result;
    }

    private static int minSum(int i,int j,int [][] grid, int[][] temp){
        int row = grid.length;
        int column = grid[row-1].length;
        if(i == row-1 && j == column-1){
            temp[i][j] = grid[i][j];
            return grid[i][j];
        }

        if(temp[i][j] != -1){
            return temp[i][j];
        }

        int down = 0;
        if(i < row-1) {
            down = minSum(i+1,j,grid, temp);
        }

        int right = 0;
        if(j < column-1){
            right = minSum(i,j+1,grid, temp);
        }
        int result = grid[i][j];
        if(down > 0 && right >0){
            result = result+Math.min(down, right);
        } else if(down >0){
            result = result+down;
        } else{
            result = result+right;
        }

        temp[i][j] = result;
        return result;
    }
}
