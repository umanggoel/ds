package com.company.Tree;

public class Main {

    public static void main(String[] args) {
        PsedoPalindromicPaths psedoPalindromicPaths = new PsedoPalindromicPaths();
        // psedoPalindromicPaths.pseudoPalindromicPaths(new TreeNode());

        BST bst = new BST();
        // bst.constructBST(new int[]{10, 5, 1, 7, 40, 50},0,6);
        //bst.constructBST(new int[]{4,2},0,2);

        int n =7;
        int t = 2;
        int target = 4;
        int edges[][] = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};

        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.frogPosition(n,edges,t,target));
    }
}
