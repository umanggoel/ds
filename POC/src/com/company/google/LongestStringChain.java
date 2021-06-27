package com.company.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestStringChain {

    public static void main(String[] args) {
        LongestStringChain longestStringChain = new LongestStringChain();
        //longestStringChain.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"});

        longestStringChain.longestStrChain(new String[]{"sgtnz","sgtz","sgz","ikrcyoglz","ajelpkpx","ajelpkpxm","srqgtnz","srqgotnz","srgtnz","ijkrcyoglz"});
    }
    public int longestStrChain(String[] wordList) {

        Set<String> words = new HashSet<>(Arrays.asList(wordList));
        Arrays.sort(wordList);
        Queue<String> q = new LinkedList<>();

        int minLen = wordList[0].length();
        for(int i=0;i< wordList.length;i++){
            minLen = Math.min(minLen, wordList[i].length());
        }

        for(int i=0;i< wordList.length;i++){
            if(wordList[i].length() == minLen) q.offer(wordList[i]);
        }

        int max = Integer.MIN_VALUE;
        int currLen = 0;
        while(!q.isEmpty()){

            for(int x= q.size();x>0;x--){
                String curr = q.poll();
                words.remove(curr);
                currLen = curr.length();
                for(int i=0;i<=curr.length();i++){
                    //insert lower case letter at all possible positions and check if they are in given list
                    for(char c='a';c<='z';c++){
                        String str = curr.substring(0,i)+ c + curr.substring(i);
                        if(words.contains(str)){
                            q.offer(str);
                            words.remove(str);
                        }
                    }
                }
            }

            if(q.isEmpty() && !words.isEmpty()){
                max = Math.max(max,currLen-minLen+1);
                minLen = getMinLen(words, q, currLen);
            }
        }

        max = Math.max(max,currLen-minLen+1);

        return max;
    }

    private int getMinLen(Set<String> wordList, Queue<String> q, int currLen) {
        int minLen;
        minLen = Integer.MAX_VALUE;
        for(String s:wordList){
             minLen = Math.min(minLen,s.length());
        }

        for(String s:wordList){
            if(s.length() == minLen) q.offer(s);
        }
        return minLen;
    }

}

