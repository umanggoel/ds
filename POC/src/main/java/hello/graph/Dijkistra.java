package com.company.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dijkistra {

    Map<Integer,Node> graph = new HashMap<>();

    class Edge{
        int weight;
    }
    class Node {
        int id;
        boolean visited;
        Map<Integer,Edge> children = new HashMap<>();

    }

    void createNode(int id){
        if(graph.get(id) != null){
            return;
        }
        Node n = new Node();
        n.id =id;
        graph.put(id,n);
    }

    void createEdge(int id1, int id2,int weight){
        if(graph.get(id1) == null || graph.get(id2) == null){
            return;
        }

        Node n1 = graph.get(id1);
        Node n2 = graph.get(id2);

        Edge e = new Edge();
        e.weight = weight;
        n1.children.put(id2,e);
        n2.children.put(id1,e);
    }

    int findShortestPath(int start, int end){
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


        return map.get(end);
    }

    int extractMin(Set<Map.Entry<Integer,Integer>> set){
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
