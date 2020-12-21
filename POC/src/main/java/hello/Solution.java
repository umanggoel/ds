package com.company;

public class Solution {

    public static void main(String args[]) {

        Node root = new Node();
        Node left = new Node();
        Node right = new Node();
        root.value = 10;
        left.value = 5;
        left.right =right;
        right.value = 8;
        root.left = left;
        root.right = right;
        Count c = new Count();
        findSecondLargest(root, c, 2);
        System.out.print(c.result);
    }

    public static void findSecondLargest(Node node, Count c, int k) {
        if(node == null) return;

        findSecondLargest(node.right, c , 2);
        c.c++;
        if(c.c == k) {
            c.result = node.value;
        }
        findSecondLargest(node.left, c , 2);

    }
}

class Count {
    int c = 1;
    int result;
}
class Node {
    int value;
    Node right;
    Node left;
}