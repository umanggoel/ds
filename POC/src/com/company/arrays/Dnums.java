package com.company.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
public class Dnums {

    public static void main(String[] args) {
        Dnums dnums = new Dnums();
        int a[] = {1,1,1,1};
        dnums.dNums(a,3);
    }

    public int[] dNums(int[] a, int b) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = 0;i< a.length;i++) {
            if(count  == b){
                count--;
                list.add(map.size());
                if(map.get(a[i-b]) > 1){
                    map.put(a[i-b], map.get(a[i-b])-1);
                } else{
                    map.remove(a[i-b]);
                }
            }
            count++;
            map.put(a[i], map.getOrDefault(a[i],0)+1);
        }

        int result [] = new int[list.size()];

        for(int i= 0;i< list.size();i++) {
            result[i] = list.get(i);
        }
        return result;

    }

}
