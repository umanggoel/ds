package com.company.comoanyasked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subdomains {

    public static void main(String[] args) {
        Subdomains subdomains = new Subdomains();
        String arr[] = {"900 sub.sub1.domain"};
        subdomains.subdomainVisits(arr);
    }

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String , Integer> map = new HashMap<>();
        for(String s: cpdomains) {
            foo(s, map);
        }

        List<String> result = new ArrayList<>();
        for(String key: map.keySet()) {
            result.add(map.get(key)+ " "+key);
        }

        return result;
    }

    void foo(String s, Map<String, Integer> map) {
        String a[] = s.split(" ");
        int count = Integer.parseInt(a[0]);
        map.put(a[1], map.getOrDefault(a[1], 0)+count);
        String sub = a[1];

        while(sub.indexOf(".") != -1) {
            sub = sub.substring(sub.indexOf(".")+1);
            map.put(sub, map.getOrDefault(sub, 0)+count);
        }
    }
}
