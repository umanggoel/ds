package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfEncodedArrays1868 {

    public static void main(String[] args) {
        ProductOfEncodedArrays1868 productOfEncodedArrays1868 = new ProductOfEncodedArrays1868();
        int [][] a = {{1,3},{2,3}};
        int [][] b  ={{6,3},{3,3}};
        productOfEncodedArrays1868.findRLEArray(a, b);
    }

    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {

        List<List<Integer>> result = new ArrayList();

        int p1 = encoded1[0][1];
        int p2 = encoded2[0][1];
        int c1 = encoded1[0][0];
        int c2 = encoded2[0][0];
        int i = 0;
        int j = 0;

        int count = 0;
        int curr = -1;
        while(i < encoded1.length && j < encoded2.length) {
            if(p1<=0){
                i++;
                if( i == encoded1.length) break;
                p1 = encoded1[i][1];
                c1 = encoded1[i][0];
            } if(p2 <= 0) {
                j++;
                if( j == encoded2.length) break;
                p2 = encoded2[j][1];
                c2 = encoded2[j][0];
            }

            p1--;
            p2--;
            int temp = c1* c2;

            if(curr == -1){
                curr = temp;
                count++;
            }else if(temp != curr){
                result.add(Arrays.asList(curr, count));
                curr = temp;
                count = 1;
            }else{
                count++;
            }
        }

        result.add(Arrays.asList(curr, count));

        return result;

    }
}