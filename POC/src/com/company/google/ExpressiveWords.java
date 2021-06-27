package com.company.google;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {


    public static void main(String[] args) {
        ExpressiveWords expressiveWords = new ExpressiveWords();

        expressiveWords.expressiveWords("aaa",new String[]{"aaaa"});
    }


    public int expressiveWords(String S, String[] words) {

        List<Character> sChar = new ArrayList<>();
        List<Integer> sCount = new ArrayList<>();

        int result = 0;

        char[] arr = S.toCharArray();
        int sum = 1;
        int i =1;
        for (i = 1; i < S.length(); i++) {
            if (arr[i] == arr[i - 1]) {
                sum++;
            } else {
                sChar.add(arr[i - 1]);
                sCount.add(sum);
                sum = 1;
            }
        }

        sChar.add(arr[i - 1]);
        sCount.add(sum);


        for (i = 0; i < words.length; i++) {
            List<Character> wChar = new ArrayList<>();
            List<Integer> wCount = new ArrayList<>();

            char[] warr = words[i].toCharArray();
            int wsum = 1;
            int j =1;
            for (j = 1; j < words[i].length(); j++) {
                if (warr[j] == warr[j - 1]) {
                    wsum++;
                } else {
                    wChar.add(warr[j - 1]);
                    wCount.add(wsum);
                    wsum = 1;
                }
            }

            wChar.add(warr[j - 1]);
            wCount.add(wsum);

            if (wChar.size() == sChar.size()) {
                boolean p = true;
                for (j = 0; j < wChar.size(); j++) {
                    if (wChar.get(j) != sChar.get(j) || wCount.get(j) > sCount.get(j)) {
                        p = false;
                        break;
                    }
                    if (wCount.get(j) == sCount.get(j)) continue;
                    if (wCount.get(j) < sCount.get(j) && sCount.get(j) < 3) {
                        p = false;
                    }
                }
                if (p) result++;
            }
        }
        return result;
    }

}
