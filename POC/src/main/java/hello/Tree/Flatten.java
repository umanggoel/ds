package com.company.Tree;

public class Flatten {

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        TreeNode n = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        n.left = n1;
        n1.right = n2;

        flatten.flatten(n);
        while (n!= null) {
            System.out.println(n.val);
            n= n.right;
        }

    }
    public void flatten(TreeNode root) {
        TreeNode result = new TreeNode();
        flat(root, result);
        root =result.right;

    }

    void flat(TreeNode root, TreeNode temp) {
        if(root == null) {
            return;
        }
        temp.right = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null){
            temp = temp.right;
            flat(left, temp);

        }

        if(temp != null)  temp.left = null;
        if(right != null) {
            while(temp.right != null){
                temp = temp.right;
            }
            if(temp != right) flat(right, temp);
        }
        if(temp != null)  temp.left = null;

    }
}
