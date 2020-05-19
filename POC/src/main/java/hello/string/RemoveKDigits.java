package com.company.string;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        String result = "";
        if(num.length() <=k ) return "0";
        int k1 = k;
        Stack<Character> stack = new Stack();

        for(int i=0;i<num.length();i++) {
            char digit =num.charAt(i);
            if(stack.isEmpty() && digit != '0'){
                stack.push(digit);
                continue;
            }
            if(k1 > 0 && stack.peek() > digit){
                stack.pop();
                k1--;
            }
            if(stack.isEmpty() && digit == '0'){
                continue;
            }
            stack.push(digit);
        }

        while(!stack.isEmpty()){
            char digit = stack.pop();
            if(!stack.isEmpty() && k1 != 0){
                k1--;
                if(stack.peek() > digit){
                    stack.pop();
                    stack.push(digit);
                    continue;
                }else {
                    continue;
                }
            }

            result = digit+result;
        }
        return result.trim();
    }
}
