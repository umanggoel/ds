package com.company.arrays;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if(grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1') count +=  isIsland(i,j,grid);
            }
        }

        return count;
    }

    int isIsland(int i,int j, char[][] grid){
        if((i< 0 || i >= grid.length) || (j< 0 || j >= grid[0].length) || grid[i][j] == '0') return 0;
        grid[i][j] ='0';

        isIsland(i+1,j,grid);
        isIsland(i-1,j,grid);
        isIsland(i,j+1,grid);
        isIsland(i,j-1,grid);

        return 1;


    }
}
