package com.company.comoanyasked;

public class MinCountAroundNumber {

    public static void main(String[] args) {
        MinCountAroundNumber  minCountAroundNumber = new MinCountAroundNumber();
        int a[] = {1,2,3,5,6,4,2,4,1,5,2,1};
        int result[] = minCountAroundNumber.countMin(a);
    }

    int[] countMin(int[] a) {

        int aCountLeft[] = new int[a.length];
        aCountLeft[0] = 0;
        for(int i=1;i<a.length;i++) {
            if(a[i-1] < a[i]) {
                aCountLeft[i] = aCountLeft[i-1]+1;
            }else{
                aCountLeft[i]= 0;
            }
        }

        int aCountright[] = new int[a.length];
        aCountright[a.length-1] = 0;
        for(int i=a.length-2;i>=0;i--) {
            if(a[i+1] < a[i]) {
                aCountright[i] = aCountright[i+1]+1;
            }else{
                aCountright[i]= 0;
            }
        }

        for(int i = 0;i< a.length;i++) {
            aCountLeft[i] = aCountLeft[i]+aCountright[i];
        }

        return aCountLeft;
    }
}
