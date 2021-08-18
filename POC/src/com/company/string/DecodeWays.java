package com.company.string;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        decodeWays.numDecodings("226");

    }
    public int numDecodings(String s) {
        return foo(s, 0);
    }

    int foo(String s, int start) {
        if(s == null) return 0;
        if(start >= s.length()-1) return 1;
        if(s.charAt(start) == '0') return 0;
        int t = foo(s, start+1) ;

        if(Integer.parseInt(s.substring(start, start+2)) <= 26)
            t += foo(s, start+2);

        return t;
    }
}
