package design.lru.policy;

import design.lru.algo.DoublyLinkedList;
import design.lru.algo.DoublyLinkedListNode;
import design.lru.algo.exceptions.InvalidElementException;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList<Key> doublyLinkedList;
    private Map<Key, DoublyLinkedListNode<Key>> map;

    public LRUEvictionPolicy( ) {
        this.doublyLinkedList = new DoublyLinkedList<Key>();
        this.map = new HashMap<Key, DoublyLinkedListNode<Key>>();
    }

    @Override
    public void keyAccessed(Key k) throws InvalidElementException {
        if(map.containsKey(k)){
            doublyLinkedList.detachNode(map.get(k));
        }
        DoublyLinkedListNode<Key> d = doublyLinkedList.addElementAtLast(k);
        map.put(k,d);
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode firstNode = doublyLinkedList.getFirstNode();
        if(firstNode==null){
            return null;
        }
        doublyLinkedList.detachNode(firstNode);
        return (Key) firstNode.getElement();
    }

}
