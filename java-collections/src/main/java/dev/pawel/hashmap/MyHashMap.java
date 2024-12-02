package dev.pawel.hashmap;

import dev.pawel.MyList;
import dev.pawel.MyMap;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private Node<K, V>[] table = new Node[10];
    private static int DEFAULT_SIZE = 0;
    private int size = 0;

    public MyHashMap() {
        this.size = DEFAULT_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public V get(K key) {
        int hash = key == null ? 0 : Math.abs(key.hashCode());
        int index = hash % table.length;
        return table[index].value;
    }

    @Override
    public V put(K key, V value) {
        int hash = key == null ? 0 : Math.abs(key.hashCode());
        int index = hash % table.length;
        Node<K, V> node = new Node<>();
        node.key = key;
        node.value = value;
        table[index] = node;
        return value;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public MyList<K> keySet() {
        return null;
    }

    @Override
    public MyList<V> values() {
        return null;
    }

    @Override
    public MyList<Entry<K, V>> entrySet() {
        return null;
    }

    private class Node<K, V> implements Entry<K, V> {
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
    }
}
