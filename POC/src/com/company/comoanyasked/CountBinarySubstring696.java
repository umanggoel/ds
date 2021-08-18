package com.company.comoanyasked;

public class CountBinarySubstring696 {

    public static void main(String[] args) {
        CountBinarySubstring696 countBinarySubstring696 = new CountBinarySubstring696();
        countBinarySubstring696.countBinarySubstrings("110011101");
    }

    public int countBinarySubstrings(String s) {

        char c[] = s.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;
        int count = 0;
        int prev = c[0];
        for(int i = 0;i< s.length();i++) {
            if(c[i] == '0') {
                if(c[i] != prev && zeroCount != 0){
                    zeroCount = 1;
                }else{
                    zeroCount++;
                }
                if(zeroCount <= oneCount){
                    count++;
                }
            }else if(c[i] == '1'){
                if(c[i] != prev && oneCount != 0){
                    oneCount = 1;
                }else{
                    oneCount++;
                }

                if(oneCount <= zeroCount){
                    count++;
                }
            }

            if(c[i] != prev){
                prev = c[i];
            }
        }

        return count;
    }

//    public int countBinarySubstrings(String s) {
//
//            java.util.Stack one = new java.util.Stack();
//            java.util.Stack zero = new java.util.Stack();
//            char c[] = s.toCharArray();
//            int count = 0;
//
//            for(int i = 0;i< s.length();i++) {
//                if(c[i] == '0') {
//                    if(!one.isEmpty()){
//                        one.pop();
//                        count++;
//                    }
//                    zero.push(0);
//                }else if(c[i] == '1'){
//                    if(!zero.isEmpty()){
//                        zero.pop();
//                        count++;
//                    }
//                    one.push(1);
//                }
//            }
//
//            return count;
//        }

}
