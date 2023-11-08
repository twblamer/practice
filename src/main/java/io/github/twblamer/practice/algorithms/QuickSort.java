package io.github.twblamer.practice.algorithms;

public class QuickSort {
    public static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static int quickSelect(int[] a, int k) {
        return quickSelect(a, 0, a.length - 1, k - 1);
    }

    private static int quickSelect(int[] a, int start, int end, int k) {
        if (start == end) {
            return a[start];
        }

        var pivotIndex = partition(a, start, end);

        if (k == pivotIndex) {
            return a[k];
        } else if (k < pivotIndex) {
            return quickSelect(a, start, pivotIndex - 1, k);
        } else {
            return quickSelect(a, pivotIndex + 1, end, k);
        }
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        var partitionIndex = partition(a, start, end);
        quickSort(a, start, partitionIndex - 1);
        quickSort(a, partitionIndex + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        var pivotValue = a[end];
        var i = start;

        for (int j = start; j < end; j++) {
            if (a[j] <= pivotValue) {
                swap(a, j, i++);
            }
        }

        swap(a, end, i);

        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
