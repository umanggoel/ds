package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int a[][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralMatrix.spiralOrder(a);
    }
    public List<Integer> spiralOrder(int[][] m) {

        List<Integer> result = new ArrayList<>();

        int row = m.length;
        int col = m[0].length;

        int i = -1;
        int j = -1;
        int sx = -1;
        int sy = -1;
        for(int k = 0;k<Math.ceil(m.length/2.0);k++) {
            sx++;
            sy++;
            i=sx;
            j=sy;
            for(;j< col;j++) result.add(m[i][j]);
            j--;i++;
            if(i>= row) break;
            for( ;i<row;i++) result.add(m[i][j]);
            j--;i--;
            if(j < k) break;
            for(;j>=k;j--) result.add(m[i][j]);
            j++;i--;
            if(i < k) break;
            for(;i>=k+1;i--) result.add(m[i][j]);
            col--;
            row--;
        }

        return result;
    }
}
