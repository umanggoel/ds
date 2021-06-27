package com.company.arrays;

public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();

//        int input[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};

        int input[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
       // int input[][] = {{1},{3}};

        System.out.println(search2DMatrix.searchMatrix(input, 5));
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;

        int probablerow = 0;
        for(int i =0;i< matrix.length;i++){
            if(matrix[i][0] == target) return true;
            if(matrix[i][0] > target) break;
            probablerow++;
        }

        probablerow--;
        if(probablerow < 0) return false;
        int start = 0 ;
        int  end = matrix[probablerow].length -1;
        int mid =0;

        while(start<=end){
            mid = (start+end)/2;
            if(matrix[probablerow][mid] == target) return true;
            if(matrix[probablerow][mid] < target){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }

        return false;


    }
}
