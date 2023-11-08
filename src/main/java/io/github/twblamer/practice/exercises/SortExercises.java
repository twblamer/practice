package io.github.twblamer.practice.exercises;

import io.github.twblamer.practice.algorithms.InsertionSort;
import io.github.twblamer.practice.algorithms.MergeSort;
import io.github.twblamer.practice.algorithms.QuickSort;

/**
 * @see SortExercisesTest
 */
public class SortExercises {
    //
    // Start here
    //
    public static void insertionSort(int[] nums) {
        InsertionSort.sort(nums);
    }

    public static void mergeSort(int[] a) {
        MergeSort.sort(a);
    }

    public static int quickSelect(int[] a, int k) {
        return QuickSort.quickSelect(a, k);
    }

    public static void quickSort(int[] a) {
        QuickSort.sort(a);
    }
}
