package com.company.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {

        Set<String> words = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        if(words.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        int depth = 0;
        while(!q.isEmpty()){

            for(int x= q.size();x>0;x--) {
                String curr = q.poll();
                if(curr.equals(target)){
                    return depth;
                }
                for(int i=0;i<4;i++){

                    //increment character by 1
                    char currArr[] = curr.toCharArray();
                    currArr[i] = (char) (currArr[i]+1) > '9'? '0': (char) (currArr[i]+1);
                    String str = String.valueOf(currArr);

                    updateQueue(words, visited, q, curr, str);

                    //decrement character by 1 for reverse turn
                    currArr = curr.toCharArray();
                    currArr[i] =(char) (currArr[i]-1) < '0'? '9': (char) (currArr[i]-1);
                    str = String.valueOf(currArr);

                    updateQueue(words, visited, q, curr, str);

                }
            }
            depth = depth+1;
        }

        return -1;
    }

    private void updateQueue(Set<String> words, Set<String> visited, Queue<String> q, String curr, String str) {
        if (visited.contains(str) || words.contains(str) || str.equals(curr)) return;
        visited.add(str);
        q.offer(str);
    }

}
