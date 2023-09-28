package design.lru.factory;

import design.lru.cache.Cache;
import design.lru.policy.LRUEvictionPolicy;
import design.lru.storage.HashBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashBasedStorage<>(capacity));
    }
}