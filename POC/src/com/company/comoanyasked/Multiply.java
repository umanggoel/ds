package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Multiply {

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        multiply.multiply("1234","0");
    }


    public String multiply(String num1, String num2) {

        String result = null;
        Map<Character, Integer> map = new HashMap();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        List<String> list = new ArrayList<>();

        for(int i= num2.length()-1 ;i>=0;i--) {
            String s = "";
            int carry  = 0;
            for(int j = num1.length()-1 ; j >= 0;j--) {
                int t = map.get(n1[j]) * map.get(n2[i])+carry;
                carry = t/10;
                s= t%10+s;
            }
            if(carry != 0) s=carry+s;
            for(int j = 0;j < num2.length()-1-i;j++){
                s=s+"0";
            }
            list.add(s);
        }

        for(int i = 0;i< list.size();i++) {
            if(result == null){
                result = list.get(i);
                continue;
            }
            char[] t1 = result.toCharArray();
            char[] t2 = list.get(i).toCharArray();
            String s = "";
            int carry  = 0;
            int start1 = t1.length-1;
            int start2 = t2.length-1;
            while(start1 >=0 && start2 >=0)
            {
                int t = map.get(t1[start1]) + map.get(t2[start2])+carry;
                carry = t/10;
                s= t%10+s;
                start1--;
                start2--;
            }

            while(start1 >=0 ) {
                int t = map.get(t1[start1])+carry;
                carry = t/10;
                s= t%10+s;
                start1--;
            }

            while(start2 >=0){
                int t = map.get(t2[start2])+carry;
                carry = t/10;
                s= t%10+s;
                start2--;
            }


            if(carry != 0) s=carry+s;
            result=s;

        }

        int len = result.length();
        int st = 0;
        char[] val = result.toCharArray();

        while ((st < len) && (val[st] == '0')) {
            st++;
        }

        if(st == len) return "0";

        result =  result.substring(st);
        return result;
    }

}
