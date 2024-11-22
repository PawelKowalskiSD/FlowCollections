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

    boolean addAll(MyList<E> myList);

    static <E> MyList<E> of(E... elements) {
        MyList<E> myList = new MyArrayList<>(elements.length);
        for (E element : elements)
            myList.add(element);
        return myList;
    }
}
