package com.company.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        wordLadder.ladderLength("lost","cost", Arrays.asList("cost","lost","most"));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        if(!words.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int depth = 1;
        while(!q.isEmpty()){

            for(int x= q.size();x>0;x--){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    return depth;
                }
                for(int i=0;i<curr.length();i++){
                    char currArr[] = curr.toCharArray();
                    for(char c='a';c<='z';c++){
                        currArr[i] = c;
                        String str = String.valueOf(currArr);
                        if(wordList.contains(str) && !str.equals(curr)){
                            q.offer(str);
                            words.remove(str);
                        }
                    }
                }
            }
            depth = depth+1;
        }

        return 0;
    }
}
