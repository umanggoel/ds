package design.lru.policy;

import design.lru.algo.exceptions.InvalidElementException;

public interface EvictionPolicy <Key>{
    void keyAccessed(Key k) throws InvalidElementException;
    Key evictKey();
}
