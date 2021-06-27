package com.company;

public class LeetCode10 {

    public static void main(String[] args) {

        LeetCode10 leetCode10 = new LeetCode10();

        leetCode10.isMatch("xaabyc","xa*b.c");
    }
    public boolean isMatch(String s, String p) {

        if(s == null || p == null) return false;

        int sLen = s.length();
        int pLen = p.length();
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        boolean dp[][] = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;

        for(int i = 1;i<=pLen;i++) {
            if(pChar[i-1] == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i = 1;i<=sLen;i++) {
            for(int j = 1;j<=pLen;j++) {
                if(sChar[i-1] == pChar[j-1] || pChar[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pChar[j-1] == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(sChar[i-1] == pChar[j-2] || pChar[j-2] == '.'){
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                }
            }
        }

        return dp[sLen][pLen];

    }
}
