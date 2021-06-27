package com.company.google;

public class MaximumPointsCards1423 {

    public static void main(String[] args) {
        MaximumPointsCards1423 maximumPointsCards1423 = new MaximumPointsCards1423();
        int c[] = {1,2,3,4,5,6,1};
        maximumPointsCards1423.maxScore(c,3);
    }

    public int maxScore(int[] cardPoints, int k) {

        int len = cardPoints.length;
        if(len < k) return 0;


        int[] sumRight = new int[len];
        sumRight[len-1] = cardPoints[len-1];
        for(int i=len-2;i>=0;i--) {
            sumRight[i] = sumRight[i+1]+cardPoints[i];
        }

        int[] sumLeft = new int[len];
        sumLeft[0] = cardPoints[0];
        for(int i=1;i< len;i++) {
            sumLeft[i] = sumLeft[i-1]+cardPoints[i];
        }

        int p1= 0;
        int p2=len-k;

        int max= sumRight[p2];
        p2++;
        int curr = 0;
        while(p1 < k && p2<len) {
            curr = sumRight[p2]+sumLeft[p1];
            max = Math.max(max, curr);
            p1++;
            p2++;
        }

        max = Math.max(max, sumLeft[k]);

        return max;

    }


}