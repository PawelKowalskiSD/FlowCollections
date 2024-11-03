package dev.pawel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void shouldAddSingleElement() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Roman";
        //When
        boolean result = myList.add(element1);
        //Then
        assertTrue(result);
        assertEquals(1, myList.size());
        assertTrue(myList.contains(element1));
        assertNotNull(myList.get(0));
        assertEquals(element1, myList.get(0));
    }

    @Test
    void shouldAddMultipleElement() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
    void shouldAddSingleElement_onSpecificIndex() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Roman";
        //When
        myList.add(0, element1);
        //Then
        assertEquals(1, myList.size());
        assertTrue(myList.contains(element1));
        assertNotNull(myList.get(0));
        assertEquals(element1, myList.get(0));
    }

    @Test
    void shouldNotAddSingleElement_onSpecificIndex_WhenIndexIsGreaterThanSize() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Roman";
        //When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(1, element1));
        assertEquals(0, myList.size());
    }

    @Test
    void shouldNotAddSingleElement_onSpecificIndex_WhenIndexIsLowerThanZero() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Roman";
        //When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(-1, element1));
        assertEquals(0, myList.size());
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
        myList.add(1, element4);
        //Then
        assertEquals(4, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element4, myList.get(1));
        assertEquals(element2, myList.get(2));
        assertEquals(element3, myList.get(3));
        System.out.println(myList);
    }

    @Test
    void shouldRemoveElementByIndex() {
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
        myList.remove("pen");
        //Then
        assertEquals(3, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element3, myList.get(1));
        assertEquals(element4, myList.get(2));
        System.out.println(myList);
    }
}