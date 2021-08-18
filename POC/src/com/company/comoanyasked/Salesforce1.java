package com.company.comoanyasked;

import java.util.HashMap;
import java.util.Map;

public class Salesforce1 {

    public static void main(String[] args) {
        maxLengthSubstring("abbcbda");
    }

    private static int maxLengthSubstring(String str) {

        if(str == null) return 0;

        int i = 0;
        int j = 0;
        int max = 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(0), 0);

        for(;i< str.length();) {

            for(j = i+1;j< str.length();j++) {
                if(map.get(str.charAt(j)) != null) {
                    max = Math.max(max, j-i);
                    i = map.get(str.charAt(j)) +1;
                    map = new HashMap<>();
                    map.put(str.charAt(i), i);
                    break;
                }else{
                    map.put(str.charAt(j), j);
                }
            }

            if(j == str.length()) {
                break;
            }
        }
        max = Math.max(max, j-i);
        return max;

    }
}