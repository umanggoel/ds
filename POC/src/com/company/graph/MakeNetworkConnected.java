package com.company.graph;

import java.util.HashMap;
import java.util.Map;

public class MakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {

        for(int i=0;i<n;i++){
            makeSet(i);
        }

        int extraEdges = 0;
        int disconnectedNodes = 0;

        for(int i=0;i<connections.length;i++){
            if(!union(connections[i][0],connections[i][1])){
                extraEdges++;
            }
        }

        for(Node entry:map.values()){
            if(entry.value  == entry.parent.value){
                disconnectedNodes++;
            }
        }

        System.out.println(extraEdges);
        System.out.println(disconnectedNodes);

        if(extraEdges >= disconnectedNodes-1){
            return disconnectedNodes-1;
        }

        return -1;
    }

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
        node.rank = 0;
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


    boolean union(int val1, int val2){
        Node n1 = map.get(val1);
        Node n2 = map.get(val2);

        Node parent1 = findSet(n1);
        Node parent2 = findSet(n2);

        if(parent1 == parent2) return false;

        if(parent1.rank < parent2.rank){
            parent1.parent = parent2;
            parent2.rank = parent2.rank+1;
            parent1.rank = 0;
        } else {
            parent2.parent = parent1;
            parent1.rank = parent1.rank+1;
            parent2.rank = 0;
        }

        return true;
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
