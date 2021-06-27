package com.company.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class StringPatters {

    // https://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/
    public static List<String> generatePatterns(String st) {

        List<Integer> indices = new ArrayList<>();

        List<String> result = new ArrayList<>();
        result.add(st);
        char a[] = st.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == '?') {
                indices.add(i);
            }
        }

        for (int i = indices.size() - 1; i >= 0; i--) {
            List<String> temp = new ArrayList<>();
            int index = indices.get(i);
            for (int j = 0; j < result.size(); j++) {
                char a1[] = result.get(0).toCharArray();
                a1[index] = '0';
                temp.add(new String(a1));
                a1[index] = '1';
                temp.add(new String(a1));
            }
            result = temp;
        }

        return result;
    }

    //kmp array utils
    public static int[] kmpUtils(String pattern){

        int [] result = new int[pattern.length()];

        char[] a = pattern.toCharArray();

        int j=0,i=1;
        result[j]= 0;

        while(i<pattern.length()){
            if(a[i] == a[j]){
                result[i] = j+1;
                j++;
                i++;
            } else if(j>=1){
                j = result[j-1];
            } else{
                i++;
            }
        }
        return result;
    }

    // KMP
    public static boolean matchString(String text,String pattern) {
        int temp[] = kmpUtils(pattern);
        char[] a = pattern.toCharArray();
        char textA[] = text.toCharArray();
        int j= 0;
        for(int i=0;i<text.length();){
            if(textA[i] == a[j]){
                j++;
                i++;
            } else if(j>1){
                j=temp[j-1];
            } else{
                i++;
            }
        }

        if(j == pattern.length()){
            return true;
        }
        return false;
    }

    //https://www.geeksforgeeks.org/meta-strings-check-two-strings-can-become-swap-one-string/
    public boolean isMetaString(String str1, String str2) {
        if(str1.equals(str2) || str1.length() != str2.length()){
            return false;
        }

        int count = 0;

        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
            if(count > 2) return false;
        }

        return true;

    }


    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> result = new HashMap();

        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            List<String> temp = new ArrayList<>();
            sort(chars);
            String key = Arrays.toString(chars);
            if(result.containsKey(key)){
                temp = result.get(key);
            }
            temp.add(strs[i]);
            result.put(key, temp);

        }
        return result.values().stream().collect(Collectors.toList());
    }

    public static String freqAlphabets(String s) {
        String result = "";
        char[] temp = s.toCharArray();
        for(int i=0;i<temp.length;i++) {
            if((temp[i] == '1') && (i <= temp.length-3)){
                result= result +(char)(temp[i+1]+58);
                i=i+2;
            }else if((temp[i] == '2') && (i <= temp.length-3)){
                result= result +(char)(temp[i+1]+68);
                i=i+2;
            } else{
                result= result +(char)(temp[i]+48);
            }
        }
        return result;
    }
}