package io.github.twblamer.practice.exercises;

import io.github.twblamer.practice.algorithms.ArrayAlgorithms;

/**
 * @see ArrayExercisesTest
 */
public class ArrayExercises {
    //
    // Start here
    //
    public static boolean binarySearch(int[] a, int value) {
        return ArrayAlgorithms.binarySearch(a, value);
    }

    public static int majorityElement(int[] a) {
        return ArrayAlgorithms.majorityElement(a);
    }

    public static int maximumSubarrayProduct(int[] a) {
        return ArrayAlgorithms.maximumSubarrayProduct(a);
    }

    public static int maximumSubarraySum(int[] a) {
        return ArrayAlgorithms.maximumSubarraySum(a);
    }
}