package com.company.comoanyasked;

import java.util.*;

public class EvaluateDivison {

    public static void main(String[] args) {

        EvaluateDivison evaluateDivison = new EvaluateDivison();
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("a","b"));
        input.add(Arrays.asList("b","c"));

        double values[] = {2.0,3.0};

        List<List<String>> q = new ArrayList<>();
        q.add(Arrays.asList("a","c"));
        q.add(Arrays.asList("b","a"));


        evaluateDivison.calcEquation(input, values,q);
    }


    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {

        int len = values.length;
        double result[] = new double[queries.size()];
        DisjointSet ds = new DisjointSet();
        for(int i = 0;i< len;i++) {
            List<String> lst = eq.get(i);
            ds.makeSet(lst.get(0));
            ds.makeSet(lst.get(1));
            ds.union(lst.get(0),lst.get(1), values[i]);
        }

        int j = 0;
        for(List<String> lst : queries) {
            result[j] = ds.calculate(lst.get(0), lst.get(1));
            j++;
        }

        return result;

    }


    class Node {
        String id;
        Node parent;
        double value;
    }


    class DisjointSet {
        Map<String , Node> nodes = new HashMap<>();

        Node makeSet(String id) {
            if(nodes.get(id) != null) return nodes.get(id);
            Node n = new Node();
            n.id = id;
            n.parent = n;
            nodes.put(id,n);

            return n;
        }

        Node findParent(String id) {
            Node n = nodes.get(id);
            if(n == null) return null;
            if(n == n.parent) return n;
            return findParent(n.parent.id);

        }

        boolean union(String id1, String id2, double value) {
            if(nodes.get(id1) == null || nodes.get(id2) == null) return false;
            Node p1 = nodes.get(id1);
            Node p2 = nodes.get(id2);
            p2.parent = p1;
            p2.value = value;
            return true;
        }

        boolean isConnected(String id1, String id2) {
            if(nodes.get(id1) == null || nodes.get(id2) == null) return false;
            Node p1 = findParent(id1);
            Node p2 = findParent(id2);
            if(p1 == p2) return true;
            return false;
        }


        double calculate(String id1, String id2) {
            if(nodes.get(id1) == null || nodes.get(id2) == null) return -1.0;
            Node p2 = nodes.get(id2);

            double result = 1.0;
            while( p2.parent != p2 && !p2.id.equals(id1)) {
                result = result * p2.value;
            }

            if(p2.id.equals(id1)) return result;

            return -1.0;
        }


    }
}