package com.company.string;

public class VersionCompare165 {


    public static void main(String[] args) {
        VersionCompare165 versionCompare165 = new VersionCompare165();
        versionCompare165.compareVersion("1","1.0.1");
    }
    public int compareVersion(String version1, String version2) {

        String a1[] = version1.split("\\.");
        String a2[] = version2.split("\\.");

        int len1 = a1.length;
        int len2 = a2.length;

        int i = 0;
        int j = 0;

        while(i <len1 && j< len2) {
            int t1 = Integer.parseInt(a1[i]);
            int t2 = Integer.parseInt(a2[j]);
            if(t1 > t2) return 1;
            if(t2 < t1) return -1;
            i++;
            j++;
        }

        if(len1 == len2) return 0;

        while(i <len1) {
            int t1 = Integer.parseInt(a1[i]);
            if(t1 != 0) return 1;
            i++;
        }


        while(j< len2) {
            int t2 = Integer.parseInt(a2[i]);
            if(t2 != 0) return -1;
            j++;
        }


        return 0;

    }
}
