package com.company.Tree;

//https://www.geeksforgeeks.org/word-break-problem-trie-solution/
public class WordBreakProblem2 {

    TrieNode root = new TrieNode();
    class TrieNode{
        int r =26;
        TrieNode[] nodes = new TrieNode[r];
        boolean end;

        void put(char c){
            nodes[c-'a'] = new TrieNode();
        }

        TrieNode get(char c){
            return nodes[c-'a'];
        }

        boolean containsKey(char c){
            return nodes[c-'a'] != null;
        }

        void setEnd(){
            end = true;
        }
        boolean isEnd(){
            return end;
        }
    }

    void inserWord(String word){
        TrieNode node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    boolean search(String word){
        TrieNode node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    boolean wordBreak(String word){

        if(word.length() == 0) return true;
        for(int i=1;i<=word.length();i++){
            if(search(word.substring(0,i)) && wordBreak(word.substring(i))) {
                return true;
            }
        }

        return false;
    }
}
