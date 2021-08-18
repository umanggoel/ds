package com.company.comoanyasked;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int len = n - 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[len - j][i];
                matrix[len - j][i] = matrix[len - i][len - j];
                matrix[len - i][len - j] = matrix[j][len - i];
                matrix[j][len - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
