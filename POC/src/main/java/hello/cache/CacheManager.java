package com.company.cache;

import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {

    private ConcurrentHashMap<String, Object> map = new ConcurrentHashMap();

    public <T,K> void initializeCache(String name, Cache<T,K> cache) {
        map.put(name, cache);
    }

    public <T,K> K get(String name, T key) {
        if(map.get(name) == null) return null;
        return ((Cache<T,K>) map.get(name)).get(key);
    }

    public <T,K> void put(String name, T key, K value) {
        if(map.get(name) == null) return;
        ((Cache<T,K>) map.get(name)).put(key, value);
    }

}
