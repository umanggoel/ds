package com.company.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSets {

    Map<Integer, Node> map= new HashMap<>();
    //findset, union, makeset, path-compression

    class Node{
        int value;
        Node parent;
        int rank;
    }

    void makeSet(int value){
        Node node = new Node();
        node.parent = node;
        node.rank =0;
        node.value= value;
        map.put(value, node);
    }

    Node findSet(int value){
        Node n = map.get(value);
        if(n == null){
            System.out.print("no node found");
            return null;
        } else {
            Node result = findSet(n);
            if(n.parent != result){
                n.parent = result;
            }
            return result;
        }
    }

    private Node findSet(Node n){
        if(n.parent == n){
            return n;
        }else{
           return findSet(n.parent);
        }
    }


    void union(int val1, int val2){
        Node n1 = map.get(val1);
        Node n2 = map.get(val2);

        Node parent1 = findSet(n1);
        Node parent2 = findSet(n2);

        if(parent1 == parent2) return;

        if(parent1.rank < parent2.rank){
            parent1.parent = parent2;
            parent2.rank = parent2.rank+1;
            parent1.rank = 0;
        } else {
            parent2.parent = parent1;
            parent1.rank = parent1.rank+1;
            parent2.rank = 0;
        }
    }

    boolean connected(int val1 , int val2){
        if(findSet(val1) == findSet(val2)){
            return true;
        }
        return false;
    }

    Node getNode(int val){
        return map.get(val);
    }

}
