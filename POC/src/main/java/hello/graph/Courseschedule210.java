package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Courseschedule210 {

    public static void main(String[] args) {
        Courseschedule210 courseschedule210c= new Courseschedule210();
        int[][]  a= {{0,1},{0,2},{1,2}};
        courseschedule210c.findOrder(3, a);
    }

    public int[] findOrder(int numCourses, int[][] p) {
        Map<Integer, List<Integer>> courses = new HashMap<>();
        for(int i=0;i< numCourses;i++) {
            courses.put(i, new ArrayList<>());
        }

        for(int i=0;i< p.length;i++) {
            courses.get(p[i][0]).add(p[i][1]);
        }

        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList();

        boolean temp = true;
        for(int i =0 ;i< numCourses;i++) {
            Set<Integer> stack = new HashSet();
            if(!visited.contains(i)) temp= temp && orderCourses(i, courses, visited, result,stack);
        }

        int fin[] = new int[0];
        if(temp) {
            fin = new int[numCourses];
            for(int i=0;i< result.size();i++) {
                fin[i] = result.get(i);
            }
        }

        return fin;
    }

    private boolean orderCourses(int id , Map<Integer, List<Integer>> courses, Set<Integer> visited, List<Integer> result, Set<Integer> stack) {

        if(stack.contains(id))   return false;
        if(visited.contains(id)) return true;

        visited.add(id);
        stack.add(id);

        boolean temp = true;
        for(Integer n: courses.get(id)) {
            temp = temp && orderCourses(n , courses, visited, result, stack);
        }

        stack.remove(id);
        result.add(id);
        return temp;
    }
}
