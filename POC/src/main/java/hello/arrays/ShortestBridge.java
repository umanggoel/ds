package com.company.arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;

        Stack<Integer> colors = new Stack<>();
        colors.push(2);
        colors.push(3);

        Queue<Node> nodes = new LinkedList<>();

        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j] == 1)
                   island(i,j,grid,colors.pop());


        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j] == 3)
                    nodes.add(new Node(i,j,0));


        int result = Integer.MAX_VALUE;

        while(!nodes.isEmpty()){
            Node n = nodes.poll();

            if(validIndex(n.i+1,n.j, rows, cols) && grid[n.i+1][n.j] != 3 ){
                if(grid[n.i+1][n.j] == 2) {
                    result = Math.min(result, n.depth);
                }else{
                    grid[n.i+1][n.j] = 3;
                    nodes.add(new Node(n.i+1, n.j, n.depth+1));
                }
            }

            if(validIndex(n.i-1,n.j, rows, cols) && grid[n.i-1][n.j] != 3){
                if(grid[n.i-1][n.j] == 2){
                    result = Math.min(result, n.depth);
                }else {
                    grid[n.i - 1][n.j] = 3;
                    nodes.add(new Node(n.i - 1, n.j, n.depth + 1));
                }
            }

            if(validIndex(n.i,n.j+1, rows, cols) && grid[n.i][n.j+1] != 3){
                if(grid[n.i][n.j+1] == 2){
                    result = Math.min(result, n.depth);
                }else {
                    grid[n.i][n.j + 1] = 3;
                    nodes.add(new Node(n.i, n.j + 1, n.depth + 1));
                }
            }

            if(validIndex(n.i,n.j-1, rows, cols) && grid[n.i][n.j-1] != 3){
                if(grid[n.i][n.j-1] == 2){
                    result = Math.min(result, n.depth);
                }else{
                    grid[n.i][n.j-1] = 3;
                    nodes.add(new Node(n.i, n.j-1, n.depth+1));
                }

            }
        }
        return result;
    }

    class Node {
        int i;
        int j;
        int depth;
        Node(int i, int j, int depth){
            this.i = i;
            this.j = j;
            this.depth = depth;
        }
    }

    void island(int i , int j, int[][] grid,int color){
        if(i< 0 || i>= grid.length|| j< 0 || j>=grid[0].length || grid[i][j] == 0 || grid[i][j] == color){
            return ;
        }

        grid[i][j] = color;
        island(i+1,j,grid,color);
        island(i-1,j,grid,color);
        island(i,j-1,grid,color);
        island(i,j+1,grid,color);

    }

    private boolean validIndex(int i,int j, int rows, int cols){
        if(i <0 || i>=rows) return false;
        if(j <0 || j>=cols) return false;
        return true;

    }
}
