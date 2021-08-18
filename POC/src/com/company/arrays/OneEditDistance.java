package com.company.arrays;

public class OneEditDistance {

    public static void main(String[] args) {
        OneEditDistance oneEditDistance = new OneEditDistance();
        oneEditDistance.isOneEditDistance("ab","abc");
    }

    public boolean isOneEditDistance(String s, String t) {

        int len = s.length();
        int tlen = t.length();

        if (Math.abs(len - tlen) > 1) return false;

        char sarr[] = s.toCharArray();
        char tarr[] = t.toCharArray();

        int count = 0;
        if (len == tlen) {
            for (int i = 0; i < len; i++) {
                if (sarr[i] != tarr[i]) count++;
            }

        } else if (len > tlen) {
            int j = 0;
            int i = 0;

            while (i < len && j < tlen) {
                if (sarr[i] != tarr[j]) {
                    i++;
                    count++;
                } else {
                    i++;
                    j++;
                }
            }
        } else {
            int j = 0;
            int i = 0;

            while (i < len && j < tlen) {
                if (sarr[i] != tarr[j]) {
                    j++;
                    count++;
                } else {
                    i++;
                    j++;
                }
            }
        }

        if (count == 1) return true;
        return false;
    }
}

