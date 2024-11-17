package dev.pawel;

import dev.pawel.linkedlist.MyLinkedList;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList myList = new MyLinkedList();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        System.out.println(myList);
        System.out.println(myList.size());
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));

        MyList myList2 = new MyLinkedList();
        myList2.add("str");
        myList2.add("str");
        myList2.add("str");
        myList2.add("str");
        System.out.println(myList2);
        System.out.println(myList2.size());
    }
}
