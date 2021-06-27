package com.company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet740 {

    public static void main(String[] args) {
        Leet740 leet740 = new Leet740();
        int nums[] = {3,4,2};
        int nums2[] = {2, 2, 3, 3, 3, 4};
        int nums3[] = {1,1,1,2,4,5,5,5,6};
        leet740.deleteAndEarn(nums3);
    }

   // https://github.com/lonellliburd/delete-and-earn/blob/master/DeleteAndEarn.java
    public int deleteAndEarn(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int arr[] = new int[10001];

        for(int i=0;i<nums.length;i++){
            arr[nums[i]] = arr[nums[i]]+nums[i];
        }

        return rob(arr);

    }

    public int rob(int[] nums) {
        Map<Integer, Integer> maxMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            max = Math.max(max,sum(nums,i,maxMap));
        }
        return max;
    }

    int sum(int [] nums, int i,Map<Integer, Integer> maxMap){
        if(i >= nums.length) return 0;
        if(maxMap.get(i) != null) return maxMap.get(i);
        int curr = nums[i];
        int max = Math.max(curr+sum(nums,i+2, maxMap),sum(nums,i+1,maxMap));
        maxMap.put(i, max);
        return max;
    }

//    public int deleteAndEarn(int[] nums) {
//
//        for(int i=0;i<nums.length;i++){
//            createNode(nums[i]);
//        }
//
//        for(Integer id:graph.keySet()){
//            int suitableparent = getSuitableParent(id, nums);
//            if(suitableparent != -1 && !connected(id,suitableparent)){
//                union(id,suitableparent);
//            }
//        }
//
//        int max = Integer.MIN_VALUE;
//        for(Node n:graph.values()){
//            int sum = n.weight;
//            for(Integer i:n.children){
//                sum = sum+graph.get(i).weight;
//            }
//            max = Math.max(max,sum);
//        }
//
//        return max;
//    }
//
//    int getSuitableParent(int id, int nums[]){
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=id && nums[i] != id-1 && nums[i] != id+1){
//                return nums[i];
//            }
//        }
//        return -1;
//    }
//
//    boolean connected(int id1, int id2){
//
//        Node n1 = findSet(id1);
//        Node n2 = findSet(id2);
//        if(n1.id ==n2.id) return true;
//
//        return false;
//    }
//
//    Map<Integer, Node> graph = new HashMap<>();
//    class Node{
//        int id;
//        int weight;
//        int rank;
//        Node parent;
//        List<Integer> children = new ArrayList<>();
//        boolean visited;
//    }
//
//    void createNode(int id){
//        if(graph.get(id) != null){
//            graph.get(id).weight = graph.get(id).weight+id;
//            return;
//        }
//
//        Node n = new Node();
//        n.id = id;
//        n.weight = id;
//        n.rank = 0;
//        n.parent = n;
//
//        graph.put(id,n);
//    }
//
//    void union(int id1,int id2){
//
//        Node p1 = findSet(id1);
//        Node p2 = findSet(id2);
//
//        if(p1 == p2 ) return;
//
//        p1.children.add(p2.id);
//
//    }
//
//    Node findSet(int id){
//        if(graph.get(id).parent.id == id){
//            return graph.get(id);
//        }else{
//            return findSet(graph.get(id).parent.id);
//        }
//    }
}
