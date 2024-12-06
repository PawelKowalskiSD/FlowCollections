package dev.pawel;

public interface MyMap<K, V> {
    interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);
        boolean equals(Object o);
        int hashCode();
    }
    int size();
    boolean isEmpty();
    boolean containsKey(K key);
    boolean containsValue(V value);
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    void clear();
    MyList<K> keySet();
    MyList<V> values();
    MyList<MyMap.Entry<K, V>> entrySet();

}
