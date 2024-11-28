package dev.pawel.linkedlist;

import dev.pawel.MyList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @Test
    void shouldAddMultipleElement() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Roman";
        String element2 = "Tomek";
        String element3 = "Pawel";
        String element4 = "Damian";
        //When
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //Then
        assertEquals(4, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(element4, myList.get(3));
        assertEquals(0, myList.indexOf(element1));
        assertEquals(1, myList.indexOf(element2));
        assertEquals(2, myList.indexOf(element3));
        assertEquals(3, myList.indexOf(element4));
    }

    @Test
    void shouldAddMultipleElement_onSpecificIndex() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        //When
        myList.add(1, element4);
        //Then
        assertEquals(4, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element4, myList.get(1));
        assertEquals(element2, myList.get(2));
        assertEquals(element3, myList.get(3));
    }

    @Test
    void shouldSetValueByIndex() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Roman";
        String element2 = "Tomek";
        String element3 = "Pawel";
        String element4 = "Damian";
        String element5 = "Alan";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When
        myList.set(2, element5);
        //Then
        assertEquals(4, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element5, myList.get(2));
        assertEquals(element4, myList.get(3));
        assertEquals(0, myList.indexOf(element1));
        assertEquals(1, myList.indexOf(element2));
        assertEquals(2, myList.indexOf(element5));
        assertEquals(3, myList.indexOf(element4));
    }

    @Test
    void shouldReturnFalse_WhenContainsElementNotEquals() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        String element5 = "David";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When
        boolean result = myList.contains(element5);
        //Then
        assertFalse(result);
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(element4, myList.get(3));
    }

    @Test
    void shouldReturnTrue_WhenContainsElementExists() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        String element5 = "David";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        myList.add(element5);
        //When
        boolean result = myList.contains(element5);
        //Then
        assertTrue(result);
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(element4, myList.get(3));
        assertEquals(element5, myList.get(4));
    }

    @Test
    void shouldRemoveElementByIndex() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When
        myList.remove(1);
        //Then
        assertEquals(3, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element3, myList.get(1));
        assertEquals(element4, myList.get(2));
        System.out.println(myList);
    }

    @Test
    void shouldRemoveElement() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When
        boolean result = myList.remove("pen");
        //Then
        assertTrue(result);
        assertEquals(3, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element3, myList.get(1));
        assertEquals(element4, myList.get(2));
    }

    @Test
    void shouldAddAllElements_fromOneArrayToSecond() {
        //Given
        MyList<String> myFirstList = new MyLinkedList<>();
        MyList<String> mySecondList = new MyLinkedList<>();
        String element1 = "Roman";
        String element2 = "Tomek";
        String element3 = "Pawel";
        String element4 = "Damian";
        String element5 = "Wojtek";
        String element6 = "Stefan";
        myFirstList.add(element1);
        myFirstList.add(element2);
        myFirstList.add(element3);
        myFirstList.add(element4);
        mySecondList.add(element5);
        mySecondList.add(element6);
        //When
        boolean result = myFirstList.addAll(mySecondList);
        //Then
        assertTrue(result);
        assertEquals(6, myFirstList.size());
        assertEquals(element1, myFirstList.get(0));
        assertEquals(element2, myFirstList.get(1));
        assertEquals(element3, myFirstList.get(2));
        assertEquals(element4, myFirstList.get(3));
        assertEquals(element5, myFirstList.get(4));
        assertEquals(element6, myFirstList.get(5));
        assertEquals(0, myFirstList.indexOf(element1));
        assertEquals(1, myFirstList.indexOf(element2));
        assertEquals(2, myFirstList.indexOf(element3));
        assertEquals(3, myFirstList.indexOf(element4));
        assertEquals(4, myFirstList.indexOf(element5));
        assertEquals(5, myFirstList.indexOf(element6));
    }

    @Test
    void shouldNotSetSingleElement_whenIndexIsNotExists() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Roman";
        String element2 = "Tomek";
        String element3 = "Pawel";
        String element4 = "Damian";
        String element5 = "Alan";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> myList.set(4, element5));
    }

    @Test
    void shouldNotGetSingleElement_whenIndexIsNotExists() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Roman";
        String element2 = "Tomek";
        String element3 = "Pawel";
        String element4 = "Damian";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(4));
    }

    @Test
    void shouldNotAddSingleElement_onSpecificIndex_WhenIndexIsGreaterThanSize() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Roman";
        //When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(1, element1));
        assertEquals(0, myList.size());
    }

    @Test
    void shouldNotAddSingleElement_onSpecificIndex_WhenIndexIsLowerThanZero() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Roman";
        //When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(-1, element1));
        assertEquals(0, myList.size());
    }

    @Test
    void shouldThrowException_whenIndexIsLessThanZero() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.remove(-2);
        });
        assertEquals(4, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(element4, myList.get(3));
    }

    @Test
    void shouldReturnMinusOne_WhenIndexOfElementNotExists() {
        //Given
        MyList<String> myList = new MyLinkedList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        //When
        int result = myList.indexOf(element4);
        //Then
        assertEquals(3, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(-1, result);
    }
}