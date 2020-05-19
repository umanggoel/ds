package com.company.Tree;

import java.util.List;

public class Trie {

    TrieNode root = new TrieNode();

    class TrieNode{
        int r = 26;
        boolean end;
        TrieNode nodes[];

        public TrieNode() {
            nodes = new TrieNode[r];
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd() {
            this.end = true;
        }

        public boolean containsKey(char c){
            return nodes[c-'a'] != null;
        }

        public void putChar(char c, TrieNode node){
            nodes[c-'a'] = node;
        }

        public TrieNode getChar(char c){
            return nodes[c-'a'];
        }
    }


    static Trie createTrie(){
        return new Trie();
    }

    void insert(String word){

        TrieNode node = root;
        for(int i=0;i < word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.putChar(c,new TrieNode());
            }
            node = node.getChar(c);
        }

        node.setEnd();
    }

    boolean search(String word){
        TrieNode node = root;
        for(int i=0;i < word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }
            node = node.getChar(c);
        }

        return node.isEnd();
    }

    boolean startsWith(String prefix){
        TrieNode node = root;
        for(int i=0;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }
            node = node.getChar(c);
        }

        return true;
    }

    private boolean findNode(TrieNode root, String prefix, int start){
        TrieNode node = root;
        for(int i=start;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(c == '.') {
                TrieNode nodes[] = node.nodes;
                for(TrieNode n:nodes){
                    if(n != null) if(findNode(n,prefix, i+1)) return true;
                }
                return false;
            } else if(!node.containsKey(c)){
                return false;
            }

            node = node.getChar(c);
        }

        return true;
    }

    //todo
    String longestPrefix(){
        return null;
    }

    //todo
    List<String> printAllWOrdsInTrie(){
        return null;
    }

}
