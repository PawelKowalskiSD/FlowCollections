package dev.pawel.linkedlist;

import dev.pawel.MyList;

public class MyLinkedList<E> implements MyList<E> {
    private final static int DEFAULT_SIZE = 0;
    private Node<E> head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        size = DEFAULT_SIZE;
    }

    @Override
    public E get(int index) {
        checkIndexIsValid(index);
        int count = 0;
        Node<E> temp = head;
        while (count < size) {
            if (count == index) {
                break;
            }
            temp = temp.next;
            count++;
        }
        return temp.data;
    }

    @Override
    public E set(int index, E element) {
        Node<E> setElement = getNode(index);
        setElement.data = element;
        return setElement.data;
    }

    @Override
    public boolean add(E element) {
        if (head == null)
            head = new Node<>(element);
        else {
            Node<E> temp = nodeIterator();
            temp.next = new Node<>(element);
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        Node<E> findPrevNode = getNode(index - 1);
        Node<E> addNewNode = new Node<>(element);
        addNewNode.next = findPrevNode.next;
        findPrevNode.next = addNewNode;
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> removeNode = getRemoveNode(index);
        return removeNode.data;
    }

    @Override
    public boolean remove(E element) {
        getRemoveNode(indexOf(element));
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E element) {
        Node<E> temp = nodeIterator();
        return temp.data.equals(element);
    }

    @Override
    public int indexOf(E element) {
        int count = 0;
        Node<E> temp = head;
        while (!temp.data.equals(element) && temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    @Override
    public boolean addAll(MyList<E> myList) {
        if (myList.size() == 0)
            return false;
        for (int i = 0; i < myList.size(); i++) {
            add(myList.get(i));
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> temp = head;
        while (temp.next != null) {
            result.append(temp).append(", ");
            temp = temp.next;
        }
        result.append(temp);
        return "[" + result + "]";
    }

    private Node<E> nodeIterator() {
        Node<E> temp = head;
        while (temp.next != null)
            temp = temp.next;
        return temp;
    }

    private Node<E> getRemoveNode(int index) {
        Node<E> findPrevNode = getNode(index - 1);
        Node<E> removeNode = getNode(index);
        findPrevNode.next = removeNode.next;
        removeNode.next = null;
        size--;
        return removeNode;
    }

    private Node<E> getNode(int index) {
        checkIndexIsValid(index);
        Node<E> temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp;
    }

    private void checkIndexIsValid(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}


