package distributedCache;

public class CacheFactory {

    public <K,V> Cache getCache(CacheType type, int size) {
        if(type == CacheType.LRU){
            return new LRUCache<K,V>(size);
        }
        return null;
    }
}
