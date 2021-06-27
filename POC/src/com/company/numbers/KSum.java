package com.company.numbers;

import java.util.*;

public class KSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,List<List<Integer>>> sums = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                List<Integer> temp= Arrays.asList(i,j);
                int sum = nums[i]+nums[j];
                List<List<Integer>> a = sums.get(sum);
                if(a ==null){
                    a = new ArrayList<>();
                }
                a.add(temp);
                sums.put(sum,a);
            }
        }

        Object keys[] = sums.keySet().toArray();
        Set<Integer> hashes = new HashSet<>();

        for(int i=0;i<keys.length;i++){
            int temp = (int)keys[i];
            if(sums.containsKey(target-temp)){
                List<List<Integer>> a = sums.get(temp);
                List<List<Integer>> b = sums.get(target-temp);
                for(List<Integer> a1:a){
                    for(List<Integer> b1:b){
                        Set<Integer> t = new HashSet<>();
                        t.addAll(a1);
                        t.addAll(b1);
                        if(t.size() == 4 ){
                            List<Integer> entry = new ArrayList<>();
                            entry.add(nums[a1.get(0)]);
                            entry.add(nums[a1.get(1)]);
                            entry.add(nums[b1.get(0)]);
                            entry.add(nums[b1.get(1)]);
                            int unq[] = new int[4];
                            unq[0] = nums[a1.get(0)];
                            unq[1] = nums[a1.get(1)];
                            unq[2] = nums[b1.get(0)];
                            unq[3] = nums[b1.get(1)];
                            Arrays.sort(unq);
                            int hash = unq[0] + unq[1]*10+ unq[2]*100+ unq[3]*1000;
                            if(!hashes.contains(hash))  {
                                result.add(entry);
                                hashes.add(hash);
                            }

                        }
                    }
                }
            }
        }
        return result;
    }

    public <T> List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,List<List<Integer>>> sums = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                List<Integer> temp= Arrays.asList(i,j);
                int sum = nums[i]+nums[j];
                List<List<Integer>> a = sums.get(sum);
                if(a ==null){
                    a = new ArrayList<>();
                }
                a.add(temp);
                sums.put(sum,a);
            }
        }

        Object keys[] = sums.keySet().toArray();


        for(int i=0;i<keys.length;i++){
            int temp = (int)keys[i];
            if(sums.containsKey(target-temp)){
                List<List<Integer>> a = sums.get(temp);
                List<List<Integer>> b = sums.get(target-temp);
                for(List<Integer> a1:a){
                    for(List<Integer> b1:b){
                        Set<Integer> t = new HashSet<>();
                        t.addAll(a1);
                        t.addAll(b1);
                        if(t.size() == 4){
                            List<Integer> entry = new ArrayList<>();
                            entry.add(nums[a1.get(0)]);
                            entry.add(nums[a1.get(1)]);
                            entry.add(nums[b1.get(0)]);
                            entry.add(nums[b1.get(1)]);
                            result.add(entry);
                        }
                    }
                }
            }



        }

        return result;
    }
}
