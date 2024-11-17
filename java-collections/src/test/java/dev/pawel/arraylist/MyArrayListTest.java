package dev.pawel.arraylist;

import dev.pawel.MyList;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void shouldConvertMyListToMyArrayList() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Damian";
        String element2 = "Roman";
        String element3 = "Waldemar";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        //When
        MyArrayList<String> myArrayList = new MyArrayList<>(myList);
        //Then
        assertEquals(3, myArrayList.size());
        assertEquals(element1, myArrayList.get(0));
        assertEquals(element2, myArrayList.get(1));
        assertEquals(element3, myArrayList.get(2));
        assertEquals(0, myArrayList.indexOf(element1));
        assertEquals(1, myArrayList.indexOf(element2));
        assertEquals(2, myArrayList.indexOf(element3));
    }

    @Test
    void shouldGetSingleElement() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Roman";
        String element2 = "Tomek";
        String element3 = "Pawel";
        String element4 = "Damian";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When
        String getElement3 = myList.get(2);
        //Then
        assertEquals(4, myList.size());
        assertEquals(element3, getElement3);
        assertEquals(2, myList.indexOf(getElement3));
    }

    @Test
    void shouldNotGetSingleElement_whenIndexIsNotExists() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
    void shouldSetValueByIndex() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
    void shouldNotSetSingleElement_whenIndexIsNotExists() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
    void shouldAddAllElements_fromOneArrayToSecond() {
        //Given
        MyList<String> myFirstList = new MyArrayList<>();
        MyList<String> mySecondList = new MyArrayList<>();
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
    void shouldReturnFalse_whenAddEmptyListToFirstList() {
        //Given
        MyList<String> myFirstList = new MyArrayList<>();
        MyList<String> mySecondList = new MyArrayList<>();
        String element1 = "Roman";
        String element2 = "Tomek";
        String element3 = "Pawel";
        String element4 = "Damian";
        myFirstList.add(element1);
        myFirstList.add(element2);
        myFirstList.add(element3);
        myFirstList.add(element4);
        //When
        boolean result = myFirstList.addAll(mySecondList);
        //Then
        assertEquals(4, myFirstList.size());
        assertEquals(element1, myFirstList.get(0));
        assertEquals(element2, myFirstList.get(1));
        assertEquals(element3, myFirstList.get(2));
        assertEquals(element4, myFirstList.get(3));
        assertEquals(0, myFirstList.indexOf(element1));
        assertEquals(1, myFirstList.indexOf(element2));
        assertEquals(2, myFirstList.indexOf(element3));
        assertEquals(3, myFirstList.indexOf(element4));
        assertFalse(result);
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
    void shouldRemoveElementByIndex() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
    }

    @Test
    void shouldThrowException_whenIndexIsGreaterThanSize() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
            myList.remove(4);
        });
        assertEquals(4, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(element4, myList.get(3));
    }

    @Test
    void shouldThrowException_whenIndexIsLessThanZero() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
    void shouldRemoveElement() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
    void shouldNotRemoveElement() {
        //Given
        MyList<String> myList = new MyArrayList<>();
        String element1 = "Test";
        String element2 = "pen";
        String element3 = "Pawel";
        String element4 = "Damian";
        myList.add(element1);
        myList.add(element2);
        myList.add(element3);
        myList.add(element4);
        //When
        boolean result = myList.remove("milk");
        //Then
        assertFalse(result);
        assertEquals(4, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(element4, myList.get(3));
    }

    @Test
    void shouldReturnFalse_WhenContainsElementNotEquals() {
        //Given
        MyList<String> myList = new MyArrayList<>();
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
}