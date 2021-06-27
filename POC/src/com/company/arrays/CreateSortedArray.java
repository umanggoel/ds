package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

public class CreateSortedArray {


    public static void main(String[] args) {
        CreateSortedArray createSortedArray = new CreateSortedArray();
        int a[] = {1,5,6,2};
        createSortedArray.createSortedArray(a);
    }
    public int createSortedArray(int[] inst) {

        int len = inst.length;
        List<Integer> temp = new ArrayList<>();
        int cost = 0;
        for(int i = 0;i< inst.length;i++) {
            int size = temp.size();
            int[] counts = counts(temp, inst[i], size);
            cost = cost + Math.min(counts[0],counts[1]);
            temp.add(counts[0],inst[i]);

        }
        return cost;
    }

    int[] counts(List<Integer> list, int num, int size) {
        int[] result = new int[2];
        if(size == 0) return result;
        boolean g = true;
        for(int i = 0;i<size;i++) {
            if(g && list.get(i) >= num ) {
                result[0] = i;
                g = false;
            }

            if(!g && list.get(size-1-i) <= num ) {
                result[1] = i;
                break;
            }

        }
        return result;
    }
}
