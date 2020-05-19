package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> answer = new ArrayList<>();

    void getCandidates(int[] nums,int rem, List<Integer> result){
        if(rem == 0){
            answer.add(result);
            return;
        }

        for(int i=0;i< nums.length;i++){
            int t = rem-nums[i];
            if(t >= 0){
                List<Integer> temp = new ArrayList<>(result);
                temp.add(nums[i]);
                getCandidates(nums,t,temp);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] c, int target) {
        getCandidates(c,target,new ArrayList<>());
        return answer;

    }
}
