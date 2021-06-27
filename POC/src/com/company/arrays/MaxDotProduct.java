package com.company.arrays;

public class MaxDotProduct {

    int maxDotProduct(int a[], int b[]){
        int sums[][] = new int[a.length+1][b.length+1];

        for(int i=0;i<a.length;i++){
            sums[i][0] = 0;
        }

        for(int i=0;i<b.length;i++){
            sums[0][i] = 0;
        }

        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                sums[i+1][j+1] = Math.max( Math.max(a[i]*b[j],sums[i][j]+a[i]*b[j]),
                        Math.max(sums[i+1][j],sums[i][j+1]));
            }
        }

        return sums[a.length][b.length];
    }

}
