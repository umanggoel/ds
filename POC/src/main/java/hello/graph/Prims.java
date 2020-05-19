package com.company.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prims {

    List<Node> graph = new ArrayList<>();
    Map<Integer, Node> nodes = new HashMap<>();


    class Edge{
        int weight;
        boolean included;
    }

    class Node{
        int id;
        boolean visited;
        Node(int id){
            this.id = id;
        }

        Map<Node,Edge> edges = new HashMap<>();

        Pair<Node,Edge> minWeightEdgeNotIncluded(){
            int minWeight = Integer.MAX_VALUE;
            Pair<Node,Edge> result = null;
            for(Map.Entry e:edges.entrySet()){
                Node n = (Node)e.getKey();
                Edge edge = (Edge)e.getValue();
                if(!n.visited && edge.weight < minWeight){
                    minWeight = edge.weight;
                    result = new Pair<Node,Edge>(n,edge);
                }
            }

            return result;
        }

    }

    //assumotion is that tehre is only one edge between two nodes.
    void addEdge(int id1, int id2,int weight){
        if(nodes.get(id1)==null && nodes.get(id2) == null){
        System.out.println("nodes not available");
        }

        Edge e = new Edge();
        e.weight = weight;

        Node n1 = nodes.get(id1);
        Node n2 = nodes.get(id2);
        n1.edges.put(n2,e);
        n2.edges.put(n1,e);
//        if(n1.edges.get(n2)!=null){
//            n1.edges.get(n2).add(e);
//        }else{
//            List<Edge> temp = new ArrayList<>();
//            temp.add(e);
//            n1.edges.put(n2,e);
//        }

//        if(n2.edges.get(n1)!=null){
//            n2.edges.get(n1).add(e);
//        }else{
//            List<Edge> temp = new ArrayList<>();
//            temp.add(e);
//            n2.edges.put(n1,temp);
//        }
    }

    void createNode(int id){
        if(nodes.get(id) != null){
            return;
        }
        Node n = new Node(id);
        nodes.put(id,n);
        graph.add(n);
    }

    int findMST(){
        if(graph.size() > 0){
            graph.get(0).visited = true;
        }

        int weight = 0;
        while(!isConnected()){
            Pair<Node,Edge> minPair = null;
            int minWeight = Integer.MAX_VALUE;
            List<Pair<Node,Edge>> candidates = new ArrayList<>();
            for(Node n:graph){
                if(n.visited){
                    Pair<Node,Edge> p = n.minWeightEdgeNotIncluded();
                    if(p != null && p.getValue().weight < minWeight){
                        minWeight = p.getValue().weight;
                        minPair = p;
                    }
                }
            }

            weight = weight+ minPair.getValue().weight;
            minPair.getKey().visited = true;
            minPair.getValue().included = true;
        }
        return weight;
    }


    boolean isConnected(){
        for(Node n: graph){
            if(!n.visited){
                return false;
            }
        }
        return true;
    }


}
