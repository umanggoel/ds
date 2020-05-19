package com.company.graph;

import com.company.graph.DisjointSets;
import com.company.graph.DisjointSets.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    List<Edge> edges = new ArrayList<>();
    DisjointSets graphNodes= new DisjointSets();
    class Edge{
        Node node1;
        Node node2;
        int weight;
    }

    void createNodes(List<Integer> nodes){
        nodes.stream().forEach(entry-> graphNodes.makeSet(entry));
    }

    void createEdge(int val1,int val2, int weight){
        Edge e = new Edge();
        e.node1 = graphNodes.getNode(val1);
        e.node2 = graphNodes.getNode(val2);
        e.weight =weight;
        edges.add(e);
    }

    List<Edge> minSpanningTree(){
        List<Edge> result = new ArrayList<>();
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        for(Edge e : edges){
            if(!graphNodes.connected(e.node1.value,e.node2.value)){
                graphNodes.union(e.node1.value,e.node2.value);
                result.add(e);
            }
        }

        return result;
    }

    boolean checkCycle(){
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        for(Edge e : edges){
            if(!graphNodes.connected(e.node1.value,e.node2.value)){
                graphNodes.union(e.node1.value,e.node2.value);
            }else{
                return true;
            }
        }

        return false;
    }

}
