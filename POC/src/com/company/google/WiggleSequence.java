package com.company.google;

import java.util.ArrayList;
import java.util.List;

public class WiggleSequence {

    public static void main(String[] args) {
        WiggleSequence wiggleSequence= new WiggleSequence();
        int nums[] = {3,3,3,2,5};
        int nums1[] ={1,1,7,4,9,2,5};
        wiggleSequence.wiggleMaxLength(nums1);
    }

    public int wiggleMaxLength(int[] nums) {

        if (nums.length < 2) return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
//        if(nums.length == 0) return 0;
//        if(nums.length == 1) return 1;
//        int[] diff = new int[nums.length-1];
//        for(int i=1;i<nums.length;i++){
//            diff[i-1] = nums[i]-nums[i-1];
//        }
//
//        List<Integer> result = new ArrayList<>();
//
//        int count = 0;
//        while(count < diff.length && diff[count] == 0){
//            count++;
//        }
//
//        if(count == diff.length) return 1;
//        if(count == diff.length-1) return 2;
//        result.add(nums[count++]);
//        result.add(nums[count]);
//
//
//        if(diff[count-1] < 0){
//            boolean next = true;
//            for(int i=count+1;i<nums.length;i++){
//                if(nums[i] - nums[count] > 0 && next){
//                    result.add(nums[i]);
//                    count++;
//                    next = false;
//                }else if(nums[i] - nums[count] < 0 && !next){
//                    result.add(nums[i]);
//                    count++;
//                    next = true;
//                }
//            }
//        }else{
//            boolean next = true;
//            for(int i=count+1;i<nums.length;i++){
//                if(nums[i] - nums[count] < 0 && next){
//                    result.add(nums[i]);
//                    count++;
//                    next = false;
//                }else if(nums[i] - nums[count] > 0 && !next){
//                    result.add(nums[i]);
//                    count++;
//                    next = true;
//                }
//            }
//        }
//        return result.size();
    }
}
