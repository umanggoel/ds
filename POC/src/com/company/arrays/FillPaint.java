package com.company.arrays;

public class FillPaint {

    //http://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
    public void fill(int [][] matrix, int i,int j, int newColor){
        changeColor(matrix,i,j,matrix[i][j],newColor);
    }

    private void changeColor(int [][] matrix, int i, int j, int oldColor, int newColor){

        if(i < 0 || i >= matrix.length) return;
        if(j < 0 || j >= matrix.length) return;
        if(matrix[i][j] != oldColor) return;
        matrix[i][j] = newColor;
        changeColor(matrix,i-1,j,oldColor,newColor);
        changeColor(matrix,i+1,j,oldColor,newColor);
        changeColor(matrix,i,j-1,oldColor,newColor);
        changeColor(matrix,i,j+1,oldColor,newColor);
    }


}
