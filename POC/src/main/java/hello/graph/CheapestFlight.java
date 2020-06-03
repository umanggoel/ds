package com.company.graph;

import java.util.HashMap;
import java.util.Map;

public class CheapestFlight {

    public int findCheapestPrice(int N, int[][] flights, int src, int dst, int K) {
        for(int i=0;i<N;i++){
            createNode(i);
        }

        for(int i=0;i<flights.length;i++){
            createEdge(flights[i][0],flights[i][1],flights[i][2]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        return minCost(src,dst,K,0,0,map,src);
    }

    Map<Integer,Node> graph = new HashMap<>();

    class Edge{
        int weight;
    }

    class Node {
        int id;
        boolean visited;
        Map<Integer,Edge> children = new HashMap<>();

    }

    private void createNode(int id){
        if(graph.get(id) != null){
            return;
        }
        Node n = new Node();
        n.id =id;
        graph.put(id,n);
    }

    private void createEdge(int id1, int id2,int weight){
        if(graph.get(id1) == null || graph.get(id2) == null){
            return;
        }

        Node n1 = graph.get(id1);
        Node n2 = graph.get(id2);

        Edge e = new Edge();
        e.weight = weight;
        n1.children.put(id2,e);
    }

    int minCost(int src, int dst, int k, int currDepth, int currWeight, Map<Integer, Integer> map, int parent){

        Node n = graph.get(src);
        if(currDepth > k) return -1;

        n.visited = true;
        int min  = Integer.MAX_VALUE;
        for(Integer child:n.children.keySet()) {
            if(graph.get(child).visited) continue;
            if(child == dst){
                min = Math.min(min, n.children.get(child).weight);
            }else{
                int temp = minCost(child,dst,k,currDepth+1,n.children.get(child).weight,map,src);
                if(temp < 0) continue;
                min = Math.min(min,temp);
            }
        }

        n.visited = false;
        if(min  == Integer.MAX_VALUE){
            return -1;
        }
        return min+currWeight;

    }
}
