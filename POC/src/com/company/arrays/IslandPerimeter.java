package com.company.arrays;

public class IslandPerimeter {

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
       // int a[][] = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int a[][] = {{0,1}};
        islandPerimeter.islandPerimeter(a);
    }
    public int islandPerimeter(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0;i< row;i++){
            for(int j = 0;j< col;j++) {
                if(grid[i][j] == 1) {
                    return foo(grid, i , j, row, col);
                }
            }
        }

        return 0;
    }


    int foo(int [][]grid, int i, int j, int row, int col) {

        if(i < 0 || i >= row || j< 0 || j >= col || grid[i][j] == 0 ) {
            return 1;
        }

        if(grid[i][j] == -1) return 0;

        grid[i][j] = -1;
        return foo(grid, i+1, j, row, col) +
                foo(grid, i-1, j, row, col) +
                foo(grid, i, j+1, row, col) +
                foo(grid, i, j-1, row, col);
    }
}

