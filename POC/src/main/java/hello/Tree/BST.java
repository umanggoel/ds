package com.company.Tree;


public class BST {

    TreeNode constructBST(int preorder[],int start, int end){
        if(end < 0 || start < 0|| end > preorder.length || start >= end ){
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = preorder[start];
        int index = -1;

        for(int i=start+1;i<end;i++){
            if(preorder[i] > preorder[start]) {
                index = i;
                break;
            }
        }

        if(index == -1){
            index = end;
        }
        node.left = constructBST(preorder,start+1,index);
        node.right = constructBST(preorder, index,end);
        return node;
    }
}
