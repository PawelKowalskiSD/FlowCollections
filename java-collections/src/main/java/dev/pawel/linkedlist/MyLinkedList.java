package dev.pawel.linkedlist;

import dev.pawel.MyList;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private final static int DEFAULT_SIZE = 0;
    private int size = 0;

    public MyLinkedList() {
        this.head = null;
        size = DEFAULT_SIZE;
    }


    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
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
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
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
        Node<E> findPrevNode = getNode(index - 1);
        Node<E> removeNode = getNode(index);
        findPrevNode.next = removeNode.next;
        removeNode.next = null;
        size--;
        return removeNode.data;
    }

    @Override
    public boolean remove(E element) {
        Node<E> prevElement = getNode(indexOf(element) - 1);
        Node<E> removeElement = getNode(indexOf(element));
        prevElement.next = removeElement.next;
        removeElement.next = null;
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E element) {
        Node<E> temp = head;
        while (!temp.data.equals(element) && temp.next != null)
            temp = temp.next;
        return temp.data.equals(element) || temp.next != null;
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
        int count = 1;
        StringBuilder result = new StringBuilder();
        Node<E> temp = head;
        while (count <= size && temp != null) {
            if (count != size & temp.next != null)
                result.append(temp).append(", ");
            else
                result.append(temp);
            count++;
            temp = temp.next;
        }
        return "[" + result + "]";
    }

    private Node<E> getNode(int index) {
        Node<E> temp = head;
        if (index < 0 || index > size)
            throw new NullPointerException();
        else {
            for (int i = 0; i < index; i++)
                temp = temp.next;
        }
        return temp;
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

