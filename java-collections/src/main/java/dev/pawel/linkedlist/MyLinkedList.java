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
        while (count != index) {
            temp = temp.next;
            count++;
        }
        return temp.data;
    }

    @Override
    public E set(int index, E element) {
        Node<E> setElement = getNodeByIndex(index);
        setElement.data = element;
        return setElement.data;
    }

    @Override
    public boolean add(E element) {
        if (head == null)
            head = new Node<>(element);
        else {
            Node<E> temp = getLastNode();
            temp.next = new Node<>(element);
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        Node<E> addNode = new Node<>(element);
        Node<E> add = changingTheBondsBetweenNodes(addNode, getNodeByIndex(index - 1));
        add.next = addNode;
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> removeNode =
                changingTheBondsBetweenNodes(getNodeByIndex(index - 1), getNodeByIndex(index));
        removeNode.next = null;
        size--;
        return removeNode.data;
    }

    @Override
    public boolean remove(E element) {
        Node<E> removeNode =
                changingTheBondsBetweenNodes(getNodeByIndex(indexOf(element) - 1), getNodeByIndex(indexOf(element)));
        removeNode.next = null;
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E element) {
        Node<E> temp = getLastNode();
        return temp.data.equals(element);
    }

    @Override
    public int indexOf(E element) {
        int count = 0;
        Node<E> temp = head;
        while (!temp.data.equals(element)) {
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

    private Node<E> getNodeByIndex(int index) {
        checkIndexIsValid(index);
        Node<E> temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp;
    }

    private Node<E> changingTheBondsBetweenNodes(
            Node<E> nodePointsIndicatedNodeByIndex,
            Node<E> indicatedNodeByIndex) {
        nodePointsIndicatedNodeByIndex.next = indicatedNodeByIndex.next;
        return indicatedNodeByIndex;
    }

    private Node<E> getLastNode() {
        Node<E> temp = head;
        while (temp.next != null)
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
