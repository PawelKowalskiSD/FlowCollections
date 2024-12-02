package dev.pawel.hashmap;

import dev.pawel.MyMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    @Test
    void shouldPutElementToHashMap() {
        //Given
        String RobertNowakKeyId = "23191";
        String robertNowakValue = "Robert Nowak";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        //When
        myHashMap.put(RobertNowakKeyId, robertNowakValue);
        //Then
        assertEquals(robertNowakValue, myHashMap.get(RobertNowakKeyId));
    }
    @Test
    void shouldPutMultipleElementsToHashMap() {
        //Given
        String robertNowakKeyId = "23191";
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = "231313";
        String damianSmithValue = "Damian Smith";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        //When
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //Then
        assertEquals(robertNowakValue, myHashMap.get(robertNowakKeyId));
        assertEquals(damianSmithValue, myHashMap.get(damianSmithId));
    }

    @Test
    void shouldPutElementsToHashMap_whenKeyIsNull() {
        //Given
        String robertNowakKeyId = null;
        String robertNowakValue = "Robert Nowak";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        //When
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        //Then
        assertEquals(robertNowakValue, myHashMap.get(robertNowakKeyId));
    }

    @Test
    void shouldOverride_whenPutMultipleKeyNullElementsToHashMap() {
        //Given
        String robertNowakKeyId = null;
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = null;
        String damianSmithValue = "Damian Smith";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        //When
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //Then
        assertEquals(1, myHashMap.size());
        assertEquals(damianSmithValue, myHashMap.get(damianSmithId));
    }

}