package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.twblamer.practice.util.HashTable;

public class HashTableExercisesTest {
    private HashTable<String, Integer> map;

    @BeforeEach
    public void setUp() {
        map = new HashTableExercises<String, Integer>();
    }

    @Test
    public void testPutAndGet() {
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));
    }

    @Test
    public void testSize() {
        assertEquals(0, map.size());

        map.put("one", 1);
        map.put("two", 2);

        assertEquals(2, map.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(map.isEmpty());

        map.put("one", 1);

        assertFalse(map.isEmpty());
    }

    @Test
    public void testContainsKey() {
        assertFalse(map.containsKey("one"));

        map.put("one", 1);

        assertTrue(map.containsKey("one"));
    }

    @Test
    public void testRemove() {
        map.put("one", 1);
        map.put("two", 2);

        assertEquals(1, map.remove("one"));
        assertNull(map.get("one"));
        assertEquals(1, map.size());
    }

    @Test
    public void testClear() {
        map.put("one", 1);
        map.put("two", 2);

        map.clear();

        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }
}