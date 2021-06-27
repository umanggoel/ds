package com.company.Tree;

public class SortedArraytoBST108 {

    public static void main(String[] args) {
        SortedArraytoBST108 sortedArraytoBST108 = new SortedArraytoBST108();
        sortedArraytoBST108.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return generateTreesRecurcively(nums, 0, nums.length-1);
    }

    TreeNode generateTreesRecurcively(int [] nums, int start, int end){

        if(start > end) return null;
        if(start ==  end) return new TreeNode(nums[start]);
        int mid = (start+end)/2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = generateTreesRecurcively(nums,start,mid-1);;
        n.right = generateTreesRecurcively(nums,mid+1,end);
        return n;

    }
}
