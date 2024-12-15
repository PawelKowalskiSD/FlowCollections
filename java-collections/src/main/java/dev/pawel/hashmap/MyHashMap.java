package dev.pawel.hashmap;

import dev.pawel.MyList;
import dev.pawel.MyMap;
import dev.pawel.linkedlist.MyLinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_SIZE = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Node<K, V>[] table = new Node[10];
    private int size;
    private int capacity;

    private MyHashMap(int capacity, int size) {
        this.capacity = capacity;
        this.size = size;
    }

    public MyHashMap(int capacity) {
        this(capacity, DEFAULT_SIZE);
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_SIZE);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        for (Node<K, V> findKey : table) {
            if (findKey == null)
                continue;
            if (findKey.key.equals(key))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Node<K, V> findValue : table) {
            if (findValue == null)
                continue;
            if (findValue.value.equals(value))
                return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int hash = key == null ? 0 : Math.abs(key.hashCode());
        int index = hash % table.length;
        Node<K, V> temp = table[index];
        if (temp.key == key || temp.key.equals(key)) {
            return temp.value;
        }
        while (temp.next != null) {
            temp = temp.next;
            if (temp.key.equals(key)) {
                return temp.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = key == null ? 0 : Math.abs(key.hashCode());
        int index = hash % table.length;
        Node<K, V> bucketStart = table[index];
        Node<K, V> node = new Node<>();
        node.key = key;
        node.value = value;
        if (bucketStart == null) {
            table[index] = node;
        } else {
            Node<K, V> temp = bucketStart;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
        return value;
    }

    @Override
    public V remove(K key) {
        for (Node<K, V> removeNode : table) {
            if (removeNode == null)
                continue;
            else {
                Node<K, V> temp = removeNode;
                removeNode = null;
                size--;
                return temp.value;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        for (Node<K, V> clearHashMap : table) {
            if (clearHashMap == null)
                continue;
            remove(clearHashMap.key);
        }
    }

    @Override
    public MyList<K> keySet() {
        MyList<K> myList = new MyLinkedList<>();
        for (Node<K, V> findKey : table) {
            if (findKey == null)
                continue;
            myList.add(findKey.key);
        }
        return myList;
    }

    @Override
    public MyList<V> values() {
        MyList<V> myList = new MyLinkedList<>();
        for (Node<K, V> findValue : table) {
            if (findValue == null)
                continue;
            myList.add(findValue.value);
        }
        return myList;
    }

    @Override
    public MyList<Entry<K, V>> entrySet() {
        MyList<Entry<K, V>> myList = new MyLinkedList<>();
        for (Entry<K, V> findNode : table) {
            if (findNode == null)
                continue;
            else {
                myList.add(findNode);
                Entry<K, V> temp = findNode;
                do {
                    temp = temp.next();
                    myList.add(temp);
                }
                while (temp.next() != null);
            }
        }
        return myList;
    }

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }

        @Override
        public Entry<K, V> next() {
            return next;
        }
    }
}
