package com.company.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWIndow76 {

    public static void main(String[] args) {
        MinimumWIndow76 minimumWIndow76 = new MinimumWIndow76();
        minimumWIndow76.minWindow("ADOBECODEBANC", "ABC");
    }

//    public String minWindow(String s, String t) {
//
//        List<String> list = new ArrayList<>();
//
//        for(int i= 0 ;i< s.length();i++) {
//            for(int j=i+1;j<=s.length();j++) {
//                list.add(s.substring(i,j));
//            }
//        }
//
//        Map<Character, Integer> tc = new HashMap<>();
//        char ta[] = t.toCharArray();
//        for(int i =0;i<t.length();i++) {
//            tc.put(ta[i], tc.getOrDefault(ta[i],0)+1);
//        }
//
//        String result = "";
//        int min = Integer.MAX_VALUE;
//        for(String temp: list){
//            if(validate(temp, tc) && temp.length() < min){
//                min = temp.length();
//                result = temp;
//            }
//        }
//
//        return result;
//    }

    public String minWindow(String s, String t) {

        List<String> list = new ArrayList();
        Map<Character, Integer> st = new HashMap();
        char sa[] = s.toCharArray();
        String result = "";
        int min = Integer.MAX_VALUE;

        for(int i= 0 ;i< s.length();i++) {

            Map<Character, Integer> tc = new HashMap();
            char ta[] = t.toCharArray();
            for(int k =0;k<t.length();k++) {
                tc.put(ta[k], tc.getOrDefault(ta[k],0)+1);
            }

            int count = t.length();
            int j = i;
            for(;j< s.length();j++) {
                if(tc.get(sa[j]) != null && tc.get(sa[j]) > 0 ){
                    tc.put(sa[j], tc.get(sa[j])-1);
                    count--;
                }

                if(count == 0){
                    if(j-i < min) {
                        min = j-i;
                        result = s.substring(i,j+1);
                    }
                    break;
                }
            }
        }

        return result;
    }

    private boolean validate(String s, Map<Character, Integer> tc) {

        Map<Character, Integer> st = new HashMap();
        char sa[] = s.toCharArray();
        for(int i =0;i<s.length();i++) {
            st.put(sa[i], st.getOrDefault(sa[i],0)+1);
        }

        for(Character c: tc.keySet()) {
            if(st.get(c) == null || st.get(c) < tc.get(c)) return false;
        }

        return true;

    }
}
