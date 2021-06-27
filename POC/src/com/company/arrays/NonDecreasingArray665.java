package com.company.arrays;

public class NonDecreasingArray665 {
    public static void main(String[] args) {
        NonDecreasingArray665 nonDecreasingArray665 =new  NonDecreasingArray665();
       // int arr[] = {-1,4,2,3};
        int arr[] ={3,4,2,3};
        nonDecreasingArray665.checkPossibility(arr);
    }

    boolean checkPossibility(int[] arr) {
        int modify = 0;
        int n = arr.length;
        if (arr[n - 1] < arr[n - 2]) {
            arr[n - 1] = arr[n - 2];
            modify++;
        }

        if (arr[0] > arr[1]) {
            arr[0] = arr[1];
            modify++;
        }

        for (int i = n-2;i > 0; i--) {
            if (arr[i - 1] < arr[i] && arr[i+1] < arr[i] || arr[i + 1] > arr[i] && arr[i - 1] > arr[i]){
                arr[i] = (arr[i - 1] + arr[i + 1]) / 2;
                modify++;
            }
        }

        if (modify > 1)
            return false;

        return true;
    }
}
