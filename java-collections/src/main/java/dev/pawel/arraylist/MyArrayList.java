package dev.pawel.arraylist;

import dev.pawel.MyList;

import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_SIZE = 0;
    private int capacity;
    private int size;
    private Object[] array;

    public MyArrayList(MyList<E> myList) {
        this(myList.size());
        for (int i = 0; i < myList.size(); i++) {
            add(i, myList.get(i));
        }
    }

    private MyArrayList(int capacity, int size) {
        this.capacity = capacity;
        this.size = size;
        this.array = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this(capacity, DEFAULT_SIZE);
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY, DEFAULT_SIZE);
    }

    @Override
    public E get(int index) {
        if (index < size)
            return (E) array[index];
        else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public E set(int index, E element) {
        if (index < size) {
            array[index] = element;
            return (E) array[index];
        } else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean add(E element) {
        resize();
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        resize();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    @Override
    public boolean addAll(MyList<E> myList) {
        if (myList.size() == 0)
            return false;
        for (int i = 0; i < myList.size(); i++)
            add(myList.get(i));
        return true;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        Object removed = array[index];
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        size--;
        return (E) removed;
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, array[i]))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        String result = "";
        while (i < size) {
            if ((i + 1) == size)
                result = stringBuilder.append(array[i]).toString();
            else
                result = stringBuilder.append(array[i]).append(", ").toString();
            i++;
        }
        return '[' + result +
                ']';
    }

    private void resize() {
        int count = 0;
        if (capacity == size) {
            capacity += capacity / 2;
            Object[] newArray = new Object[capacity];
            while (count < array.length) {
                newArray[count] = array[count];
                count++;
            }
            array = newArray;
        }
    }
}
