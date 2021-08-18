package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Goldman {


    public static void main(String[] args) {
           List<List<Integer>> list = new ArrayList<>();
           list.add(Arrays.asList(1,0,0,1));
        list.add(Arrays.asList(0,1,1,1));
        list.add(Arrays.asList(1,0,0,1));

        countConnections(list);
    }

    static int countConnections(List<List<Integer>> matrix) {

        int row = matrix.size();
        if(row == 0) return 0;
        int col = matrix.get(0).size();
        if(col == 0) return 0;

        int arr[][] = new int[row][col];
        int count = 0;
        for(int i = 0;i< row;i++) {
            for(int j = 0;j< col;j++){
                if(matrix.get(i).get(j) == 0) continue;
                arr[i][j] = -1;
                if(isValidIndex(i+1,j,row, col, matrix, arr) ){
                    count++;
                }
                if(isValidIndex(i-1,j,row, col,matrix, arr)){
                    count++;
                }
                if(isValidIndex(i,j+1,row, col,matrix, arr)){
                    count++;
                }
                if(isValidIndex(i,j-1,row, col,matrix, arr)){
                    count++;
                }
            }
        }

        return count;

    }

    private static boolean isValidIndex(int x, int y, int row, int col, List<List<Integer>> matrix, int [][] arr) {
        if(x< 0 || y< 0 || x>= row || y>= col) return false;
        if(arr[x][y] == -1) return false;
        if(matrix.get(x).get(y) == 1) return true;
        return false;
    }
}
