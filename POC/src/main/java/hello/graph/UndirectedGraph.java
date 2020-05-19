package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph {

    Map<Integer, Node> nodes = new HashMap();
    Map<Integer, Boolean> visited = new HashMap<>();
    class Node{
        int id;
        Node(int id){
            this.id =id;
        }
        List<Node> children = new ArrayList<>();
    }

    void createNode(int id){
        nodes.put(id,new Node(id));
    }

    void addChild(int parent, int child){
        if(nodes.get(parent) == null || nodes.get(child) == null){
            System.out.println("node does not exist");
            return;
        }

        nodes.get(parent).children.add(nodes.get(child));
    }

//    boolean hasCycle(int val){
//
//    }

    private  boolean hasCycle(Node root, int origin) {
        if(root == null ||  root.children.size() == 0) return false;
        if(visited.get(root.id)) return true;
        visited.put(root.id, true);

        boolean result = true;
        for(Node n:root.children){
               if(n.id != origin) {
                   result = result && hasCycle(n, root.id);
               }
        }
        return result;
    }
}
