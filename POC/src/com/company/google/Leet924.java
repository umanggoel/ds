package com.company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//find connected components
//count elements in connected components
//if number of infercted is less then the number of elements in connected components chosse the smallest number.
public class Leet924 {

    public static void main(String[] args) {
        Leet924 leet924 = new Leet924();
//        int[][] mat = {{1,1,0},{1,1,0},{0,0,1}};
//        int [] init ={0,1};

        int[][] mat = {{1,0,0,0},{0,1,0,0},{0,0,1,1},{0,0,1,1}};

        int [] init ={3,1};
        leet924.minMalwareSpread(mat,init);
    }
    public int minMalwareSpread(int[][] graph, int[] initial) {

        int n = graph.length;
        for(int i=0;i<n;i++){
            makeSet(i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i > j && graph[i][j] == 1){
                    union(i,j);
                }
            }
        }

        Map<Integer,Integer> set = new HashMap<>();
        for(int i=0;i<initial.length;i++){
            set.put(initial[i],i);
        }

        Map<Integer, List<Integer>> cc = new HashMap<>();
        for(Node node: map.values()){
            Node p = findSet(node.value);
            if(cc.get(p.value) == null){
                cc.put(p.value, new ArrayList<Integer>());
            }
            cc.get(p.value).add(node.value);
        }

        int result = Integer.MAX_VALUE;
        for(List<Integer> list: cc.values()){
            int size = list.size();
            int min = Integer.MAX_VALUE;
            int count = 0;
            for(Integer id: list){
                if(set.keySet().contains(id)){
                    min = Math.min(min, set.get(id));
                    count++;
                }
            }

            if(count <= size){
                result = Math.min(result,min);
            }

        }
        return initial[result];
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

        parent1.parent = parent2;

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
