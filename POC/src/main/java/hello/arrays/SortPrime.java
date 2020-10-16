package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortPrime {

    public static void main(String[] args) {
        SortPrime sortPrime = new SortPrime();
        sortPrime.sortPime(new int[]{6, 7, 4, 2, 10, 5});
    }

    public void sortPime(int[] a) {
        if(a== null || a.length<1) return;

        List<Integer> primes = new ArrayList<>();
        List<Integer> nonprimes = new ArrayList<>();

        for(int i=0;i< a.length;i++) {
            if(isPrime(a[i])){
                primes.add(a[i]);
                a[i] = -1;
            } else{
                nonprimes.add(a[i]);
            }
        }

        primes.sort((o1,o2)-> o1-o2);
        nonprimes.sort((o1,o2)-> o2-o1);

        int j = 0;
        int k = 0;
        for(int i=0;i< a.length;i++) {
            if(a[i] == -1){
                a[i] = primes.get(j++);
            } else {
                a[i] = nonprimes.get(k++);
            }
        }

        Arrays.stream(a).forEach((o)->System.out.print(o+","));
    }

    boolean isPrime(int a) {
        for(int i=2;i<=a/2;i++){
            if(a%i == 0) return false;
        }
        return true;
    }
}
