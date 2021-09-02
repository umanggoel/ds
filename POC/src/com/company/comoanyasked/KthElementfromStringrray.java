package com.company.comoanyasked;

import java.util.Arrays;

public class KthElementfromStringrray {


    public static void main(String[] args) {
        KthElementfromStringrray kthElementfromStringrray = new KthElementfromStringrray();
        kthElementfromStringrray.kthLargestNumber(new String[]{"3","6","7","10"}, 4);
    }

    public String kthLargestNumber(String[] nums, int k) {

        Arrays.sort(nums, (a, b) ->{
            if(a.length() == b.length()){
                char ca[] = a.toCharArray();
                char cb[] = b.toCharArray();
                int i =0;
                int j =0;

                while(i< a.length() && j< b.length()){
                    if(ca[i] == cb[j]){
                        i++;
                        j++;
                    }else{
                        if(ca[i] > cb[j]){
                            return 1;
                        }else{
                            return -1;
                        }
                    }
                }
            }else if(a.length() > b.length()){
                return 1;
            }

            return -1;

        });

        return nums[nums.length-k];

    }
}