package com.company.arrays;

import java.util.HashSet;
import java.util.Set;

public class SplitStrings1593 {

    public static void main(String[] args) {
            SplitStrings1593 splitStrings1593 = new SplitStrings1593();
            splitStrings1593.maxUniqueSplit("wwwzfvedwfvhsww");
    }

    public int maxUniqueSplit(String s) {

        Set<String> set = new HashSet<>();

        int count = 1;
        int i = 0;
        int start = 0;
        for (; i < s.length() && i + count <= s.length(); i++) {
            String curr = s.substring(start, start + count);
            if (set.contains(curr)) {
                count++;
            } else {
                set.add(curr);
                count = 1;
                start = i+1;
            }
        }

        String curr = s.substring(start);
        if (curr.length() > 1 && !set.contains(curr)) {
            set.add(curr);
        }

        return set.size();
    }
}
