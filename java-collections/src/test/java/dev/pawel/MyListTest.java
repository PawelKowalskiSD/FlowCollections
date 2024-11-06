package dev.pawel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    @Test
    void shouldCreateNewList() {
        //Given
        String element1 = "Damian";
        String element2 = "Roman";
        String element3 = "Waldemar";
        //When
        MyList<String> myList = MyList.of(element1, element2, element3);
        //Then
        assertEquals(3, myList.size());
        assertEquals(element1, myList.get(0));
        assertEquals(element2, myList.get(1));
        assertEquals(element3, myList.get(2));
        assertEquals(0, myList.indexOf(element1));
        assertEquals(1, myList.indexOf(element2));
        assertEquals(2, myList.indexOf(element3));
    }
}