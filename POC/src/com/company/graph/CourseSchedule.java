package com.company.graph;

import java.util.*;

public class CourseSchedule {


//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//
//
//        int result [] = {};
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        Set<Integer> total = new HashSet<>();
//        List<Integer> r = new ArrayList<>();
//        Set<Integer> totallyVisited = new HashSet<>();
//        Set<Integer> currentlyVisted = new HashSet<>();
//
//        for(int i=0;i<numCourses;i++){
//            createNode(i);
//            total.add(i);
//        }
//
//        for(int i=0;i<prerequisites.length;i++){
//            addChild(prerequisites[i][0],prerequisites[i][1]);
//        }
//
//        for(int i= 0;i<numCourses;i++){
//            if(total.contains(i) && hasCycle(i,i,totallyVisited,currentlyVisted,total,r)) return result;
//        }
//
//        result = new int[numCourses];
//        int i=0;
//        for(Integer in : r){
//            result[i] = in;
//            i++;
//        }
//        return result;
//
//    }
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        Set<Integer> total = new HashSet<>();
//        List<Integer> r = new ArrayList<>();
//
//        for(int i=0;i<numCourses;i++){
//            createNode(i);
//            total.add(i);
//        }
//
//        for(int i=0;i<prerequisites.length;i++){
//                addChild(prerequisites[i][0],prerequisites[i][1]);
//        }
//
//        Set<Integer> totallyVisited = new HashSet<>();
//        Set<Integer> currentlyVisted = new HashSet<>();
//
//        for(int i= 0;i<numCourses;i++){
//            if(total.contains(i) && hasCycle(i,i,totallyVisited,currentlyVisted,total,r)) return false;
//        }
//
//        return true;
//
//    }
//
//    Map<Integer, Node> nodes = new HashMap();
//    Map<Integer, Boolean> visited = new HashMap<>();
//
//    class Node{
//        int id;
//        Node(int id){
//            this.id =id;
//        }
//        List<Node> children = new ArrayList<>();
//    }
//
//    void createNode(int id){
//        nodes.put(id,new Node(id));
//    }
//
//    void addChild(int parent, int child){
//        if(nodes.get(parent) == null || nodes.get(child) == null){
//            System.out.println("node does not exist");
//            return;
//        }
//
//        nodes.get(parent).children.add(nodes.get(child));
//    }
//
//
//    //{{0,1},{0,2},{1,2}}
//    //[[1,0],[2,1]]
//    //{0,1},{3,1},{1,3},{3,2}
//    private  boolean hasCycle(int id, int origin, Set<Integer> totallyVisited, Set<Integer> currentlyVisted, Set<Integer> total, List<Integer> result) {
//        Node root = nodes.get(id);
//        total.remove(id);
//        if(root == null ||  root.children.size() == 0) {
//            if(totallyVisited.add(id)) result.add(id);
//            currentlyVisted.remove(id);
//            return false;
//        }
//
//
//        if(totallyVisited.contains(id)) return false;
//        if(currentlyVisted.contains(id)) return true;
//
//        currentlyVisted.add(id);
//
//        for(Node n:root.children){
//            if(hasCycle(n.id, root.id,totallyVisited,currentlyVisted,total,result)) return true;
//        }
//        if(totallyVisited.add(id)) result.add(id);
//        currentlyVisted.remove(id);
//        return false;
//    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int n =3;
        int p[][] = {{0,1},{0,2},{1,2}};
        courseSchedule.canFinish(n, p);
    }

    public boolean canFinish(int n, int[][] p) {
        Map<Integer, List<Integer>> map = new HashMap();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList());
        }

        for (int i = 0; i < p.length; i++) {
            map.get(p[i][0]).add(p[i][1]);
        }


        Set<Integer> visited = new HashSet();
        for (Integer v : map.keySet()) {
            Set<Integer> stack = new HashSet();
            if (!visited.contains(v)) {
                if (hasCycle(map, v, visited, stack)) return false;
            }
        }
        return true;
    }

    boolean hasCycle(Map<Integer, List<Integer>> map, int start, Set<Integer> visited, Set<Integer> stack) {

        if (visited.contains(start)) return false;
        if (stack.contains(start)) return true;

        stack.add(start);

        for (Integer i : map.get(start)) {
            if (hasCycle(map, i, visited, stack)) return true;
        }

        visited.add(start);
        return false;
    }

}
