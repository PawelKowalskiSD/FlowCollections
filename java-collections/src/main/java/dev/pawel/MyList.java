package dev.pawel;

public interface MyList<E> {
    E get(int index);
    E set(int index, E element);
    boolean add(E element);
    void add(int index, E element);
    E remove(int index);
    boolean remove(E element);
    int size();
    boolean contains(E element);
    int indexOf(E element);
}
