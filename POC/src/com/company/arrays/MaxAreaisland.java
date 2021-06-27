package com.company.arrays;

public class MaxAreaisland {
    public int maxAreaOfIsland(int[][] grid) {

        if(grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;

        int max = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j] == 1)
                    max = Math.max(island(i,j,grid),max);

        return max;
    }


    int island(int i , int j, int[][] grid){
        if(i< 0 || i>= grid.length|| j< 0 || j>=grid[0].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        int curr = 0;
        curr = curr+island(i+1,j,grid);
        curr = curr+island(i-1,j,grid);
        curr = curr+island(i,j-1,grid);
        curr = curr+island(i,j+1,grid);

        return curr+1;

    }
}
