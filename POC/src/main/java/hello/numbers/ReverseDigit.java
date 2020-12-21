package com.company.numbers;

public class ReverseDigit {

    public static void main(String[] args) {
        ReverseDigit reverseDigit = new ReverseDigit();
        reverseDigit.reverse(120);
    }

    public int reverse(int x) {

        int result = 0;
        int num = x;
        int digit = x%10 ;
        int numDigit = 1;
        while(num != 0) {
            if(result >= Integer.MAX_VALUE/10 || numDigit > 7) return 0;
            if(result <= Integer.MIN_VALUE/10 || numDigit > 7) return 0;
            result = result*10+digit;
            num =  num/10;
            digit = num%10;
            numDigit++;
            if(x < 0 && result >= 0) result =  -1*result;
        }

        return result;
    }
}
