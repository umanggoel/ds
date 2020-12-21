package com.company.string;

public class GCD {

    public static void main(String[] args) {
        GCD gcd= new GCD();
        gcd.gcdOfStrings("abcabc", "abc");
    }

    public String gcdOfStrings(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();

        if(l1 < l2){
            return gcd(str2, str1);
        }

        return gcd(str1, str2);

    }

    private String gcd(String str1, String str2) {
//        int l1 = str1.length();
//        int l2 = str2.length();
//
//        for(int i = 0;i< l2;i++){
//            String s  = str2.substring(0, i+1);
//            int t1 =  (l1-(i+1))/(i+1);
//            int t2 =  (l2-(i+1))/(i+1);
//
//            String s1 = "";
//            String s2 = "";
//            for(int j = 0;j< t1;j++) {
//                s1= s1+s;
//            }
//
//            for(int j = 0;j< t2;j++) {
//                s2= s2+s;
//            }
//
//            if(s1.equals(str1) && s2.equals(str2)){
//                return s;
//            }
//        }
//        return "";

        int l1 = str1.length();
        int l2 = str2.length();

        String result = "";
        for(int i = l2-1;i>=0;i--){
            String s  = str2.substring(0, i);
            int t1 =  (l1-(i+1))/(i+1);
            int t2 =  (l2-(i+1))/(i+1);

            StringBuilder s1 = new StringBuilder(s);
            StringBuilder s2 = new StringBuilder(s);
            for(int j = 0;j< t1;j++) {
                s1.append(s);
            }

            for(int j = 0;j< t2;j++) {
                s2.append(s);
            }

            if(s1.toString().equals(str1) && s2.toString().equals(str2)){
                result = s;
                break;
            }
        }
        return result;
    }
}
