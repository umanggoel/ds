package com.company.graph;

import java.util.HashMap;
import java.util.Map;

public class MinSwapCouples {
    public int minSwapsCouples(int[] row) {

        int len = row.length;
        int n = row.length/2;
        int i = 0;
        boolean last = false;
        for(i=0;i<row.length-1;i++){
            makeSet(row[i]);
            if((int)row[i]/2 == (int)row[i+1]/2 && Math.abs(row[i]-row[i+1])==1){
                makeSet(row[i+1]);
                union(row[i],row[i+1]);
                i++;
            }

        }

        if((int)row[len-2]/2 == (int)row[len-1]/2 && Math.abs(row[len-2]-row[len-1])==1){
            makeSet(row[i+1]);
            union(row[i],row[i+1]);
        } else {
            makeSet(row[len-1]);
        }

        int disconnectedNodes = 0;

        for(Node entry:map.values()){
            if(entry.value  == entry.parent.value){
                disconnectedNodes++;
            }
        }

        return (disconnectedNodes - n)/2;

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
