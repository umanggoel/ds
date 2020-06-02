package com.company.Tree;

public class DeepestLeavesSum {

        public int deepestLeavesSum(TreeNode root) {
            Depth maxDepth = new Depth();
            dfs(root,1,maxDepth);
            return maxDepth.sum;
        }

        void dfs(TreeNode root, int currDepth, Depth maxDepth){
            if(root == null) return;

            if(root.left == null && root.right == null){
                if(currDepth > maxDepth.max){
                    maxDepth.max = currDepth;
                    maxDepth.sum = root.val;
                }else if(currDepth == maxDepth.max){
                    maxDepth.sum = maxDepth.sum+root.val;
                }
            }

            dfs(root.left, currDepth+1,maxDepth);
            dfs(root.right, currDepth+1,maxDepth);

        }

        class Depth{
            int max = Integer.MIN_VALUE;
            int sum = 0;
        }


}
