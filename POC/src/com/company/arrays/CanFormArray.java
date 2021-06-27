package com.company.arrays;

import java.util.HashMap;
import java.util.Map;

public class CanFormArray {

    public static void main(String[] args) {
        CanFormArray a = new CanFormArray();
        int arr[] = {85};
        int p[][] = {{85}};
        a.canFormArray(arr, p);
    }
    public boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i< pieces.length-1;i++) {
            map.put(pieces[i][0],i);
        }

        for(int i = 0;i<arr.length;i++) {
            if(map.get(arr[i]) != null) {
                for(int j = 1;j<pieces[map.get(arr[i])].length;j++){
                    i++;
                    if(arr[i] !=  pieces[map.get(arr[i])][j]) return false;
                }
            } else{
                return false;
            }
        }

        return true;


    }
}
