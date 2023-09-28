package design.lru.storage;

import design.lru.exceptions.NotFoundException;
import design.lru.exceptions.StorageFullException;

public interface Storage <Key, Value>{

    public void add(Key key, Value value) throws StorageFullException, StorageFullException;

    void remove(Key key) throws NotFoundException, NotFoundException;

    Value get(Key key) throws NotFoundException;
}
