package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartioning {

    public static void main(String[] args) {
        PalindromicPartioning palindromicPartioning = new PalindromicPartioning();
        palindromicPartioning.partition("abba");
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = partition(s,0,1);
        System.out.println(list);
        return null;

    }

    List<List<String>> partition(String s, int start, int end) {
        String curr = s.substring(start, end);
        if (!isPalindrome(curr)) {
            return null;
        }
        List<List<String>> list = new ArrayList<>();

        if(end == s.length()) {
            List<String> temp = new ArrayList();
            temp.add(curr);
            list.add(temp);
            return list;
        }


        for (int i = end; i < s.length(); i++) {
            List<List<String>> l = partition(s, end, i + 1);
            if (l != null) {
                for (List<String> t : l) {
                    list.add(t);
                }
            }
        }

        if (list.size() > 0) {
            for (List<String> l : list) {
                l.add(curr);
            }
            return list;
        }

        return null;

    }

    boolean isPalindrome(String s) {

        char arr[] = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (arr[start] != arr[end]) return false;
            start++;
            end--;
        }

        return true;
    }
}

