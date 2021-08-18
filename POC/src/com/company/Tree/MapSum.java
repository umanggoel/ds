package com.company.Tree;

import java.util.Map;

public class MapSum {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));

    }


    TrieThis t = new TrieThis();
    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        t.insert(key, val);
    }

    public int sum(String prefix) {
        return t.sumPrefix(prefix);
    }
}

class TrieThis {

    TrieNode root = new TrieNode();

    public void insert(String key, int value) {

        char[] arr = key.toCharArray();
        TrieNode node = root;
        for(int i=0;i< arr.length;i++) {
            if(node.nodes[arr[i] -'a'] == null){
                node.nodes[arr[i] -'a']= new TrieNode();
            }
            node = node.nodes[arr[i] -'a'];
        }

        node.value = value;

    }

    public int find(String key) {
        char[] arr = key.toCharArray();
        TrieNode node = root;
        for(int i=0;i< arr.length;i++) {
            if(node.nodes[arr[i] -'a'] == null){
                return -1;
            }
            node = node.nodes[arr[i] -'a'];
        }

        return node.value;
    }

    public int sumPrefix(String prefix){
        TrieNode node = root;
        for(int i= 0;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(node.nodes[c -'a'] == null){
                return -1;
            }
            node = node.nodes[c -'a'];
        }

        return sum(node);
    }

    private int sum(TrieNode start) {
        int sum  = start.value;
        for(TrieNode n: start.nodes){
            if(n != null) {
                sum = sum + sum(n);
            }
        }
        return sum;
    }

}

class TrieNode{
    TrieNode[] nodes= new TrieNode[26];
    int value;
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */