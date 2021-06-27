package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

public class MinFibonicciSum {


    //dp soultion
    public int findMinFibonacciNumbers(int k) {

        List<Integer> fib = new ArrayList<>();

        fib.add(1);
        fib.add(1);

        int a =1;
        int b =1;
        int c = a+b;
        while(c<k) {
            a=b;
            b=c;
            fib.add(c);
            c= a+b;
        }

        int dp[][] = new int[fib.size()+1][k+1];

        for(int i=1;i<=fib.size();i++){
            int ele = fib.get(i-1);
            for(int j= 1;j<=k;j++){
                if(j == ele) {
                    dp[i][j] = 1;
                } else if(j < ele){
                    dp[i][j] = dp[i-1][j];
                } else{
                    if(dp[i-1][j]== 0 && dp[i-1][j-ele] != 0){
                        dp[i][j] = dp[i-1][j-ele]+1;
                    }else if(dp[i-1][j-ele] != 0){
                        dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-ele]+1);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }


        return dp[fib.size()][k];
    }

    public int findMinFibonacciNumbers2(int k) {

        List<Integer> fib = new ArrayList<>();

        fib.add(1);
        fib.add(1);

        int a =1;
        int b =1;
        int c = a+b;
        while(c<=k) {
            a=b;
            b=c;
            fib.add(c);
            c= a+b;
        }

        int count = 0;
        for(int i=fib.size()-1;i>=0;i--){
            if(k-fib.get(i) == 0){
                return count+1;
            }else if(k-fib.get(i) > 0){
                k = k-fib.get(i);
                count++;
            }
        }

        return count;
    }
}
