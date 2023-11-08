package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ArrayExercisesTest {
    @Test
    public void testBinarySearch() {
        int[] a = new int[] { 2, 4, 5, 6, 7, 8, 10, 11, 14, 15, 17, 19, 23, 27, 31, 33, 38, 42, 46, 50 };

        assertTrue(ArrayExercises.binarySearch(a, 10));
        assertTrue(ArrayExercises.binarySearch(a, 2));
        assertTrue(ArrayExercises.binarySearch(a, 50));
        assertTrue(ArrayExercises.binarySearch(a, 4));
        assertTrue(ArrayExercises.binarySearch(a, 46));
        assertFalse(ArrayExercises.binarySearch(a, 0));
        assertFalse(ArrayExercises.binarySearch(a, 51));
    }

    @Test
    public void testMajorityElement() {
        int[] a;
        int expected, actual;

        a = new int[] { 3, 2, 3 };
        expected = 3;
        actual = ArrayExercises.majorityElement(a);
        assertEquals(expected, actual);

        a = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        expected = 2;
        actual = ArrayExercises.majorityElement(a);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumSubarraySum() {
        int[] a;
        int expected, actual;

        a = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        expected = 6;
        actual = ArrayExercises.maximumSubarraySum(a);
        assertEquals(expected, actual);

        a = new int[] { 66 };
        expected = 66;
        actual = ArrayExercises.maximumSubarraySum(a);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumSubarrayProduct() {
        int[] a;
        int expected, actual;

        a = new int[] { 2, 3, -2, 4 };
        expected = 6;
        actual = ArrayExercises.maximumSubarrayProduct(a);
        assertEquals(expected, actual);

        a = new int[] { -2, 0, -1 };
        expected = 0;
        actual = ArrayExercises.maximumSubarrayProduct(a);
        assertEquals(expected, actual);
    }
}
