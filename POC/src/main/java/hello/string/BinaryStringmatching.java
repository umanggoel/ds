package com.company.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryStringmatching {

    public boolean hasAllCodes(String s, int k) {

//        if(s.length() < k) return false;
//
//        List<String> list = new ArrayList<>();
//
//        for(int i=0;i<s.length()-k+1;i++){
//            list.add(s.substring(i,i+k));
//        }
//
//
//        double limit = Math.pow(2,k)-1;
//        Map<Integer,Boolean> map = new HashMap<>();
//        for(int i=0;i<=limit;i++){
//            map.put(i,true);
//        }
//
//        for(String str : list){
//            double num = 0;
//            for(int i=str.length()-1;i>=0;i--){
//                num = num + Integer.parseInt(str.substring(i,i+1))*Math.pow(2,k-i-1);
//            }
//            map.put((int)num,false);
//        }
//
//        for(Boolean b: map.values()){
//            if(b) return false;
//        }
//
//        return true;

        if(s.length() < k) return false;

        List<String> list = new ArrayList<>();
        String format = "%0" + k + "d";
        double limit = Math.pow(2,k)-1;
        Map<String,Boolean> map = new HashMap<>();
        for(int i=0;i<=limit;i++){
            map.put(String.format(format,
                    Double.valueOf(Integer.toBinaryString(i))),true);
        }

        for(int i=0;i<s.length()-k+1;i++){
            map.put(s.substring(i,i+k),false);
        }

        for(Boolean b: map.values()){
            if(b) return false;
        }

        return true;
    }
}
