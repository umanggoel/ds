package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.List;

public class HorizontalDistancePrint {

    public static void main(String[] args) {

        TreeNode root = new TreeNode("A");
        TreeNode rootB = new TreeNode("B");
        TreeNode rootC = new TreeNode("C");
        TreeNode rootD = new TreeNode("D");
        TreeNode rootE = new TreeNode("E");

        root.left = rootB;
        rootB.left = rootD;
        rootD.right = rootC;
        rootD.left = rootE;

        List<String> path = new ArrayList<>();
        List<Integer> traj = new ArrayList<>();
        roottoleaf(root, path, traj, 0);

    }


    static void roottoleaf(TreeNode root, List<String> path, List<Integer> trajectory, int prev) {

        if(root == null) return;
        if(root.left == null && root.right == null) {
            path.add(root.val);
            trajectory.add(prev);
            int max = Integer.MIN_VALUE;

            for(Integer i: trajectory) {
                max = Math.max(i, max);
            }

            for(int i =0;i< path.size();i++) {
                int spaces = max- trajectory.get(i);

                String temp = path.get(i);
                for(int j=0;j<spaces;j++){
                    temp = "_"+temp;
                }

                System.out.println(temp);
            }
            trajectory.remove(trajectory.size()-1);
            path.remove(path.size()-1);
            return;
        }

        path.add(root.val);
        trajectory.add(prev);

        if(root.left != null) {
            roottoleaf(root.left, path, trajectory, prev+1);
        }

        if(root.right != null) {
            roottoleaf(root.right, path, trajectory, prev-1);
        }

        trajectory.remove(trajectory.size()-1);
        path.remove(path.size()-1);

    }

    static  class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        TreeNode(String val) {
            this.val = val;
        }

    }
}



//Your previous Plain Text content is preserved below:
//
//Print all root to leaf paths with there relative positions
//
//Input : Root of below tree
//         A
//       /       \
//      B      C
//     / \       / \
//    D   E   F  G
//         /
//      x
//         \
//        Y
//Output : All root to leaf paths
//_ _ A
//_ B
//D
//
//_ A
//B
//_ E
//_ _ X
//_ _ _ Y
//
//A
//_ C
//F
//
//A
//_ C
//_ _ G
