package com.company.common;

public class Util {

    public static<T> void printMatrix(T [][] matrix) {

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static<T> void printArray(T [] matrix) {

        for(int j=0;j<matrix.length;j++){
            System.out.print(matrix[j] + ",");
        }
        System.out.println("");

    }

    public static int countDigits(int k){
        int count = 1;
        while(k/10 != 0){
            count++;
            k=k/10;
        }
        return count;
    }
}
