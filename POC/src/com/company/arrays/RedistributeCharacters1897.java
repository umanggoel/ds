package com.company.arrays;

import com.sun.deploy.util.StringUtils;

public class RedistributeCharacters1897 {

    public static void main(String[] args) {
        RedistributeCharacters1897 redistributeCharacters1897 = new RedistributeCharacters1897();

        String strs[] = {"ab","a"};
        redistributeCharacters1897.makeEqual(strs);
    }

    public boolean makeEqual(String[] word) {

        if(word.length ==1) return true;

        int c[] = new int[26];
        for(int i =0;i<word.length;i++) {
            for(int j = 0;j< word[i].length();j++) {
                int index = word[i].charAt(j)-'a';
                c[index] = c[index]++;
            }
        }
        for(int i=0;i<26;i++) {
            System.out.println(i+" : "+ c[i]);
            // if(c[i]%2 != 0) return false;
        }

        return true;
    }
}