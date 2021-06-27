package com.company.numbers;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int count = 0;
        for(int i=2;i<n;i++){
            boolean temp = true;
            for(int j=0;j<primes.size();j++){
                if(i%primes.get(j) == 0){
                    temp =false;
                    break;
                }
            }
            if(temp) count++;
        }

        return count;
    }

    public int countPrimesSeivesAlgo(int n) {
        boolean[] primes = new boolean[n];
        int answer = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                continue;

            answer++;
            for (long j = (long) i * i; j < n; j += i)
                primes[(int)j] = true;
        }

        return answer;
    }
}
