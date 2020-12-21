package com.company.arrays;

public class SortedAquares {

    public static void main(String[] args) {
        SortedAquares sortedAquares =new SortedAquares();
        int in[] = {-4,-1,0,3,10};
        sortedAquares.sortedSquares(in);
    }

    public int[] sortedSquares(int[] a) {

        if(a == null) return null;
        int len = a.length;
        int result[] = new int[len];
        if(len <= 0) return a;
        int p = len-1;
        for(int i = 0;i< len;i++) {
            if(a[i] >= 0){
                p= i;
                break;
            }
        }
        
        int p2 = p-1;
        int p1 = p;
        int i=0;
        while(p2 >= 0 && p1 < len) {
            if(a[p2]*a[p2] > a[p1]*a[p1]){
                result[i++] = a[p1]*a[p1];
                p1++;
            }else{
                result[i++] = a[p2]*a[p2];
                p2--;
            }
        }

        if(p1 <= len-1){
            for(int j=p1;j<len;j++) {
                result[i++] = a[j]*a[j];
            }
        }

        if(p2<p){
            for(int j=p2;j>=0;j--) {
                result[i++] = a[j]*a[j];
            }
        }

        return result;
    }
}
