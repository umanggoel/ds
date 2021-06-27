package com.company.graph;

import java.util.*;

public class ArticulationPoint {

    Map<Integer,Node> graph = new HashMap<>();
    Set<Integer> articulationPoints = new HashSet<>();
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

    Set<Integer> getArticulationPoints(int root){
        deferedDfs(root,-1,0);
        return articulationPoints;
    }
    private void deferedDfs(int curr, int parent, int time){
        time++;
        Node currNode = graph.get(curr);
        currNode.visited = true;
        currNode.visitTime = time;
        currNode.lowTime = time;

        for(Node neighbor : currNode.children){
            if(neighbor.id == parent) continue;
            if(!neighbor.visited){
                deferedDfs(neighbor.id,currNode.id,time);
                currNode.lowTime = Math.min(neighbor.lowTime,currNode.lowTime);
                if(neighbor.lowTime >= currNode.visitTime){
                    articulationPoints.add(currNode.id);
                }
            }else{
                currNode.lowTime = Math.min(currNode.lowTime,neighbor.visitTime);
            }
        }
    }


}
