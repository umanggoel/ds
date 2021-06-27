package com.company.Tree;


import java.util.*;

//https://leetcode.com/problems/word-search-ii/
public class WordBoggle {

    TrieNode root = new TrieNode();

    class TrieNode{

        int r = 26;
        TrieNode[] nodes = new TrieNode[r];
        boolean end;

        boolean containsKey(char c){
            return nodes[c-'a'] != null;
        }

        void put(char c){
            nodes[c-'a'] = new TrieNode();
        }

        TrieNode get(char c){
            return nodes[c-'a'];
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd() {
            this.end = true;
        }
    }

    private void insertWord(String word){
        TrieNode node = root;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c);
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    private void searchWord(TrieNode root, char[][] boggle, int i, int j,String str, Set<String> result, int[][] visited){

        if(!isSafeToVisit(boggle,i,j,visited)) return;
        char curr = boggle[i][j];
        visited[i][j] = 1;
        TrieNode node = root.get(curr);
        if(node == null) return;
        if(node.isEnd()){
            result.add(str+curr);
            return;
        }
        if(isSafeToVisit(boggle,i+1,j,visited))  searchWord(node,boggle,i+1,j,str+curr,result,visited);
        if(isSafeToVisit(boggle,i-1,j,visited))  searchWord(node,boggle,i-1,j,str+curr,result,visited);
        if(isSafeToVisit(boggle,i,j+1,visited))  searchWord(node,boggle,i,j+1,str+curr,result,visited);
        if(isSafeToVisit(boggle,i,j-1,visited))  searchWord(node,boggle,i,j-1,str+curr,result,visited);
        visited[i][j] = 0;

    }

    private boolean isSafeToVisit(char[][] boggle, int i, int j,int[][] visited){
        int rows = boggle.length;
        int cols = boggle[0].length;
        if(i < 0 || i >= rows ) return false;
        if(j < 0 || j >= cols ) return false;
        if(visited[i][j] != 0) return false;
        return true;
    }

    void wordBoggle(String [] dictionary, char[][] boggle){

        WordBoggle w = new WordBoggle();
        for (String s:dictionary){
            w.insertWord(s);
        }

        Set<String> result = new HashSet<>();
        int rows = boggle.length;
        int cols = boggle[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(w.root.containsKey(boggle[i][j])){
                    String str = "";
                    int visited[][] = new int[rows][cols];
                    searchWord(w.root,boggle,i,j,str,result,visited);
                }
            }
        }

        if(result.size() == 0){
            System.out.println("No word in dictionary is present in boggle");
        } else{
            System.out.println(result);
        }
    }



}
