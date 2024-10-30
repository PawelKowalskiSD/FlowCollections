package dev.pawel;

import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_SIZE = 0;
    private int capacity;
    private int size;
    private Object []array;

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
        if (capacity == size) {
            capacity += capacity / 2;
            Object []newArray = new Object[capacity];
            array = resize(array, newArray);
        }
        array[size] = element;
        size++;
        return true;
    }

    private Object[] resize(Object[] oldArray, Object[] newArray) {
        int count = 0;

        while (count < oldArray.length) {
            newArray[count] = oldArray[count];
            count++;
        }
        return newArray;
    }

    private void resize(Object[] oldArray, Object[] newArray, int index, E element) {
        int count = 0;
        int countOld = 0;

        while (count < oldArray.length) {
            if(count == index)
                newArray[count] = element;
            else {
                newArray[count] = oldArray[countOld];
                countOld++;
            }
            count++;
        }
        array = newArray;
    }


    @Override
    public void add(int index, E element) {
        if (index > size) {
            if (capacity == size) {
                capacity += capacity / 2;
                Object[] newArray = new Object[capacity];
                resize(array, newArray, index, element);
            } else {
                Object[] newArray = new Object[capacity];
                resize(array, newArray, index, element);
            }
            size++;
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public int size() {
        return size;
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
}
