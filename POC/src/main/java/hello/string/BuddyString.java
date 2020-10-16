package com.company.string;

import java.util.ArrayList;
import java.util.List;

public class BuddyString {

    public static void main(String[] args) {
        BuddyString buddyString = new BuddyString();
        buddyString.buddyStrings("abcd","badc");
    }


    public boolean buddyStrings(String A, String B) {


        if(A==null || B==null || A.length() != B.length()) return false;
        int count[] = new int[26];

        if(A.equals(B)){
            for(int i = 0 ;i<A.length() ;i++) {
                count[A.charAt(i)-'a']++;
            }

            for(int i=0;i<26;i++) {
                if(count[i] >= 2) return true;
            }
            return false;
        }

        List<Character> adiff = new ArrayList();
        List<Character> bdiff = new ArrayList();

        for(int i = 0 ;i<A.length() ;i++) {
            if(A.charAt(i) != B.charAt(i)) {
                adiff.add(A.charAt(i));
                bdiff.add(B.charAt(i));
            }
        }

        if( adiff.size() != 2 || bdiff.size() != 2) return false;

        adiff.sort((c1, c2)->c1-c2);
        bdiff.sort((c1, c2)->c1-c2);

        if(adiff.get(0) == bdiff.get(0) && adiff.get(1) == bdiff.get(1)) return true;
        return false;
    }
}
