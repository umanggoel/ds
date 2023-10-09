package distributedCache;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Cache<K,V> {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    protected abstract void put (K key, V value);
    protected abstract V get (K key);
    protected abstract void evict ();
}
