package distributedCache;

/*
1. generic cache key and value should be dynamic
2. LRU cache
3. Concurrent operation handling
4. size of cache and basic cache functionality (get, put , evict).
 */

public class TestCache {

    public static void main(String[] args) {
        CacheManager cacheManager = new CacheManager();

        cacheManager.<String,String>createCache("sample1", 4, CacheType.LRU);
        cacheManager.createCache("sample2", 2, CacheType.LRU);
        cacheManager.createCache("sample3", 5, CacheType.LRU);

        cacheManager.<String,String>put("sample1", "umang","1");
        cacheManager.put("sample1", "umang1","engg1");
        cacheManager.put("sample1", "umang2","engg2");
        cacheManager.put("sample1", "umang3","engg3");
        cacheManager.put("sample1", "umang4","engg4");

        System.out.println((String)cacheManager.getValue("sample1","umang2"));
        cacheManager.put("sample1", "umang","engg");

        System.out.println((String)cacheManager.getValue("sample1","umang2"));

    }
}
