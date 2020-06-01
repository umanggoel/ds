package com.company.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {

    public static int calculate(String s) {

        int value = 0;
        Stack<Character> operands = new Stack<>();
        Stack<Integer> digits = new Stack<>();

        Map<Character, Integer> priorites = new HashMap<>();
        priorites.put('+',1);
        priorites.put('-',1);
        priorites.put('*',2);
        priorites.put('/',2);
        int number  = -1;

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr >= '0' && curr <= '9'){
                if(number == -1){
                    number = Integer.parseInt(s.substring(i,i+1));
                }else{
                    number = number*10+Integer.parseInt(s.substring(i,i+1));
                }
            }
            else if(number != -1){
                digits.push(number);
                number = -1;
            }
            if(priorites.get(curr) != null){
                if(!operands.isEmpty() && priorites.get(operands.peek()) >= priorites.get(curr)){
                    int calc = 0;
                    int v2 = digits.pop();
                    int v1 = digits.pop();
                    switch(operands.pop()){
                        case '*':
                            calc = v1*v2;
                            break;
                        case '+':
                            calc = v1+v2;
                            break;
                        case '-':
                            calc = v1-v2;
                            break;
                        case '/':
                            calc = v1/v2;
                    }
                    digits.push(calc);
                    i--;
                }else{
                    operands.push(curr);
                }
            }
        }

        if(number != -1){
            digits.push(number);
            number = 0;
        }
        while(!operands.isEmpty()) {
            int calc = 0;
            int v2 = digits.pop();
            int v1 = digits.pop();
            switch(operands.pop()){
                case '*':
                    calc = v1*v2;
                    break;
                case '+':
                    calc = v1+v2;
                    break;
                case '-':
                    calc = v1-v2;
                    break;
                case '/':
                    calc = v1/v2;
            }
            digits.push(calc);
        }
        return digits.pop();
    }

    public static int calculate2(String s) {
        int value = 0;
        Stack<Character> operands = new Stack<>();
        Stack<Integer> digits = new Stack<>();

        Map<Character, Integer> priorites = new HashMap<>();
        priorites.put('+',4);
        priorites.put('-',4);
        priorites.put('(',3);
        priorites.put(')',1);

        Map<Character, Integer> numbers = new HashMap<>();
        numbers.put('0',0);
        numbers.put('1',1);
        numbers.put('2',2);
        numbers.put('3',3);
        numbers.put('4',4);
        numbers.put('5',5);
        numbers.put('6',6);
        numbers.put('7',7);
        numbers.put('8',8);
        numbers.put('9',9);

        int number  = -1;

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(numbers.get(curr) != null){
                if(number == -1){
                    number = numbers.get(curr);
                }else{
                    number = number*10+numbers.get(curr);
                }
            }
            else if(number != -1){
                digits.push(number);
                number = -1;
            }
            if(priorites.get(curr) != null){
                if(curr == '('){
                    operands.push(curr);
                }else if(!operands.isEmpty() && priorites.get(operands.peek()) >= priorites.get(curr)){
                    char operand = operands.pop();
                    if(operand == '('){
                        continue;
                    }
                    int calc = 0;
                    int v2 = digits.pop();
                    int v1 = digits.pop();
                    switch(operand){
                        case '+':
                            calc = v1+v2;
                            break;
                        case '-':
                            calc = v1-v2;
                            break;
                    }
                    digits.push(calc);
                    i--;
                }else if(curr != ')') {
                    operands.push(curr);
                }
            }
        }

        if(number != -1){
            digits.push(number);
            number = 0;
        }
        while(!operands.isEmpty()) {
            int calc = 0;
            int v2 = digits.pop();
            int v1 = digits.pop();
            switch(operands.pop()){
                case '+':
                    calc = v1+v2;
                    break;
                case '-':
                    calc = v1-v2;
            }
            digits.push(calc);
        }
        return digits.pop();
    }
}
