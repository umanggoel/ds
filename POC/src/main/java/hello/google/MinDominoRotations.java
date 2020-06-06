package com.company.google;

import java.util.ArrayList;
import java.util.List;

public class MinDominoRotations {

    public static void main(String[] args) {
        MinDominoRotations minDominoRotations = new MinDominoRotations();
      //  minDominoRotations.minDominoRotations(new int[]{1,1,1,1,1},new int[]{3,6,3,3,4});
        minDominoRotations.minDominoRotations(new int[]{6,1,6,4,6,6},new int[]{5,6,2,6,3,6});
//        minDominoRotations.minDominoRotations(new int[]{},new int[]{});
//        minDominoRotations.minDominoRotations(new int[]{},new int[]{});
//        minDominoRotations.minDominoRotations(new int[]{},new int[]{});


    }
    public int minDominoRotations(int[] A, int[] B) {

        int count[] = new int[7];

        for(int i=0;i<A.length;i++){
            count[A[i]] = count[A[i]] + 1;
            count[B[i]] = count[B[i]] + 1;
        }

        List<Integer> candidates = new ArrayList<>();

        for(int i=0;i<=6;i++){
            if(count[i] >= A.length) candidates.add(i);
        }

        int min = Integer.MAX_VALUE;

        for(Integer cand:candidates){
            int rotationsA = 0;
            int i = 0;
            for(i=0;i<A.length;i++){
                if(A[i] != cand && B[i] != cand) break;
                if(A[i] == cand) continue;
                if(B[i] == cand) rotationsA++;
            }

            int rotationsB = 0;
            int j = 0;
            for(j=0;j<B.length;j++){
                if(A[j] != cand && B[j] != cand) break;
                if(B[j] == cand) continue;
                if(A[j] == cand) rotationsB++;
            }

            if(i == j && j == B.length){
                min = Math.min(min,Math.min(rotationsB, rotationsA));
            }
        }

        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}
