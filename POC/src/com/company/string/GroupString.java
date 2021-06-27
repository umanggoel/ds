package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class GroupString {
    public  int numSimilarGroups(String[] A) {
        int count = 0;
        for(int i =0;i< A.length;i++){
            makeSet(A[i]);
        }

        for(int x = 0;x< A.length;x++){
            char outer[] = A[x].toCharArray();
            for(int i = x+1;i< A.length;i++){
                int diff = 0;
                char inner[] = A[i].toCharArray();
                for(int j =0;j< inner.length;j++){
                    if(inner[j] != outer[j]) diff++;
                    if(diff > 2) break;
                }

                if(diff == 2 || diff == 0){
                    union(A[x],A[i]);
                }
            }
        }

        for(String s: map.keySet()){
            if(map.get(s).parent.id == s) count++;
        }

        return count;
    }

    Map<String, Node> map= new HashMap<>();
    //findset, union, makeset, path-compression

    class Node{
        String id;
        Node parent;
        int rank;
    }

    void makeSet(String id){
        if(map.get(id) != null) return;
        Node node = new Node();
        node.parent = node;
        node.id = id;
        node.rank =0;
        map.put(id, node);
    }

    Node findSet(String id){
        Node n = map.get(id);
        if(n == null){
            System.out.print("no node found");
            return null;
        } else {
            Node result = findSet(n);
            if(n.parent != result){
                n.parent = result;
            }
            return result;
        }
    }

    private Node findSet(Node n){
        if(n.parent == n){
            return n;
        }else{
            return findSet(n.parent);
        }
    }


    void union(String val1, String val2){
        Node n1 = map.get(val1);
        Node n2 = map.get(val2);

        Node parent1 = findSet(n1);
        Node parent2 = findSet(n2);

        if(parent1 == parent2) return;

        if(parent1.rank < parent2.rank){
            parent1.parent = parent2;
            parent2.rank = parent2.rank+1;
            parent1.rank = 0;
        } else {
            parent2.parent = parent1;
            parent1.rank = parent1.rank+1;
            parent2.rank = 0;
        }
    }

    boolean connected(String val1 , String val2){
        if(findSet(val1) == findSet(val2)){
            return true;
        }
        return false;
    }

    Node getNode(int val){
        return map.get(val);
    }
}

//{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"}