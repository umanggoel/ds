package com.company.comoanyasked;

public class Jumpgame2 {

    public static void main(String[] args) {
        Jumpgame2  jumpgame2 = new Jumpgame2();
        jumpgame2.jump(new int[]{2,3,1,1,4});
    }

    public int jump(int[] nums) {

        int len = nums.length;
        int index[] = new int[len];

        for(int i =1;i<len;i++) {

            int j = 0;
            while(j < i) {
                if(nums[j] + j>= i){
                    if(index[i] == 0) {
                        index[i] = index[j] + 1;
                    }else {
                        index[i] = Math.min(index[j] + 1, index[i]);
                    }
                }
                j++;
            }

        }

        return index[len-1];
    }
}