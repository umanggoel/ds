package com.company.comoanyasked;

import com.company.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoundaryofTree {

    List<Integer> result = new ArrayList();
    Map<TreeNode, Boolean> visited = new HashMap<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        leftBoundary(root, 0);
        bootomBoundary(root);
        rightBoundary(root, 0);
        return result;
    }

    void leftBoundary(TreeNode root, int flag) {
        if(root == null || root.left == null && root.right == null) return;
        result.add(root.val);
        visited.put(root, true);
        if(root.left != null) {
            if(flag == 0) flag = 1;
            leftBoundary(root.left, flag);
        } else if(flag == 1){
            leftBoundary(root.right, flag);
        }
    }

    void bootomBoundary(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            visited.put(root, true);
            result.add(root.val);
            return;
        }
        bootomBoundary(root.left);
        bootomBoundary(root.right);
    }

    void rightBoundary(TreeNode root, int flag) {
        if(root == null || root.left == null && root.right == null) return;

        if(root.right != null){
            if(flag  == 0) flag =1;
            rightBoundary(root.right, flag);
        }else if(flag == 1){
            rightBoundary(root.left, flag);
        }

        if(visited.get(root) == null || !visited.get(root)){
            result.add(root.val);
            visited.put(root, true);
        }

    }
}