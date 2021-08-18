package com.company.comoanyasked;

import com.company.Tree.TreeNode;

/*
Given the root of a binary search tree (BST) and an integer target,
split the tree into two subtrees where one subtree has nodes that are all smaller
or equal to the target value, while the other subtree has all nodes that are greater than the target value.
It Is not necessarily the case that the tree contains a node with the value target.
Additionally, most of the structure of the original tree should remain.
Formally, for any child c with parent p in the original tree,
if they are both in the same subtree after the split, then node c should still have the parent p.
Return an array of the two roots of the two subtrees.
Example 1:
Input: root = [4,2,6,1,3,5,7], target = 2
Output: [[2,1],[4,3,6,null,null,5,7]]
 */
public class SplitBST776 {

        TreeNode[] result = new TreeNode[2];
        public TreeNode[] splitBST(TreeNode root, int target) {
            result = new TreeNode[2];
            foo(root, null, target);
            return result;
        }

        void foo(TreeNode root, TreeNode parent,int target) {
            if(root == null) return;

            if(root.val == target) {
                TreeNode right = root.right;
                root.right = null;
                result[0] = root;
                if(parent == null) {
                    result[1] = right;
                }else{
                   if(parent.val > root.val) {
                       parent.left = right;
                   }else{
                       parent.right = right;
                   }
                   result[1] = parent;
                }
                return;
            }

            if(target < root.val ){
                foo(root.left, root, target);
            }else{
                foo(root.right, root, target);
            }

        }
}
