package com.company.string;

public class ShortestPalindrome {

    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        shortestPalindrome.shortestPalindrome("abcd");
    }

    public String shortestPalindrome(String s) {

        char a[] = s.toCharArray();
        int len = s.length();
        int i = 0;
        int j = len-1;

        while(j >=0) {
            boolean b = true;
            int k=0;
            for( ;k<=j/2;k++){
                if(a[k] != a[j-k]){
                    b = false;
                    break;
                }
            }

            if(k-1 == j/2 && b) {
                break;
            }

            j--;

        }

        if(j == len-1) {
            return s;
        }
        String prefix = s.substring(j+1);
        StringBuilder output = new StringBuilder(prefix).reverse();

        return output.toString()+s;

    }
}
