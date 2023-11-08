package io.github.twblamer.practice.algorithms;

public class QuickSortMedianOfMedians {
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

        var pivotIndex = selectPivot(a, start, end);
        pivotIndex = partition(a, start, end, pivotIndex);

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

        var pivotIndex = selectPivot(a, start, end);
        pivotIndex = partition(a, start, end, pivotIndex);

        quickSort(a, start, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, end);
    }

    private static int partition(int[] a, int start, int end, int pivotIndex) {
        int pivotValue = a[pivotIndex];

        swap(a, pivotIndex, end);

        int i = start;

        for (int j = start; j < end; j++) {
            if (a[j] <= pivotValue) {
                swap(a, j, i++);
            }
        }

        swap(a, end, i);

        return i;
    }

    private static int selectPivot(int[] a, int start, int end) {
        if (end - start < 5) {
            return findMedian(a, start, end);
        }

        for (int i = start; i <= end; i += 5) {
            int subEnd = Math.min(i + 4, end);
            int median = findMedian(a, i, subEnd);
            swap(a, median, start + (i - start) / 5);
        }

        return quickSelect(a, start, start + (end - start) / 5, start + (end - start) / 10);
    }

    private static int findMedian(int[] a, int start, int end) {
        insertionSortHelper(a, start, end);
        return start + (end - start) / 2;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void insertionSortHelper(int[] arr, int low, int high) {
        // Using insertion sort for small subarrays
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
