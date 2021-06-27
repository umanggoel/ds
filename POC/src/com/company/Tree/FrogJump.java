package com.company.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrogJump {
    public double frogPosition(int n, int[][] edges, int t, int target) {

        for(int i=1;i<=n;i++){
            createNode(i);
        }

        for(int i=0;i<edges.length;i++){
            addChildren(edges[i][0],edges[i][1]);
        }

        return foo(nodes.get(1),target,t,0);
    }


    private double foo(Node node, int target, int t,int currTime){
        if(currTime > t){
            return 0.0;
        }

        if(node.id == target && currTime == t) return 1.0;

        double prob = 0;

        if(node.id == target && node.children.size() == 0 && currTime <=t){
            currTime++;
            prob = foo(node,target,t,currTime);
        }else{
            for(int i=0;i<node.children.size();i++){
                int childid = node.children.get(i);
                double currProb = foo(nodes.get(childid),target,t,currTime+1);
                if( currProb != 0){
                    prob = currProb*(1.0/node.children.size());
                }
            }
        }


        return prob;
    }

    Map<Integer,Node> nodes = new HashMap<>();
    private void createNode(int id){
        nodes.put(id, new Node(id, 0));
    }

    private  void addChildren(int parent,int child){
        if( parent < child){
            nodes.get(parent).children.add(child);
        }else{
            nodes.get(child).children.add(parent);

        }
    }

    class Node{
        int id;
        int depth;
        List<Integer> children = new ArrayList<>(0);
        Node(int id, int depth){
            this.id = id;
            this.depth = 0;
        }
    }

}
