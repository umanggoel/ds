package com.company.comoanyasked;

public class RepeatedSubstring {
    public static void main(String[] args) {

        RepeatedSubstring repeatedSubstring = new RepeatedSubstring();
        repeatedSubstring.repeatedSubstringPattern("ababababab");
    }

    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();

        int count = 2;
        int mid = len/2;
        while(mid > 0) {
            String sub = s.substring(0, mid+1);

            String temp = "";
            for(int i = 0;i<count-1;i++) {
                temp = temp+sub;
            }
            if(temp.equals(s)) return true;
            count++;
            mid = len/count;

        }

        return false;
    }
}