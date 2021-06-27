package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        ArrayList<Integer>[] al = new ArrayList[n];
        int[] degrees = new int[n];

        for(int i=0; i < n; i++) al[i] = new ArrayList<>();

        for(int[] edge: edges) {

            al[edge[0]].add(edge[1]);
            al[edge[1]].add(edge[0]);

            degrees[edge[0]]++;
            degrees[edge[1]]++;

        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i < n; i++) if(degrees[i] == 1) list.add(i);

        while(list.size() != 0) {

            ArrayList<Integer> next = new ArrayList<>();

            for(int node: list) {
                degrees[node]--;
                for(int neighbor: al[node]) if(--degrees[neighbor] == 1) next.add(neighbor);
            }

            if(next.size() == 0) return list;

            list = next;

        }

        list.add(0);

        return list;
    }

    public List<Integer> findMinHeightTreesTLE(int n, int[][] edges) {

        for(int i = 0;i<n;i++){
            makeSet(i);
        }

        for(int i=0;i<edges.length;i++){
            union(edges[i][0],edges[i][1]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int height = height(nodes.get(i),-1);
            max = Math.min(max,height);
            if(map.get(height) == null){
                map.put(height, new ArrayList<>());
            }
            map.get(height).add(i);
        }

        return map.get(max);
    }

    Map<Integer,Node> nodes = new HashMap<>();
    Map<Long, Integer> hashes = new HashMap<>();
    class Node{
        int id;
        List<Node> children = new ArrayList<>();
    }

    void makeSet(int i){
        Node n = new Node();
        n.id = i;
        nodes.put(i, n);
    }

    void union(int id1, int id2){
        Node n1 = nodes.get(id1);
        Node n2 = nodes.get(id2);
        n1.children.add(n2);
        n2.children.add(n1);

    }

    int height(Node root, int origin){
        if(root.children.size() == 0) return 1;

        long hash = root.id*10000 + origin*1000;
        if(hashes.get(hash) != null) return hashes.get(hash);
        int max = 0;
        for(Node n : root.children){
            if(n.id != origin){
                max = Math.max(max,height(n,root.id)+1);
            }
        }

        hashes.put(hash,max);
        return max;
    }
}
