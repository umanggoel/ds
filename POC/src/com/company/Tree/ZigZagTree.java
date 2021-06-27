package com.company.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ZigZagTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        int order = 0;
        q.add(root);

        while(!q.isEmpty()){
            q.add(null);
            List<Integer> temp = new ArrayList<>();
            TreeNode n = q.poll();
            while(n != null){
                if(n.left!= null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);

                if(order%2 == 0){
                    temp.add(n.val);
                }else{
                    temp.add(0,n.val);
                }
                n = q.poll();
            }
            order++;
            result.add(temp);
        }

        return result;

    }

    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry e : map.entrySet()){
            if((int)e.getValue() == 1){
                result.add((int)e.getKey());
            }
        }

        int r[] = new int[result.size()];

        for(int i=0;i<result.size();i++){
            r[i] = result.get(i);
        }
        return r;
    }
}
