package com.company.google;

import com.company.Tree.TreeNode;

public class FlipEquivalent {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        return foo(root1, root2);
    }


    boolean foo(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null || root1.val != root2.val) return false;

        if(foo(root1.left, root2.left) && foo(root1.right, root2.right)){
            return true;
        }else if(foo(root1.right, root2.left) && foo(root1.left, root2.right)){
            return true;
        }
        return false;
    }
}
