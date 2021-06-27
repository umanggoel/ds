package com.company.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerPermutations {

    public List<List<Integer>> permute(int[] nums) {
        return permutations(nums, new ArrayList<>(),0);
    }
    public List<List<Integer>> permutations(int[] nums, List<List<Integer>> list, int start){

        if(start == nums.length-1){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[start]);
            list.add(temp);
            return list;
        }

        list = permutations(nums,list,start+1);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<=list.get(i).size();j++){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(list.get(i));
                temp.add(j,nums[start]);
                result.add(temp);
            }
        }

        Set<Integer> s = new HashSet<>();
        s.toArray();
        return result;

    }
}
