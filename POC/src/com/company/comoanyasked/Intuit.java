package com.company.comoanyasked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intuit {

    public static void main(String[] args) {
        Intuit intuit = new Intuit();

        intuit.solve(1,2, Arrays.asList('#','#','#','#','#','#','#','#'));
    }

    /*
     * Implement method/function with name 'solve' below.
     * The function accepts following as parameters.
     *  1. r1 is of type int.
     *  2. r2 is of type int.
     *  3. ar is of type List<Character>.
     * return String.
     */

    public  String solve(int r1, int r2, List<Character> ar){
        //Write your code here

        int n = ar.size();
        Map<Integer, Integer> special = new HashMap<>();
        for(int i =1;i<=n;i++) {
            int count = countPrime(i);
            if(count/i >= r1/r2){
                special.put(i, count);
            }
        }

        Map<Integer, Integer> dp = new HashMap();
        int result = canSolve(ar, n, 0,special, dp);
        if(result == -1) return "No way!";
        return Integer.toString(result); //return type "String".
    }


     int canSolve(List<Character> list, int len, int start, Map<Integer, Integer> special, Map<Integer, Integer> dp ) {

        if(start >= len || list.get(start) == '*') return -1;
        if(dp.get(start) != null) return dp.get(start);
        if(start == len-1) return 0;
        int min = Integer.MAX_VALUE;
        int step1 = canSolve(list,len, start+1, special, dp);
        if(step1 != -1){
            min = Math.min(min, step1) ;
        }
        int step2 = canSolve(list,len, start+2, special, dp);
        if(step2 != -1){
            min = Math.min(min, step2) ;
        }
        int stepSpecial = -1;
        if(special.get(start+1) != null && special.get(start+1)!=0){
            stepSpecial = canSolve(list,len, start+special.get(start+1), special, dp);
        }
        if(stepSpecial != -1){
            min = Math.min(min, stepSpecial) ;
        }

        if(min == Integer.MAX_VALUE) return -1;
        dp.put(start, min+1);
        return min+1;

    }

    int countPrime(int i) {
        int count = 0;

        for(int j = 2;j<=i;j++) {
            boolean isPrime = true;
            for(int k = 2;k<=j/2;k++)
            {
                if(j%k == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) count++;
        }

        return count;
    }

}
