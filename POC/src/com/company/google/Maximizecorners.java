package com.company.google;

public class Maximizecorners {


    public static void main(String[] args) {
        Maximizecorners maximizecorners = new Maximizecorners();
        int nums[]= {110,100,40,20,50,10,300,90};
        System.out.println(maximizecorners.max(nums,0,nums.length-1,4));
        System.out.println(maximizecorners.optimizedMax(nums,4));
    }

    public int max(int nums[], int start, int end, int k){
        if(k > nums.length) return -1;
        if(k == 0) return 0;
        return Math.max(nums[start]+max(nums,start+1, end, k-1),
                nums[end]+max(nums,start, end-1, k-1));
    }

    public int optimizedMax(int nums[], int k){

        int righttoleft[] = new int[nums.length+1];
        int lefttoright[] = new int[nums.length+1];

        lefttoright[0] = 0;
        for(int i =1;i<=nums.length;i++){
            lefttoright[i] = lefttoright[i-1]+nums[i-1];
        }

        righttoleft[nums.length] = 0;
        for(int i = nums.length-1;i>=0;i--){
            righttoleft[i] = righttoleft[i+1]+nums[i];
        }

        int start = 0;
        int result = Integer.MIN_VALUE;
        for(int i=nums.length-k;i<nums.length;i++) {
            result = Math.max(result,lefttoright[start]+righttoleft[i]);
            start++;
        }

        return result;
    }
}
