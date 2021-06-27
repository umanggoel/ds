package com.company.comoanyasked;

import javafx.util.Pair;

import java.util.*;

public class MyntraTech {

    public static void main(String[] args) {
        MyntraTech myntraTech = new MyntraTech();

       // int flights[][] = {{0,1,100},{1,2,100},{0,2,500}};
        int flights[][] = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
        myntraTech.findCheapestPrice(5, flights,2,1, 1);
    }
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            Map<Pair<Integer, Integer>, Integer> map = new HashMap();
            Map<Integer, List<Integer>> edges = new HashMap();
            for(int i =0;i < flights.length;i++) {
                map.put(new Pair(flights[i][0],flights[i][1]),flights[i][2]);
                List<Integer> list = edges.get(flights[i][0]);
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(flights[i][1]);
                edges.put(flights[i][0], list);
            }

            int min = Integer.MAX_VALUE;
            Queue<Pair<Integer, Integer>> q = new LinkedList();
            q.offer(new Pair(src, 0));

            while(!q.isEmpty() && k>= 0) {
                int len = q.size();
                for(int i = 0;i< len;i++) {
                    Pair curr = q.poll();
                    Integer  cost = (Integer)curr.getValue();
                    if(curr.getKey() != null) {
                        for (Integer j : edges.get(curr.getKey())) {
                            int edgeCost = map.get(new Pair(curr.getKey(), j));
                            if (j == dst) {
                                min = Math.min(min, edgeCost + cost);
                            } else {
                                q.offer(new Pair(j, edgeCost + cost));
                            }
                        }
                    }
                }
                k--;
            }
            if(min  == Integer.MAX_VALUE) return -1;
            return min;
        }


//    int min= Integer.MAX_VALUE;
//    Map<Integer, Node> graph = new HashMap();
//    //n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
//    int getMinCost(int [][] paths, int src, int dest, int stops, int n) {
//        //create nodes;
//        for(int i=0;i< n;i++) {
//            makeNode(i);
//        }
//        //each path add the edges
//        for(int i=0;i< paths.length;i++) {
//            addEdge(paths[i][0], paths[i][1],paths[i][2]);
//        }
//        getCost(src, dest,0, stops);
//        return min;
//    }
//
//
//    int getCost(int src, int dest, int curr, int maxStops) {
//        if(curr > maxStops) return -1;
//        if(src == dest) return 0;
//
//        PriorityQueue<Edge> pq = new PriorityQueue<>();
//        for(Integer i: graph.get(src).edges.keySet()) {
//            Edge e = new Edge();
//            e.dest = i;
//            e.cost = graph.get(src).edges.get(i);
//            pq.offer(e);
//        }
//        int result = -1;
//        while(!pq.isEmpty()) {
//            Edge e = pq.poll();
//            int cost = e.cost + getCost(e.dest, dest, curr++, maxStops);
//            if(cost != -1) {
//                min= Math.min(cost, min);
//                result = Math.min(cost, result);
//            }
//        }
//
//        return result;
//
//    }
//
//
//    void makeNode(int id) {
//        if(graph.get(id) == null) {
//            Node n = new Node();
//            n.id = id;
//            graph.put(id, n);
//        }
//    }
//
//    void addEdge(int i , int j , int cost) {
//        graph.get(i).edges.put(j, cost);
//    }
//
//    class Node {
//        int id;
//        Map<Integer, Integer> edges = new HashMap<>();
//    }
//
//    class Edge {
//        int dest;
//        int cost;
//    }
}

