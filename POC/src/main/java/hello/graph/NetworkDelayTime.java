package com.company.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {

        for(int i=1;i<=N;i++){
            createNode(i);
        }

        for(int i=0;i<times.length;i++){
            createEdge(times[i][0],times[i][1],times[i][2]);
        }

        Map<Integer,Integer> shortestpaths = findShortestPath(K);

        int max = Integer.MIN_VALUE;

        if(shortestpaths.values().size() != N) return -1;

        for(Integer value:shortestpaths.values()){
            max = Math.max(max,value);
        }

        return max;
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

    private Map<Integer,Integer> findShortestPath(int start){
        Map<Integer,Integer> min = new HashMap<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(Integer n:graph.keySet()){
            min.put(n,Integer.MAX_VALUE);
        }

        min.put(start,0);
        for(Integer n: graph.get(start).children.keySet()){
            min.put(n,graph.get(start).children.get(n).weight);
        }

        while(min.keySet().size()>0){

            Set<Map.Entry<Integer,Integer>> set = min.entrySet();
            int id = extractMin(set);
            if(id == 0) break;
            Node n = graph.get(id);
            n.visited= true;
            int curr = min.get(id);
            map.put(id,curr);
            min.remove(id);

            for(Integer child:n.children.keySet()) {
                if(!graph.get(child).visited && n.children.get(child).weight+curr < min.get(child)){
                    min.put(child,n.children.get(child).weight+curr);
                }
            }
        }


        return map;
    }

    private int extractMin(Set<Map.Entry<Integer,Integer>> set){
        int minId = 0;
        int minValue = Integer.MAX_VALUE;

        for(Map.Entry i: set){
            if((Integer)i.getValue()<minValue){
                minId = (Integer) i.getKey();
                minValue = (Integer)i.getValue();
            }
        }

        return minId;
    }
}
