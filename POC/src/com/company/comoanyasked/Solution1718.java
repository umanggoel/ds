package com.company.comoanyasked;

public class Solution1718 {

    public static void main(String[] args) {
        Solution1718 solution1718 = new Solution1718();
        solution1718.constructDistancedSequence(5);
    }

    int t[];
    public int[] constructDistancedSequence(int n) {
        int len =n*2-1;
        t = new int[len];
        int result[] = new int[len];
        foo(n, result, len);
        return t;
    }

    void foo(int n, int [] curr, int len){
        if(n == 0) {
            return;
        }

        if(n == 1) {
            for(int i =0;i<len;i++) {
                if(curr[i] == 0) {
                    curr[i] = 1;
                    if(compare(t, curr) == 1){
                        for(int j =0;j< len;j++){
                            t[j] = curr[j];
                        }
                    }
                    curr[i] = 0;
                }
            }
            return;
        }

        for(int i = 0;i<len;i++) {
            if(curr[i] == 0 && i+n < len && curr[i+n] == 0){
                curr[i] = n;
                curr[i+n] = n;
                foo(n-1, curr, len);
                curr[i] = 0;
                curr[i+n] = 0;
            }
        }

    }

    int compare(int t[], int curr[]) {
        for(int i = 0;i< t.length;i++) {
            if(curr[i] != t[i]){
                if(curr[i] > t[i]) return 1 ;
                return 0;
            }
        }
        return 0;
    }
}