package com.company.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplace {

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();

       // findAndReplace.findReplaceString("abcd",new int[]{0,2},new String[]{"ab","ec"},new String[]{"eee","ffff"});

       // findAndReplace.findReplaceString("wreorttvosuidhrxvmvo",new int[]{14,12,10,5,0,18},new String[]{"rxv","dh","ui","ttv","wreor","vo"},new String[]{"frs","c","ql","qpir","gwbeve","n"});

        findAndReplace.findReplaceString("jjievdtjfb",new int[]{4,6,1},new String[]{"md","tjgb","jf"},new String[]{"foe","oov","e"});

    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets)     {

        StringBuilder  sb = new StringBuilder();
        Map<Integer, List<String>> replace = new HashMap<>();
        int index = 0;
        for(int i=0;i<indexes.length;i++){
            index = S.substring(indexes[i]).indexOf(sources[i]);
            if(index == 0 ){
               replace.put(indexes[i], Arrays.asList(sources[i],targets[i]));
            }
        }


        for(int i = 0;i<S.length();i++){
            if(replace.get(i) != null){
                sb.append(replace.get(i).get(1));
                i = i+replace.get(i).get(0).length()-1;
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
