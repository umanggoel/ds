package com.company.arrays;

public class FlowerBed {

    public static void main(String[] args) {

        FlowerBed  flowerBed = new FlowerBed();
        int a[] = {1,0,0,0,1};

        System.out.println(flowerBed.canPlaceFlowers(a, 1));
    }

//    public boolean canPlaceFlowers(int[] f, int n) {
//
//        int len = f.length;
//        for(int i = 0 ;i<len;i++) {
//            if(f[i] == 0){
//                if(canplace(f, n, len, i)) return true;
//            }
//        }
//
//        return false;
//    }
//
//    boolean canplace(int[] f, int n, int len, int start) {
//        if(n == 0) return true;
//
//        for(int i = start ;i<len;i++) {
//            if(f[i] == 0 && issafe(f, i, len)) {
//                f[i] = 1;
//                if(canplace(f, n-1, len, i+1)) return true;
//                f[i] = 0;
//            }
//        }
//
//        return false;
//
//    }
//
//    boolean issafe(int[] f, int i, int len) {
//        if(!(i-1 > 0 && f[i-1] == 0 || i-1< 0)) return false;
//        if(!(i+1 < len && f[i+1] == 0 || i+1 >= len)) return false;
//        return true;
//    }

    public boolean canPlaceFlowers(int[] f, int n) {
        if(n == 0) return true;

        int len = f.length;
        int count = 0;
        for(int i = 0 ;i<len;i++) {
            if(f[i] == 0 && issafe(f,i, len)){
                f[i] = 1;
                count++;
            }
        }

        return count >= n;
    }

    boolean issafe(int[] f, int i, int len) {
        if(!(i-1 > 0 && f[i-1] == 0 || i-1< 0)) return false;
        if(!(i+1 < len && f[i+1] == 0 || i+1 >= len)) return false;
        return true;
    }
}
