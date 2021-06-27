package com.company.graph;

import java.util.HashMap;

public class SatisfiabilityEquations {

    public boolean equationsPossible(String[] eq) {

        if(eq.length < 1) return true;

        for(int i = 0;i<eq.length;i++){
            char[] arr = eq[i].toCharArray();
            createNode(arr[0]);
            createNode(arr[3]);
            if(arr[1] == '='){
                connect(arr[0],arr[3]);
            }
        }

        for(int i = 0;i<eq.length;i++){
            char[] arr = eq[i].toCharArray();
            if(arr[1] == '!' && areConnected(arr[0],arr[3])){
                return false;
            }
        }

        return true;
    }

    HashMap<Character,Node> nodes = new HashMap();

    class Node{
        char id;
        Node parent;
    }

    void createNode(char id){
        if(nodes.get(id) != null){
            return;
        }
        Node n = new Node();
        n.parent = n;
        n.id = id;
        nodes.put(id, n);
    }

    void connect(char id1,char id2){
        if(areConnected(id1,id2)){
            return;
        }

        Node n1 = findParent(id1);
        Node n2 = findParent(id2);

        n1.parent = n2;

    }

    Node findParent(char id){
        Node n = nodes.get(id);
        if(n == null) return null;

        if(n.parent == n){
            return n;
        }else{
            Node result = findParent(n.parent.id);
            if(n.parent != result) n.parent = result;
            return result;
        }
    }

    boolean areConnected(char id1, char id2){
        if(nodes.get(id1) == null || nodes.get(id2) == null){
            return false;
        }

        Node n1 = findParent(id1);
        Node n2 = findParent(id2);

        return n1.id == n2.id;
    }

}
