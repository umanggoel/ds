package com.company.arrays;

public class StrictNumber {

    public static void main(String[] args) {
       // int [] input = {9895, 30334, 17674, 23812, 20038, 25668, 6869, 1870, 4665, 27645, 7712, 17036, 31323, 8724, 28254, 28704, 26300, 25548, 15142, 12860, 19913, 32663, 32758};


        int  []input = {1,5,3,6,7};
        StrictNumber strictNumber = new StrictNumber();
        System.out.println(strictNumber.strictNumber(input));

    }
    int strictNumber(int [] arr) {

        if(arr == null) return 0;

        int len = arr.length;
        if(arr.length <= 2 ) return 0;

        int leftMax[] = new int[len];
        int rightSmall[] = new int[len];

        leftMax[0] = arr[0];
        rightSmall[len-1] = arr[len-1];

        for(int i=1;i<len;i++) {
            if(arr[i] > leftMax[i-1]){
                leftMax[i] = arr[i];
            } else{
                leftMax[i] = leftMax[i-1];
            }
        }


        for(int i=len-2;i>=0;i--) {
            if(arr[i] < rightSmall[i+1]){
                rightSmall[i] = arr[i];
            } else{
                rightSmall[i] = rightSmall[i+1];
            }
        }

        for(int i=1;i<=len-2;i++) {
            if(leftMax[i-1] < arr[i] && rightSmall[i+1] > arr[i]) {
                return 1;
            }
        }

        return 0;
    }
}
