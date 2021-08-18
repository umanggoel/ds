package com.company.comoanyasked;

/*
Given a character array s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
Your code must solve the problem in-place, i.e. without allocating extra space.

Example 1:

Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Example 2:

Input: s = ["a"]
Output: ["a"]

Constraints:

1 <= s.length <= 105
s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
There is at least one word in s.
s does not contain leading or trailing spaces.
All the words in s are guaranteed to be separated by a single space.
 */
public class ReverseWordsINString186 {


    public static void main(String[] args) {
        ReverseWordsINString186 reverseWordsINString186 = new ReverseWordsINString186();
        String s = "t ";
        char[] arr= s.toCharArray();
        reverseWordsINString186.reverseWords(arr);

        System.out.println(arr);
    }


    private void reverseWords(char[] s) {
        int len = s.length;
        reverseArray(s, 0, len-1);
        int start = 0;

        for(int i = 0; i< len; i++) {
           if(s[i] == ' '){
               reverseArray(s, start, i-1);
               start = i+1;
            }
        }

        reverseArray(s, start, len-1);
    }

    private void reverseArray(char[] s, int start, int end) {

        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
