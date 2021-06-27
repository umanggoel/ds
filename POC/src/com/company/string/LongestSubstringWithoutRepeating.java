package com.company.string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating  longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
        longestSubstringWithoutRepeating.lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;
        int max = 1;
        char arr[] = s.toCharArray();

        for(int i=0;i<arr.length;i++) {
            HashMap<Character, Integer> map =new HashMap();
            for(int j=0;j<arr.length;j++) {
                map.put(arr[j], map.getOrDefault(arr[j],0)+1);
                int flag = 0;
                for(Character c:map.keySet()) {
                    if(map.get(c) > 1){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    max = Math.max(max, map.size());
                }else{
                    break;
                }
            }
        }

        return max;

    }
}
