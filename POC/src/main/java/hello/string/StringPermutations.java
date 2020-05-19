package com.company.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StringPermutations {

    //find all possible permutations of a String AABC

    public List<String> permutations(String str){
        List<String> response = new ArrayList<String>();
        return allPermutations(str,0,response);
    }

    public List<String> combinations(String str){
        List<String> response = new ArrayList<String>();
        response.add("");
        return allCombinations(str,0,response);
    }

    private List<String> allPermutations(String str, int index, List<String> list){

        List<String> response = new ArrayList<>();
        if(index == str.length()-1){
            response.add(str.substring(index,index+1));
            return response;
        }

        list = allPermutations(str,index+1,list);

        for(String s:list){
            String e = str.substring(index,index+1);
            for(int i=0;i<=s.length();i++) {
                StringBuilder sb = new StringBuilder(s);
                String entry = sb.insert(i,e).toString();
                if(!response.contains(entry)) response.add(entry);
            }
        }

        return response;

    }


    private List<String> allCombinations(String str, int index, List<String> list){

        List<String> response = new ArrayList<>();
        if(index == str.length()-1){
            response.add(str.substring(index,index+1));
            response.addAll(list);
            return response;
        }

        list = allCombinations(str,index+1,list);


        for(String s:list){
            String entry = str.substring(index,index+1)+s;
            if(!response.contains(entry)) response.add(entry);
        }

        for(String s:list){
            if(!response.contains(s)) response.add(s);
        }
        return response;

    }

    public String getPermutation(int n, int k) {

        String str = "123456789";
        if(n == 0) return "";
        if(n == 1) {
            return "1";
        }

        List<String> result = new ArrayList<>();
        printPermutn(str.substring(0,n),"",result);
        result = result.stream().sorted().collect(toList());
        System.out.println(result);
        return result.get(k-1);
    }

    void printPermutn(String str, String ans, List<String> result)
    {
        // If string is empty
        if (str.length() == 0) {
            result.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            printPermutn(ros, ans + ch,result);
        }
    }

}
