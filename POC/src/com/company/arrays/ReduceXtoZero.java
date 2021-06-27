package com.company.arrays;

public class ReduceXtoZero {

    public static void main(String[] args) {
        ReduceXtoZero reduceXtoZero = new ReduceXtoZero();
        int a[] = {1,1};

        reduceXtoZero.minOperations(a, 3);
    }

    public int minOperations(int[] nums, int x) {
        int len = nums.length;

        int sums[] = new int[len+1];
        for(int i = 1 ;i<=len;i++) {
            sums[i] = sums[i-1]+nums[i-1];
        }


        int right[] = new int[len+1];
        right[len-1] = nums[len-1];
        for(int i = len-2 ;i>=0;i--) {
            right[i] = right[i+1]+nums[i];
        }

        if(x > sums[len] || x > right[0]) return -1;

        int st = len;
        int end = len;
        int result = Integer.MAX_VALUE;

        while(st >= 0) {
            int temp = sums[st] + right[end];
            if(temp  == x) {
                result = Math.min(st+len-end, result);
                end--;
                st--;
            }else if(temp < x) {
                end--;
            }else {
                st--;
            }
        }

        if(result == Integer.MAX_VALUE) return -1;
        return result;
    }
}
