package dev.pawel.hashmap;

import dev.pawel.MyMap;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Test
    void shouldReturnHashConflict_whenKeyIsDifferentAndHashCodeIsTheSame() {
        //Given
        String robertNowakKeyId = "12";
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = "12222";
        String damianSmithValue = "Damian Smith";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //When
        int getFirstKeyHashCode = myHashMap.entrySet().get(0).getKey().hashCode() % 10;
        int getSecondKeyHashCode = myHashMap.entrySet().get(1).getKey().hashCode() % 10;
        //Then
        assertEquals(2, myHashMap.size());
        assertEquals(getFirstKeyHashCode, getSecondKeyHashCode);
        assertEquals(damianSmithValue, myHashMap.get(damianSmithId));
        assertEquals(robertNowakValue, myHashMap.get(robertNowakKeyId));
    }

    @Test
    void shouldReturnTrue_whenHashMapIsEmpty() {
        //Given
        MyMap<String, String> myHashMap = new MyHashMap<>();
        //When
        boolean isEmpty = myHashMap.isEmpty();
        //then
        assertTrue(isEmpty);
        assertEquals(0, myHashMap.size());
    }

    @Test
    void shouldReturnFalse_whenHashMapIsNotEmpty() {
        //Given
        MyMap<String, String> myHashMap = new MyHashMap<>();
        String robertNowakKeyId = "12";
        String robertNowakValue = "Robert Nowak";
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        //When
        boolean isEmpty = myHashMap.isEmpty();
        //then
        assertFalse(isEmpty);
        assertEquals(1, myHashMap.size());
    }

    @Test
    void shouldReturnTrue_whenFindContainsKey() {
        //Given
        String robertNowakKeyId = "12";
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = "122223131321";
        String damianSmithValue = "Damian Smith";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //When
        boolean isFounded = myHashMap.containsKey(damianSmithId);
        //Then
        assertTrue(isFounded);
        assertEquals(2, myHashMap.size());
    }

    @Test
    void shouldReturnFalse_WhenKeyIsNotFound() {
        //Given
        String robertNowakKeyId = "12";
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = "12222";
        String damianSmithValue = "Damian Smith";
        String adamRooneyId = "12231313131315";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //When
        boolean isFounded = myHashMap.containsKey(adamRooneyId);
        //Then
        assertFalse(isFounded);
        assertEquals(2, myHashMap.size());
    }

    @Test
    void shouldReturnTrue_whenFindContainsValue() {
        //Given
        String robertNowakKeyId = "12";
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = "12222";
        String damianSmithValue = "Damian Smith";
        String adamRooneyValue = "Adam Rooney";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //When
        boolean isFounded = myHashMap.containsValue(adamRooneyValue);
        //Then
        assertFalse(isFounded);
        assertEquals(2, myHashMap.size());
    }

    @Test
    void shouldReturnFalse_WhenValueIsNotFound() {
        //Given
        String robertNowakKeyId = "12";
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = "12222";
        String damianSmithValue = "Damian Smith";
        String adamRooneyValue = "Adam Rooney";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //When
        boolean isFounded = myHashMap.containsValue(adamRooneyValue);
        //Then
        assertFalse(isFounded);
        assertEquals(2, myHashMap.size());
    }

    @Test
    void shouldRemoveByKey() {
        //Given
        String robertNowakKeyId = "12";
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = "12222";
        String damianSmithValue = "Damian Smith";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //When
        String remove = myHashMap.remove(robertNowakKeyId);
        //Then
        assertEquals(1, myHashMap.size());
        assertEquals(robertNowakValue, remove);
    }

    @Test
    void shouldThrowException_WhenRemoveKeyNotExist() {
        //Given
        String robertNowakKeyId = "12";
        String robertNowakValue = "Robert Nowak";
        String damianSmithId = "12222";
        String damianSmithValue = "Damian Smith";
        String adamRooneyId = "12231313131315";
        MyMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(robertNowakKeyId, robertNowakValue);
        myHashMap.put(damianSmithId, damianSmithValue);
        //When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> myHashMap.remove(adamRooneyId));
    }
}