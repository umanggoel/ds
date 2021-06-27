package com.company.google;

import java.util.HashMap;
import java.util.Map;

public class GetHint {
    public String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;
        char sec[] = secret.toCharArray();
        char gue[] = guess.toCharArray();

        Map<Character,Integer> counts = new HashMap<>();
        for(int i=0;i<gue.length;i++){
            if(gue[i] == sec[i]) {
                gue[i] = '#';
                bulls++;
            }else{
                counts.put(sec[i],counts.getOrDefault(sec[i],0)+1);
            }
        }

        for(int i=0;i<gue.length;i++){
            if(gue[i] == '#') continue;
            if(counts.get(gue[i]) ==null) continue;
            if(counts.get(gue[i])>0){
                counts.put(gue[i],counts.get(gue[i])-1);
                cows++;
            }
        }
        return bulls+"A"+cows+"B";

    }
}
