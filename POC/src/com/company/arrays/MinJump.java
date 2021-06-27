package com.company.arrays;

public class MinJump {
    public int jump(int[] nums) {

        int temp[] =new int[nums.length];
        int j=0;

        for(int i=1;i<nums.length;i++){

            while(j<i){
                if(i-j<=nums[j]){
                    if(temp[i] == 0){
                        temp[i] = temp[j]+1;
                    }else{
                        temp[i]=Math.min(temp[j]+1,temp[i]);
                    }
                }
                j++;
            }
            j=0;
        }

        return temp[nums.length-1];
    }

    public boolean canJump(int[] nums) {

        int len = nums.length;
        if(len == 1) return true;
        if(nums[0] == 0) return false;
        int j=0;
        int temp[] = new int[len];


        for(int i=1;i<len;i++){
            j=0;
            while(j < i){
                if( i-j <= nums[j]){
                    if(temp[i] == 0){
                        temp[i] = 1+temp[j];
                    }else{
                        temp[i] = Math.min(1+temp[j],temp[i]);
                    }
                }
                j++;
            }
        }

        if(temp[len-1] == 0) return false;
        return true;
    }
}
