package com.company.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class FindBackupFilesCount {

    public static void main(String[] args) {
        FindBackupFilesCount findBackupFilesCount = new FindBackupFilesCount();
        String str = "715K 2009-09-23 system.zip~\n 179K 2013-08-14 to-do-list.xml~\n 645K 2013-06-19 blockbuster.mpeg~\n  536 2010-12-12 notes.html\n 688M 1990-02-11 delete-this.zip~\n  23K 1987-05-24 setup.png~\n 616M 1965-06-06 important.html\n  14M 1992-05-31 crucial-module.java~\n 192K 1990-01-31 very-long-filename.dll~";
        findBackupFilesCount.solution(str);
    }

    public String solution(String S) {

        String arr[] = S.split("\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String start = "1900-01-31";
        long maxSize = 14680064;

        Set<String> set = new HashSet<>();
        for(String str: arr) {
            String temp[] = str.trim().split(" ");
            long size = calculateSize(temp[0]);
            try {
                if(temp[2].charAt(temp[2].length()-1) == '~'
                        && sdf.parse(start).before(sdf.parse(temp[1]))
                        && size<= maxSize)
                    set.add(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(set.size()==0) return "NO FILES";
        return Integer.toString(set.size());
    }

    long calculateSize(String str) {
        char lastChar = str.charAt(str.length()-1);
        if( lastChar <= '9' && lastChar >= '0'){
            return Integer.parseInt(str);
        }else {
            int n = Integer.parseInt(str.substring(0,str.length()-1));
            switch(lastChar){
                case 'K' :
                    return n * (long)Math.pow(2,10);
                case 'M' :
                    return n * (long)Math.pow(2,20);
                case 'G' :
                    return n * (long)Math.pow(2,30);
            }
        }
        return 0;
    }
}

