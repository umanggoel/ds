package com.company.comoanyasked;

public class CountPronic {

    public static void main(String[] args) {
        CountPronic countPronic = new CountPronic();

       System.out.println(countPronic.solution(1,2900));
       System.out.println(countPronic.sample(1,2900));

    }

    public int solution(int A, int B) {

        int count = 0;
        for(int i = A;i<= B;i++){
            if(isProductOfConsecutivePossible(i)) count++;
        }

        return count;
    }

    boolean isProductOfConsecutivePossible(int num) {

        int limit = (int)Math.sqrt(num);
        for(int i = 1;i<=limit;i++) {
            if(i * (i+1) == num) return true;
        }
        return false;
    }

    int sample(int A, int B) {
        return count(B)-count(A-1);
    }

    int count(int num) {
        int i = (int)Math.sqrt(num);
        if(i * (i+1) <= num) return i;
        return i-1;
    }
}