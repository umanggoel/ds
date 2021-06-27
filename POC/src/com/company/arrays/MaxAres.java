package com.company.arrays;

public class MaxAres {

    public int maxArea(int[] height) {

        int len = height.length;
        int rightMax[] = new int[len];
        int leftMax[] = new int[len];

        rightMax[len-1] = height[len-1];
        for(int i=len-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        leftMax[0] = height[0];
        for(int i=1;i<len;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int result = 0;
        for(int i=0;i<len;i++){
            result = result+(Math.min(leftMax[i],rightMax[i])-height[i]);
        }

        return result;
    }
}
