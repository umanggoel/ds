package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {
    public List<TreeNode> generateTrees(int n) {

        if(n == 0) return new ArrayList<>();
        return generateTreesRecurcively(1,n);

    }

    List<TreeNode> generateTreesRecurcively(int start, int end){

        List<TreeNode> result = new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }

        for(int i=start;i<=end;i++){

            List<TreeNode> left = generateTreesRecurcively(start,i-1);
            List<TreeNode> right = generateTreesRecurcively(i+1,end);

            for(TreeNode l:left){
                for(TreeNode r:right){

                    TreeNode n = new TreeNode(i);
                    n.left = l;
                    n.right = r;
                    result.add(n);
                }
            }
        }

        return result;
    }

}
