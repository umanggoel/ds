package com.company.arrays;

public class PrefixOfWord {

    public int isPrefixOfWord(String sentence, String searchWord) {

        if(sentence.length() < searchWord.length()) return -1;

        String arr[] = sentence.split(" ");

        for(int i = 0;i<arr.length;i++){
            if(arr[i].length()<searchWord.length()){
                continue;
            }
            boolean found = true;
            for(int j= 0;j<searchWord.length();j++){
                if(arr[i].charAt(j) != searchWord.charAt(j)){
                    found = false;
                    break;
                }
            }
            if (found) return i+1;
        }

        return -1;

    }
}
