package com.company.arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] arr= {1,1,2,3,4,5,6,6,6,8,10,10,10,10,11};
        for(Integer i: removeDuplicates.removeDuplicates(arr)){
            System.out.print(i+",");
        }

    }
    int[] removeDuplicates(int[] arr) {
        int index = 0;
        for(int i= 1;i<arr.length;i++) {
            if(arr[index] != arr[i]){
                index++;
                arr[index] = arr[i];
            }
        }

        return Arrays.copyOf(arr, index+1);
    }
}
