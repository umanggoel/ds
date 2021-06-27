package com.company.Tree;

public class InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null) return new TreeNode(val);
        getPosition(root, val);
        return root;


    }

    TreeNode getPosition(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(val < root.val) {
            TreeNode n = getPosition(root.left, val);
            if(n!= null) root.left = n;
        }

        if(val > root.val) {
            TreeNode n = getPosition(root.right, val);
            if(n!= null) root.right = n;
        }

        return null;

    }
}
