package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Bipartite {

    public boolean isBipartite(int[][] graph) {

        for(int i=0;i<graph.length;i++){
            createNode(i,graph[i]);
        }

        boolean isBipartite = true;

        for(int i=0;i<graph.length;i++){
            Node n = nodes.get(i);
            if(n.neighbours.size() != 0 && !n.visited){
                isBipartite = isBipartite & isComponentBipartite(i);
            }
        }

        return isBipartite;
    }

    private boolean isComponentBipartite(int start){
        Queue<Integer> q  = new LinkedList<>();

        q.add(start);
        Stack<Integer> next = new Stack();

        int currentColor = 1;
        while(!q.isEmpty() ||  next.size() > 0){

            if(q.isEmpty()){
                while(!next.isEmpty()){
                    q.add(next.pop());
                }
                currentColor = currentColor*-1;
            }

            Node n = nodes.get(q.poll());
            n.visited = true;

            if(n.color == 0){
                n.color = currentColor;
                for(Integer i : n.neighbours){
                    next.push(i);
                }
            } else if(n.color != currentColor){
                return false;
            }
        }
        return true;

    }

    Map<Integer, Node> nodes = new HashMap<>();

    void createNode(int id, int[] children){
        if(nodes.get(id) == null){
            Node n = new Node();
            n.id = id;
            for(Integer i : children){
                n.neighbours.add(i);
            }
            nodes.put(id,n);
        }
    }
    class Node{

        int id;
        List<Integer> neighbours = new ArrayList<>();
        int color = 0;
        boolean visited = false;
    }
}
