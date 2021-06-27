package com.company.arrays;

public class DutchFlag {

    public static void main(String[] args) {
        DutchFlag  dutchFlag = new DutchFlag();
        int[] result = dutchFlag.sortColors(new int[]{2,2,0,0,1,1,2,2,2,1,1,1,0,0,2});
        System.out.print(result);
    }

    public int[] sortColors(int[] input) {

        if(input == null || input.length <2) return input;

        int start = 0;
        int index = 0;
        int end = input.length-1;

        while(index < end && start < end) {
            if(input[index] == 0) {
                swap(input, index, start);
                index++;
                start++;
            }
            if(input[index] == 2){
                swap(input, index, end);
                end--;
            }
            else{
                index++;
            }
        }

        return input;
    }

    private void swap(int[] input, int index, int end) {
        int temp = input[index];
        input[index] = input[end];
        input[end] = temp;
    }
}
