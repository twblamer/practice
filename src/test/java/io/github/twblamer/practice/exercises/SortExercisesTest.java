package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class SortExercisesTest {
    @Test
    public void testInsertionSort() {
        try {
            doAllTests(SortExercises::insertionSort);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void testQuickSelect() {
        var input = new int[] { 5, 1, 6, 2, 3, 4, 5, -1, 100000, 6, 2, 4, 1, 2 };
        // var sorted = new int[] { -1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 5, 6, 6, 100000 };
        int expected;
        int actual;

        expected = 123;
        actual = SortExercises.quickSelect(new int[] { 123 }, 1);
        assertEquals(expected, actual);

        expected = -1;
        actual = SortExercises.quickSelect(input, 1);
        assertEquals(expected, actual);

        expected = 1;
        actual = SortExercises.quickSelect(input, 2);
        assertEquals(expected, actual);

        expected = 3;
        actual = SortExercises.quickSelect(input, 7);
        assertEquals(expected, actual);
    }

    @Test
    public void testQuickSort() {
        try {
            doAllTests(SortExercises::quickSort);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void testMergeSort() {
        try {
            doAllTests(SortExercises::mergeSort);
        } catch (Exception e) {
            fail(e);
        }
    }

    private void doAllTests(Consumer<int[]> sortMethod) throws Exception {
        // empty
        doTest(sortMethod, new int[] {}, new int[] {});

        // single element
        doTest(sortMethod, new int[] { 1 }, new int[] { 1 });

        // sorted
        doTest(sortMethod, new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 });

        // reverse sorted
        doTest(sortMethod, new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 2, 3, 4, 5 });

        // random
        var input = new int[] { 5, 1, 6, 2, 3, 4, 5, -1, 100000, 6, 2, 4, 1, 2 };
        var expected = new int[] { -1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 5, 6, 6, 100000 };
        doTest(sortMethod, input, expected);
    }

    private void doTest(Consumer<int[]> sortMethod, int[] input, int[] expected) throws Exception {
        sortMethod.accept(input);
        assertArrayEquals(expected, input);
    }
}