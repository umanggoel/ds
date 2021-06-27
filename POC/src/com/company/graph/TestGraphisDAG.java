package com.company.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

public class TestGraphisDAG {

    public static void main(String[] args) {
        TestGraphisDAG testGraphisDAG = new TestGraphisDAG();
        Map<Integer, List<Integer>> input = new HashMap<>();
        input.put(5, asList(2,3,1));
        input.put(3, asList(4,6));
        input.put(6, asList(1,2,3));
        Set<Integer> visited = new HashSet<>();

        for(Integer i: input.keySet()){
            Set<Integer> recusionStack = new HashSet<>();
            if(!visited.contains(i) && testGraphisDAG.hasCycle(input, i,visited,recusionStack)){
                    System.out.print("Given graph has cycle");
                    return;
            }
        }

        System.out.print("Given graph has no cycle");


    }

    boolean hasCycle(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, Set<Integer> recursionStack) {

        if(recursionStack.contains(node)) return true;
        if(visited.contains(node)) return false;

        visited.add(node);
        recursionStack.add(node);

        if(graph.get(node) != null) {
            for(Integer i: graph.get(node)) {
                if(hasCycle(graph, i, visited, recursionStack)) return true;
            }
        }

        return false;
    }
}
