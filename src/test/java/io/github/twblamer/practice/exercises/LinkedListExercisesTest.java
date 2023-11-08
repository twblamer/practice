package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.twblamer.practice.util.Util;

public class LinkedListExercisesTest {
    private LinkedListExercises<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new LinkedListExercises<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);

        var actual = Util.iteratorToList(list.iterator());
        assertEquals(List.of(1, 2, 3), actual);
    }

    @Test
    public void testReverse() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.reverse();

        Iterator<Integer> it = list.iterator();
        var actual = Util.iteratorToList(it);

        assertEquals(List.of(3, 2, 1), actual);
    }

    @Test
    public void testRemove() {
        var actual = list.remove(1);

        assertEquals(false, actual);

        list.add(1);
        actual = list.remove(1);
        assertEquals(true, actual);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(1);
        assertEquals(List.of(2, 3, 4, 5), Util.iteratorToList(list.iterator()));

        list.remove(5);
        assertEquals(List.of(2, 3, 4), Util.iteratorToList(list.iterator()));

        list.remove(3);
        assertEquals(List.of(2, 4), Util.iteratorToList(list.iterator()));

        list.remove(2);
        list.remove(4);

        assertEquals(false, list.iterator().hasNext());
    }
}