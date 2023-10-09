package distributedCache;

import java.util.HashMap;
import java.util.Map;

public class CacheManager{

    private final Map<String, Cache> caches = new HashMap<>();
    CacheFactory cacheFactory = new CacheFactory();

    public <K,V> boolean createCache(String name, int size, CacheType type) {
        Cache c = cacheFactory.<K,V>getCache(type, size);
        caches.put(name, c);
        return true;
    }

    public boolean removeCache(String name) {
        if(caches.get(name) == null) return false;
        caches.remove(name);
        return true;
    }

    public <K,V> boolean put(String name, K key, V value) {
        if(caches.get(name) == null) return false;
        caches.get(name).put(key, value);
        return true;
    }

    public <K,V> V getValue(String name, K key) {
        if(caches.get(name) == null) return null;
        return (V)caches.get(name).get(key);
    }

    public boolean clearCache(String name) {
        if(caches.get(name) == null) return false;
        caches.get(name).evict();
        return true;
    }
}
