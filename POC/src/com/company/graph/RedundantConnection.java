package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {

        int result[] = new int[2];
        for(int i=0;i<edges.length;i++){
            if(!createConnection(edges[i][0],edges[i][1])){
                result = edges[i];
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
            return false;
        }

        node2.parent = node1;
        return true;
    }

    class Node{
        int id;
        Node parent;
    }
}
