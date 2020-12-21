package com.company.comoanyasked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(System.out);
//        int T = Integer.parseInt(br.readLine().trim());
//        for(int t_i = 0; t_i < T; t_i++)
//        {
//            String S1 = br.readLine();
//            String S2 = br.readLine();
//            char C = br.readLine().trim().charAt(0);
//            int l = Integer.parseInt(br.readLine().trim());
//            int out_ = Hack_sol(S1, S2, C, l);
//            System.out.println(out_);
//        }
//        wr.close();
//        br.close();

        System.out.println(Hack_sol("we love to hack on hackerearth","hack",'Y',0));
    }

    static int Hack_sol(String s1, String s2, char C, int l){


        int s1len = s1.length();
        char arr2[] = s2.toCharArray();
        char arr1[] = s1.toCharArray();

        for(int i=l;i<s1len;i++){
            int j=0;
            for(;j<s2.length() && i<s1len ;) {
                if(arr1[i] != arr2[j]){
                    break;
                }
                j++;
                i++;
            }
            if(j == s2.length()){
                if(C == 'N'){
                    return i-s2.length();
                } else {
                    int start = i-s2.length();

                    if(start == 0 && (i == s1len || arr1[i] == ' ')){
                        return start;
                    } else if(i == s1len && arr1[start-1] == ' '){
                        return start;
                    } else if(arr1[start-1] == ' ' && arr1[i] == ' '){
                        return start;
                    }
                }
            }

        }

        System.out.println("Goodbye Watson");
        return -1;
    }
}