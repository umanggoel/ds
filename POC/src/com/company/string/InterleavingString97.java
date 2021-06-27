package com.company.string;

public class InterleavingString97 {

    public static void main(String[] args) {
        InterleavingString97 interleavingString97 = new InterleavingString97();
        interleavingString97.isInterleave("aabcc","dbbca","aadbbcbcac");
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length() + s2.length() + s3.length() == 0) return true;
        char s1arr[] = s1.toCharArray();
        char s2arr[] = s2.toCharArray();
        char s3arr[] = s3.toCharArray();

        int i = 0;
        int j = 0;
        int k = 0;
        while(i< s1.length() && j<s2.length()) {
            if(s3arr[k] == s1arr[i] && s3arr[k] == s2arr[j]) {
                return isInterleave(s1.substring(i + 1), s2.substring(j), s3.substring(k + 1)) || isInterleave(s1.substring(i), s2.substring(j + 1), s3.substring(k + 1));
            }
            else if(s3arr[k] == s1arr[i]) {
                i++;
            }else if(s3arr[k] == s2arr[j]){
                j++;
            }else{
                return false;
            }
            k++;
        }

        while(i< s1.length()) {
            if(s3arr[k] == s1arr[i]) {
                i++;
            }else{
                return false;
            }
            k++;
        }

        while(j<s2.length()) {
            if(s3arr[k] == s2arr[j]){
                j++;
            }else{
                return false;
            }
            k++;
        }

        return true;
    }
}