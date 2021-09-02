package com.company.comoanyasked;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MakeElementsEqual {

    public int solution(int[] A) {
        Arrays.sort(A);
        int mid =A.length/2;
        int result = 0;
        for(int i = 0;i< A.length;i++) {
            result += Math.abs(A[i]-A[mid]);
        }

        return result;
    }
}