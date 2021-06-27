package com.company.comoanyasked;

public class SearchText {

    public static void main(String[] args) {
        SearchText searchText = new SearchText();
        System.out.println(searchText.textsearch("work from home", "ork rom"));
    }

    boolean textsearch(String sentence, String pattern) {

        int plen = pattern.length();
        int slen = sentence.length();
        if(plen > slen) return false;

        int arr[] = new int[slen];

        //work from homhome
        //             home


        for(int i =0;i< slen;i++) {
            boolean isPresent = true;

            for(int j = 0;j< plen;j++) {
                if(sentence.charAt(i+j) != pattern.charAt(j)){
                    isPresent = false;
                    break;
                }
            }

            if(isPresent) return true;
        }

        return false;
    }
}


//bag, bags, baggage
//bag
//
////          b
////      a       o
////    g(bag)   t      o
////   s(bags)  g     s      k
//
//class Node {
//    Node arr[] = new Node[26];
//
//}

//min length search
//Lookuptable
// ab    machine1 trie1
// ac    machine1 trie2
// ad
// x

// consistent has ring of m nodes
//h(key) is number
// number/m   = 1, 2,3

//bloomfilter



