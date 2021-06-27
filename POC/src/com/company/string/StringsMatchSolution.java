package com.company.string;

public class StringsMatchSolution {

    public static void main(String[] args) {
        Hack_sol("We kove to hack on hackeearth", "hack", 'Y', 2);
    }

    static int Hack_sol(String S1, String S2, char c, int l){
        String temp = S1.substring(l);
        int index = l;
        if(c == 'Y') {
            String arr[] = temp.split(" ");
            int i = 0;
            for(i =0;i<arr.length;i++) {
                if(arr[i].equals(S2)) {
                    break;
                }else{
                    index = index +arr[i].length()+1;
                }
            }

            if(i == arr.length) {
                System.out.println("Goodbye Watson.");
                return -1;
            }
        } else {
            int t = temp.indexOf(S2);
            if(t >= 0) {
                index = index + t;
            }
        }

        return index;


    }
}
