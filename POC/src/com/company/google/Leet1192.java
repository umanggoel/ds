package com.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Leet1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        for(int i=0 ;i<n;i++){
            createNode(i);
        }

        for(List<Integer> edge:connections){
            createEdge(edge.get(0),edge.get(1));
        }

        return getArticulationPoints(0);

    }

    Map<Integer,Node> graph = new HashMap<>();
    List<List<Integer>> articulationPoints = new ArrayList<>();

    class Node{
        int id;
        boolean visited;
        int visitTime;
        int lowTime;
        List<Node> children = new ArrayList<>();
    }

    void createNode(int id){
        if(graph.get(id)!= null){
            return;
        }

        Node n = new Node();
        n.id =id;
        graph.put(id,n);
    }

    void createEdge(int id1, int id2){
        if(graph.get(id1) == null || graph.get(id2) == null ){
            return;
        }

        Node n1 = graph.get(id1);
        Node n2 = graph.get(id2);

        n1.children.add(n2);
        n2.children.add(n1);
    }

    List<List<Integer>> getArticulationPoints(int root){
        deferedDfs(root,-1,0);
        return articulationPoints;
    }

    private void deferedDfs(int curr, int parent, int time){
        time++;

        Node currNode = graph.get(curr);
        if(currNode.visited)  return;

        currNode.visited = true;
        currNode.visitTime = time;
        currNode.lowTime = time;

        for(Node neighbor : currNode.children){
            if(neighbor.id == parent) continue;
            if(!neighbor.visited){
                deferedDfs(neighbor.id,currNode.id,time);
                currNode.lowTime = Math.min(neighbor.lowTime,currNode.lowTime);
                if(neighbor.lowTime > currNode.visitTime){
                    articulationPoints.add(asList(currNode.id, neighbor.id));
                }
            }else{
                currNode.lowTime = Math.min(currNode.lowTime,neighbor.visitTime);
            }
        }
    }
}
