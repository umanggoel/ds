package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSorting {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> input = new HashMap<>();
        input.put(5, Arrays.asList(3));
        input.put(3,Arrays.asList(6));
        input.put(6,Arrays.asList(5));
        List<Integer> result = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        for(int i : input.keySet()) {
            topologicalSort(input,i, result, visited);
        }

        System.out.print(result);
    }

    public static void topologicalSort(Map<Integer, List<Integer>> schedule, int node, List<Integer> result, List<Integer> visited) {

        Integer curr = node;
        if(!visited.contains(curr)) {
            visited.add(curr);
            if(schedule.get(curr) != null && schedule.get(curr).size() > 0 ) {
               for(Integer i: schedule.get(curr)) {
                   topologicalSort(schedule, i, result, visited);
               }
            }
            result.add(node);
        }
    }
}
