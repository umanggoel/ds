package com.company.google;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        DecodeString string = new DecodeString();
        System.out.println(string.decodeString("2[abc]3[cd]ef"));
        System.out.println(string.decodeString("100[leetcode]"));
        System.out.println(string.decodeString("3[a2[c]]"));
    }
    public String decodeString(String s) {

        return generate(s);
    }

    String generate(String s){

        if(s.indexOf("[") == -1) return s;
        String str = "";
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr>'0' && curr<='9'){
                int digits = 0;
                int index = i;
                while(s.charAt(index)>='0' && s.charAt(index)<='9'){
                    digits++;
                    index++;
                }

                int times = Integer.parseInt(s.substring(i,i+digits));

                Stack<Character> stack = new Stack();
                int count = i+digits;
                stack.push(s.charAt(count++));
                while(!stack.isEmpty()){
                    count++;
                    if(s.charAt(count) == ']'){
                        stack.pop();
                    }if(s.charAt(count) == '['){
                        stack.push('[');
                    }
                }
                String temp = generate( s.substring(i+digits+1,count));
                System.out.println(temp);
                for(int j=0;j<times;j++){
                    str = str+ temp;
                }
                i = count;
            }else{
                str = str+curr;
            }
        }
        return str;
    }
}
