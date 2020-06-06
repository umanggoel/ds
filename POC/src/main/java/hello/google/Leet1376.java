package com.company.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet1376 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        for(int i=0; i< n ;i++){
            makeNode(i,informTime[i]);
        }

        for(int i=0;i<n;i++){
            if(manager[i] == -1) continue;
            addChild(manager[i],i);
        }

        return informTime(headID);

    }

    int informTime(int head){
        if(graph.get(head).children.size() == 0) return 0;

        int max = Integer.MIN_VALUE;
        for(Integer child : graph.get(head).children){
            int curr = graph.get(head).time+informTime(child);
            max = Math.max(max, curr);
        }

        return max;
    }

    Map<Integer, Node> graph = new HashMap<>();
    class Node{
        int id;
        int time;
        List<Integer> children = new ArrayList<>();
    }

    void makeNode(int id, int time){
        Node n = new Node();
        n.id = id;
        n.time = time;
        graph.put(id,n);
    }

    void addChild(int parent, int child){
        Node n = graph.get(parent);
        n.children.add(child);
    }
}
