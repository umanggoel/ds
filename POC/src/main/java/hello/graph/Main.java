package com.company.graph;

import com.company.arrays.StonesRemovalGame;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DisjointSets set = new DisjointSets();
        set.makeSet(1);
        set.makeSet(2);
        set.makeSet(3);
        set.makeSet(4);
        set.makeSet(5);
        set.makeSet(6);
        set.makeSet(7);

        set.union(1,2);
        set.union(2,3);
        set.union(4,5);
        set.union(6,7);
        set.union(5,6);
        set.union(3,7);
//
//        System.out.println(set.findSet(1).value);
//        System.out.println(set.findSet(2).value);
//        System.out.println(set.findSet(3).value);
//        System.out.println(set.findSet(4).value);

        Kruskal kruskal = new Kruskal();
        kruskal.createNodes(Arrays.asList(1,2,3,4,5,6));
        kruskal.createEdge(1,4,1);
        // kruskal.createEdge(1,2,3);
        // kruskal.createEdge(4,2,3);
        kruskal.createEdge(4,3,1);
        kruskal.createEdge(2,3,1);
        //  kruskal.createEdge(4,5,6);
        kruskal.createEdge(5,6,2);
        kruskal.createEdge(3,6,4);
        // kruskal.createEdge(3,5,5);


//        List<Edge> edges = kruskal.minSpanningTree();
//
//        int sum = 0;
//        for(Edge e : edges){
//            sum = sum+e.weight;
//        }
//
//
//        System.out.println("minimum sum:"+sum);
        // System.out.println(kruskal.checkCycle());

        Prims p = new Prims();
        p.createNode(1);
        p.createNode(2);
        p.createNode(3);
        p.createNode(4);
        p.createNode(5);

        p.addEdge(1,2,2);
        p.addEdge(2,3,2);
        p.addEdge(1,3,3);
        p.addEdge(2,5,5);
        p.addEdge(3,5,1);
        p.addEdge(3,4,1);

        // System.out.println(p.findMST());

        Dijkistra dijkistra = new Dijkistra();
        dijkistra.createNode(1);
        dijkistra.createNode(2);
        dijkistra.createNode(3);
        dijkistra.createNode(4);
        dijkistra.createNode(5);
        dijkistra.createNode(6);
        dijkistra.createEdge(1,2,2);
        dijkistra.createEdge(1,3,4);
        dijkistra.createEdge(2,4,7);
        dijkistra.createEdge(2,3,1);
        dijkistra.createEdge(3,5,3);
        dijkistra.createEdge(4,6,1);
        dijkistra.createEdge(4,5,2);
        dijkistra.createEdge(5,6,5);
        //  dijkistra.findShortestPath(1,6);

        ArticulationPoint articulationPoint = new ArticulationPoint();
        articulationPoint.createNode(1);
        articulationPoint.createNode(2);
        articulationPoint.createNode(3);
        articulationPoint.createNode(4);
        articulationPoint.createNode(5);
        articulationPoint.createNode(6);
        articulationPoint.createNode(7);

        articulationPoint.createEdge(1,2);
        articulationPoint.createEdge(1,3);
        articulationPoint.createEdge(2,3);
        articulationPoint.createEdge(2,4);
        articulationPoint.createEdge(3,4);
        articulationPoint.createEdge(4,5);
        articulationPoint.createEdge(4,6);
        articulationPoint.createEdge(5,7);
        articulationPoint.createEdge(6,7);

        //add this edge to test that it is strongly connected graph
       // articulationPoint.createEdge(2,5);

       // articulationPoint.getArticulationPoints(1).forEach(entry-> System.out.println(entry));
        int [][] edges = new int[][]{{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        RedundantConnection redundantConnection = new RedundantConnection();
       // redundantConnection.findRedundantConnection(edges);

        int [][] stones = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        StonesRemovalGame stonesRemovalGame = new StonesRemovalGame();
       // stonesRemovalGame.removeStones(stones);

        MinSwapCouples minSwapCouples =new MinSwapCouples();
        minSwapCouples.minSwapsCouples(new int[]{5,4,2,6,3,1,0,7});
    }
}
