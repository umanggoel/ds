package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum3(3, 7);
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        for(int i = 1;i<9-k;i++) {
            foo(k, n, 0, new ArrayList(), i);
        }
        return result;
    }

    boolean foo(int k, int n, int curr, List<Integer> list, int start) {
        if(curr > n || k < 0) return false;

        if(k == 0){
            if(n == curr){
                List<Integer> t = new ArrayList();
                t.addAll(list);
                result.add(t);
                return true;
            }
            return false;
        }

        List<Integer> temp = new ArrayList();
        temp.addAll(list);
        temp.add(start);

        int tCurr = curr+start;
        int tk = k-1;
        for(int i = start+1;i<=9;i++) {
            if(foo(tk, n, tCurr, temp, i)){
                temp.remove(temp.size()-1);
                return true;
            }
        }
        temp.remove(temp.size()-1);

        return false;

    }
}


