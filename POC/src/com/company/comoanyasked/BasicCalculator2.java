package com.company.comoanyasked;

import java.util.HashMap;
import java.util.Map;

public class BasicCalculator2 {
    public static void main(String[] args) {
        BasicCalculator2 basicCalculator2 = new BasicCalculator2();
        basicCalculator2.calculate("3+2*2");
    }
    public int calculate(String s) {

        Map<Character, Integer> priority = new HashMap<>() ;

        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',3);
        priority.put('/',2);

        java.util.Stack<Character> op = new java.util.Stack();
        java.util.Stack<Integer> values = new java.util.Stack();

        int len = s.length();
        char[] arr = s.toCharArray();

        int start = 0;
        for(int i = 0;i< len;i++) {
            if(priority.get(arr[i]) != null) {
                String temp = s.substring(start, i);
                if(temp.trim().length() > 0) values.push(Integer.parseInt(temp));
                start = i + 1;
                while(!op.isEmpty() && priority.get(op.peek()) >= priority.get(arr[i])){
                    values.push(operate(op.pop(), values.pop(), values.pop()));
                }
                op.push(arr[i]);
            }
        }

        if(start != len) {
            String temp = s.substring(start);
            values.push(Integer.parseInt(temp));
        }


        while(!op.isEmpty()){
            values.push(operate(op.pop(), values.pop(), values.pop()));
        }

        return values.pop();

    }

    int operate(char op, int b, int a) {
        switch(op) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;

        }

        return 0;
    }
}