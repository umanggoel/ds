package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        minpath(root,sum,result,new ArrayList<Integer>());
        return result;
    }

    boolean minpath(TreeNode root, int sum, List<List<Integer>> result, List<Integer> curr){
        if(root == null) return false;
        if(root.left==null && root.right == null){
            if(sum == root.val){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(curr);
                temp.add(root.val);
                result.add(temp);
            }
            return sum == root.val;
        }

        List<Integer> temp = new ArrayList<>();
        temp.addAll(curr);
        temp.add(root.val);
        boolean left = false;
        if(root.left != null){
            left = minpath(root.left,sum-root.val,result,temp);
        }

        boolean right = false;
        if(root.right != null){
            right = minpath(root.right,sum-root.val, result,temp);
        }

        return left || right;
    }
}
