package dev.pawel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    @Test
    void shouldAddSingleElement() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element = "Test";
        //When
        boolean result = myList.add(element);
        //Then
        assertTrue(result);
        assertEquals(1, myList.size());
        assertTrue(myList.contains(element));
        assertNotNull(myList.get(0));
        assertEquals(element, myList.get(0));
    }
    @Test
    void shouldAddMultipleElement() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Test";
        String element2 = "pen";
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
    }
    @Test
    void shouldResizeArray_whenSizeEqualsCapacity() {
        //Given
        MyList<String> myList = new MyArrayList<>(2);
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        //When
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        //Then
        assertEquals(3, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
    }
    @Test
    void shouldAddMultipleElement_onSpecificIndex() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        //When
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(5, element4);
        //Then
        assertEquals(4, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(element4, myList.get(5));
        System.out.println(myList);
    }
}