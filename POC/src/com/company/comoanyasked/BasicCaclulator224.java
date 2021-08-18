package com.company.comoanyasked;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCaclulator224 {

    public static void main(String[] args) {
        BasicCaclulator224  basicCaclulator224 = new BasicCaclulator224();
        basicCaclulator224.calculate("-2+(-1)");
    }


    public int calculate(String s) {

        Map<Character, Integer> priority = new HashMap();
        priority.put('(',0);
        priority.put('+', 1);
        priority.put('-', 1);

        java.util.Stack<Character> operators = new java.util.Stack<>();
        java.util.Stack<Integer> values = new Stack<>();
        char arr[] = s.toCharArray();
        int len = s.length();
        int start = 0;

        for(int i = 0;i<len;i++) {

            if(arr[i] == '(' || arr[i] == ')' || arr[i] == '+' || arr[i] == '-'){
                String temp = s.substring(start, i).trim();
                if(temp.length() > 0) values.push(Integer.parseInt(temp));
                start = i+1;
            }

            if(arr[i] == '(') {
                operators.push(arr[i]);
            }else if(arr[i] == ')') {
                while(operators.peek() != '(') {
                    int op2 = values.pop();
                    char op =  operators.pop();
                    if(values.isEmpty()) {
                        values.push(-1*op2);
                    }else{
                        values.push(operate(op, op2, values.pop()));
                    }
                }
                operators.pop();
            }else if(arr[i] == '+' || arr[i] == '-') {
                while(!operators.isEmpty() && priority.get(operators.peek()) >= priority.get(arr[i])){
                    int op2 = values.pop();
                    char op =  operators.pop();
                    if(values.isEmpty()) {
                        values.push(-1*op2);
                    }else{
                        values.push(operate(op, op2, values.pop()));
                    }
                }
                operators.push(arr[i]);
            }

        }

        if(start < len) {
            String temp = s.substring(start, len).trim();
            if(temp.length() > 0) values.push(Integer.parseInt(temp));
        }


        while(!operators.isEmpty()){
            int op2 = values.pop();
            if(values.isEmpty()) {
                operators.pop();
                values.push(-1*op2);
            }else{
                values.push(operate(operators.pop(), op2, values.pop()));
            }
        }
        return values.pop();

    }

    int operate(char op, int b, int a) {
        switch(op) {
            case '+':
                return a+b;
            case '-':
                return a-b;
        }

        return 0;
    }
}