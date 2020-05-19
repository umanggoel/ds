package com.company.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringCompares {


    public boolean backspaceCompare(String S, String T) {


        Stack s = new Stack();
        Stack s2 = new Stack();
        char str1[] = S.toCharArray();
        char str2[] = T.toCharArray();

        for(int i=0;i< str1.length;i++){
            if(str1[i] != '#' && !s.isEmpty()){
                s.push(str1[i]);
            } else{
                s.pop();
            }
        }

        for(int i=0;i< str2.length;i++){
            if(str2[i] != '#'){
                s2.push(str2[i]);
            } else{
                s2.pop();
            }
        }

        if(s.toString().equals(s2.toString())){
            return true;
        }
        return false;
    }



    public static String[] searchDictionary(String[] words,String [] dict){

        Map<String, Integer> map = new HashMap<>();

        String[] result = new String[words.length];
        for(int i=0;i<dict.length;i++){
            for(int j=0;j<dict.length;j++){
                if(i == j) continue;
                String key = dict[i]+dict[j];
                map.put(key,1);
            }
        }

        int count = 0 ;
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                result[count] = words[i];
                count++;
            }
        }
        return result;
    }
}
