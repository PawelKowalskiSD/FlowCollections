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
        Node<E> node = getNodeByIndex(index);
        return node.data;
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
        Node<E> add = changeBondsBetweenNodes(addNode, getNodeByIndex(index - 1));
        add.next = addNode;
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> removeNode = getNodeByIndex(index);
        remove(removeNode.data);
        return removeNode.data;
    }

    @Override
    public boolean remove(E element) {
        Node<E> removeNode =
                changeBondsBetweenNodes(getNodeByIndex(indexOf(element) - 1), getNodeByIndex(indexOf(element)));
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
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(E element) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(element))
                return i;
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public boolean addAll(MyList<E> myList) {
        for (int i = 0; i < myList.size(); i++)
            add(myList.get(i));
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

    private Node<E> changeBondsBetweenNodes(Node<E> firstNode, Node<E> secondNode) {
        firstNode.next = secondNode.next;
        return secondNode;
    }

    private Node<E> getNodeByIndex(int index) {
        checkIndexIsValid(index);
        Node<E> temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp;
    }

    private Node<E> getLastNode() {
        Node<E> temp = head;
        while (temp.next != null)
            temp = temp.next;
        return temp;
    }

    private void checkIndexIsValid(int index) {
        if (index < 0 || index > size)
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
