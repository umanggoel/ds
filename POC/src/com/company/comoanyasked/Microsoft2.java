package com.company.comoanyasked;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Microsoft2 {


    public static void main(String[] args) {
            Microsoft2 microsoft2 = new Microsoft2();
            String start = "CAB";
            String end = "DOG";
            String dict[] = { "COB","DOZ"};
            if(microsoft2.isPathPossible(start, end, dict)){
                System.out.println("Path is possible");
            }else{
                System.out.println("Path is not possible");
            }
    }


    boolean isPathPossible(String start, String end, String[] dict) {

        if(start == null || end == null || start.length() != end.length()) return false;
        if(start.equals(end)) return true;
        if(dict.length == 0) return false;

        Queue<String> q = new LinkedList<>();
        Set<String> dictSet = new HashSet<>();

        for(String word: dict) {
            dictSet.add(word);
        }

        q.offer(start);

        while (!q.isEmpty()) {  // o(n)
            int size = q.size();
            for(int k = 0;k<size;k++) {
                String curr = q.poll();
                if(curr.equals(end)) return true;
                for(int i = 0;i< curr.length();i++) {  //  o(26m)
                    char arr[] = curr.toCharArray(); // [c, a, b]  i = 1;
                    for(char c ='A';c <= 'Z';c++) { // o(26)
                        arr[i] = c;
                        String newWord = String.valueOf(arr); // cab, cbb,COG,... zab
                        if(newWord.equals(end)) return true;
                        if(dictSet.contains(newWord)) {
                            q.offer(newWord);
                            dictSet.remove(newWord);
                        }
                    }
                }
            }
        }


        //o(26*(number of words in dict)*(length of word))

        return false;
    }
}

//   CAB   ->   COB, CAG, DAG ->   COG, COD, CAD, DAD -> DOG