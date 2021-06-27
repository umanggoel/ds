package com.company.cache;

public class Test {

    public static void main(String[] args) {

        Cache<String, String> cache = new Cache(2);
        CacheManager c = new CacheManager();
        c.initializeCache("my",cache);
        c.put("my","umang","umang");
        c.put("my","umang1","umang1");
        c.put("my","umang2","umang2");

        String s = c.get("my","umang");
        System.out.print(s);
    }
}
