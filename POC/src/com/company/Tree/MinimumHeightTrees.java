package com.company.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumHeightTrees {

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        int a[][] =  {{1,0},{1,2},{1,3}};
        minimumHeightTrees.findMinHeightTrees(4, a);
    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int i=0;i<n;i++) {
            tree.put(i, new ArrayList<>());
        }

        for(int i = 0;i< edges.length;i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }

        Map<Integer, Integer> depths = new HashMap();
        for(int i = 0;i<n;i++) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int depth = 0;
            while(!q.isEmpty()){
                depth++;
                int c = q.size();
                for(int j=0;j<c;j++) {
                    int id = q.poll();
                    visited.add(id);
                    for(Integer k: tree.get(id)) {
                        if(!visited.contains(k)) q.add(k);
                    }
                }
            }
            depths.put(i, depth);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i< n;i++) {
            if(depths.get(i) < min) min = depths.get(i);
        }

        List<Integer> result = new ArrayList();
        for(int i=0;i< n;i++) {
            if(depths.get(i) == min)result.add(i);
        }
        return result;
    }
}
