package com.company.Tree;

public class SortedListToBST109 {

     class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    TreeNode generateTreesRecurcively(ListNode head, ListNode end){

        if(head == end){
            return null;
        }

        ListNode center = getCenter(head,end);
        TreeNode left = generateTreesRecurcively(head,center);
        TreeNode right = generateTreesRecurcively(center.next,end);

        TreeNode n = new TreeNode(center.val);
        n.left = left;
        n.right = right;
        return n;
    }

    ListNode getCenter(ListNode start, ListNode end){
        if(start == null) return null;
        ListNode p1 = start;
        ListNode p2 = start.next;

        while(p1 != null && p2!= end && p2.next != end){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1;
    }
}
