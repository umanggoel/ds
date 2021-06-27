package com.company.string;

public class LongestPalindrome5 {

    public static void main(String[] args) {
        LongestPalindrome5 longestPalindrome5 = new LongestPalindrome5();
        longestPalindrome5.longestPalindrome("aaa");
        longestPalindrome5.countSubstrings("aaa");

    }

    public String longestPalindrome(String s) {

        if(s == null || s.length() == 1) return s;

        char arr[] = s.toCharArray();

        int len = s.length();
        int max = Integer.MIN_VALUE;
        String result = null;
        for(int pivot = 1;pivot < len-1;pivot++){
            int prev = pivot - 1;
            int next = pivot + 1;
            while(prev >= 0 && next <=len-1 && arr[prev] == arr[next]){
                if(next-prev+1 > max) {
                    result = s.substring(prev, next+1);
                    max = result.length();
                }
                prev = prev-1;
                next = next+1;
            }
        }

        for(int pivot = 0;pivot < len-1;pivot++){
            int prev = pivot;
            int next = pivot + 1;
            while(prev >= 0 && next <=len-1 && arr[prev] == arr[next]){
                if(next-prev+1 > max) {
                    result = s.substring(prev, next+1);
                    max = result.length();
                }
                prev = prev-1;
                next = next+1;
            }
        }

        for(int pivot = 1;pivot < len-1;pivot++){
            int prev = pivot-1;
            int next = pivot;
            while(prev >= 0 && next <=len-1 && arr[prev] == arr[next]){
                if(next-prev+1 > max) {
                    result = s.substring(prev, next+1);
                    max = result.length();
                }
                prev = prev-1;
                next = next+1;
            }
        }

        if(result == null) {
            return s.substring(0,1);
        }

        return result;
    }

    public int countSubstrings(String s) {
        if(s == null) return 0;
        if(s.length() == 1) return 1;

        char arr[] = s.toCharArray();

        int len = s.length();
        int result = 0;

        for(int pivot = 1;pivot < len-1;pivot++){
            int prev = pivot - 1;
            int next = pivot + 1;
            while(prev >= 0 && next <=len-1 && arr[prev] == arr[next]){
                result++;
                prev = prev-1;
                next = next+1;
            }
        }

        for(int pivot = 0;pivot < len-1;pivot++){
            int prev = pivot;
            int next = pivot + 1;
            while(prev >= 0 && next <=len-1 && arr[prev] == arr[next]){
                result++;
                prev = prev-1;
                next = next+1;
            }
        }

        return result+len;

    }
}
