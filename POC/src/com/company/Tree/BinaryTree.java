package com.company.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null) return false;

        if(root.val == x || root.val == y)  {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> bfs =  new ArrayList<>();

        while(!q.isEmpty()){

            TreeNode node = ((LinkedList<TreeNode>) q).pop();

            if(node == null) {
                bfs.add(null);
                continue;
            }

            bfs.add(node.val);

            ((LinkedList<TreeNode>) q).add(node.left);
            ((LinkedList<TreeNode>) q).add(node.right);
        }


        int xIndex = bfs.indexOf(x);
        int yIndex = bfs.indexOf(y);

        if((xIndex-1)/2 == (yIndex-1)/2){
            return false;
        }
        return true;

    }
}
