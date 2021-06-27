package com.company.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {


    public int orangesRotting(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Node> nodes = new LinkedList<>();

        int depth = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 2) nodes.add(new Node(i, j, depth));
            }
        }

        int result = Integer.MIN_VALUE;
        while(!nodes.isEmpty()){
            Node n = nodes.poll();


            result = Math.max(result, n.depth);

            if(validIndex(n.i+1,n.j, rows, cols) && matrix[n.i+1][n.j] == 1){
                matrix[n.i+1][n.j] = 2;
                nodes.add(new Node(n.i+1, n.j, n.depth+1));
            }

            if(validIndex(n.i-1,n.j, rows, cols) && matrix[n.i-1][n.j] == 1){
                matrix[n.i-1][n.j] = 2;
                nodes.add(new Node(n.i-1, n.j, n.depth+1));
            }

            if(validIndex(n.i,n.j+1, rows, cols) && matrix[n.i][n.j+1] == 1){
                matrix[n.i][n.j+1] = 2;
                nodes.add(new Node(n.i, n.j+1, n.depth+1));
            }

            if(validIndex(n.i,n.j-1, rows, cols) && matrix[n.i][n.j-1] == 1){
                matrix[n.i][n.j-1] = 2;
                nodes.add(new Node(n.i, n.j-1, n.depth+1));
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)return -1;
            }
        }

        return result;
    }

    private boolean validIndex(int i,int j, int rows, int cols){
        if(i <0 || i>=rows) return false;
        if( j <0 || j>=cols) return false;
        return true;

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
}
