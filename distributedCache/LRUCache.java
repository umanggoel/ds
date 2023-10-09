package distributedCache;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K,V> extends Cache<K,V>{

    private final ConcurrentHashMap<K,V> map = new ConcurrentHashMap<>();
    private final Deque<K> q = new LinkedList<>();

    public LRUCache(int size) {
        this.setSize(size);
    }

    protected void put(K key, V value) {
        if(map.get(key) != null) {
            moveToHead(key);
        }

        if(map.size() >= this.getSize()){
            K removed = q.removeLast();
            map.remove(removed);
        }

        map.put(key, value);
        q.addFirst(key);
    }

    private void moveToHead(K key) {
        q.remove(key);
        q.addFirst(key);
    }

    protected V get(K key) {
        if(map.get(key) == null) {
           return null;
        }
        moveToHead(key);
        return map.get(key);
    }

    protected void evict() {
     map.clear();
     q.clear();
    }

}
