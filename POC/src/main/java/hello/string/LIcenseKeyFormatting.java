package com.company.string;

public class LIcenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0;i<S.length();i++){
            char curr = S.charAt(i);
            if(count < K && curr != '-'){
                sb.append(curr);
                count++;
            }else{
                sb.append('-');
                count =0;
            }
        }

        return sb.toString().toUpperCase();
    }
}
