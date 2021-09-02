package com.company.comoanyasked;

public class IncreasingTriplet {

    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        increasingTriplet.increasingTriplet(new int[]{2,1,5,0,4,6});
    }

        public boolean increasingTriplet(int[] nums) {
            return solve(nums);
        }
        public boolean solve(int[] a) {

            int len = a.length;
            int rightMax[] = new int[len];
            rightMax[len-1] = 0;
            for(int i = len-2;i>=0;i--) {
                if(a[i] < a[i+1]) {
                    rightMax[i] = rightMax[i+1]+1;
                }else{
                    rightMax[i] = rightMax[i+1];
                }
            }

            for(int i = 0;i<len;i++) {
                if(rightMax[i]>=2) {
                    return true;
                }
            }

            return false;
        }


}
