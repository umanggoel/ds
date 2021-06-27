package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule4 {


    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> s = new ArrayList<>(queries.length);

        if(prerequisites.length == 0) {
            for(int i= 0;i<queries.length;i++){
                s.add(false);
            }
            return s;
        }

        for(int i=0;i<n;i++){
            createNode(i);
        }

        for(int i=0;i<prerequisites.length;i++){
            addChild(prerequisites[i][1],prerequisites[i][0]);
        }

        for(int i=0;i<n;i++){
            System.out.print(i+"->");
            for(Node node : nodes.get(i).children){
                System.out.print(node.id+",");
            }
            System.out.println("");
        }

        for(int i=0;i<queries.length;i++){
            s.add(dfs(queries[i][1],queries[i][0]));
        }

        return s;

    }

    private  boolean dfs(int id, int child) {
        Node root = nodes.get(id);
        if(root == null ||  root.children.size() == 0) {
            return false;
        }

        boolean result = true;
        for(Node n:root.children){
            if(n.id == child){
                result = true;
            }else{
                result = result && dfs(n.id,child);
            }

        }

        return result;
    }


    Map<Integer, Node> nodes = new HashMap();

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



}
