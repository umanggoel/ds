package com.company.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StonesRemovalGame {

    public int removeStones(int[][] stones) {

        Arrays.sort(stones,(o1, o2)->o1[0]-o2[0]);
        int result= 0;
        for(int i=0;i<stones.length-1;i++){
            if(stones[i][0] == stones[i+1][0]){
                createConnection(stones[i][0],stones[i+1][1]);
            }
        }
        return result;
    }

    Map<Integer,Node> nodes =new HashMap<>();

    private void makeSet(int value){
        if(nodes.get(value) == null){
            Node n = new Node();
            n.id = value;
            n.parent = n;
            nodes.put(value,n);
        }
    }

    Node findParent(int n1){
        if (nodes.get(n1) != null){
            return findSet(nodes.get(n1));
        }
        return null;
    }

    private Node findSet(Node n){
        if(n.parent == n){
            return n;
        }else{
            return findSet(n.parent);
        }
    }

    private boolean createConnection(int n1, int n2){
        if(nodes.get(n1) == null){
            makeSet(n1);
        }
        if(nodes.get(n2) == null){
            makeSet(n2);
        }

        Node node1 = findParent(n1);
        Node node2 = findParent(n2);

        if(node1.parent.id == node2.parent.id){
            return true;
        }

        node2.parent = node1;
        return false;
    }

    class Node{
        int id;
        Node parent;
    }
}
