package io.github.twblamer.practice.algorithms;

import java.util.Arrays;

public class MergeSort {

    /**
     * Sorts the given array of integers in ascending order using the bottom-up
     * merge sort algorithm.
     *
     * @param a the array of integers to be sorted
     */
    public static void sort(int[] a) {
        if (a.length <= 1) {
            return;
        }

        int[] tmp = new int[a.length];

        for (int step = 1; step < a.length; step *= 2) {
            for (int start = 0; start < a.length; start += 2 * step) {
                int mid = Math.min(start + step, a.length);
                int end = Math.min(start + 2 * step, a.length);
                int i = start, j = mid, tmpIndex = start;

                while (i < mid && j < end) {
                    if (a[i] <= a[j]) {
                        tmp[tmpIndex++] = a[i++];
                    } else {
                        tmp[tmpIndex++] = a[j++];
                    }
                }

                while (i < mid) {
                    tmp[tmpIndex++] = a[i++];
                }

                while (j < end) {
                    tmp[tmpIndex++] = a[j++];
                }
            }

            // Copy the sorted segments from tmp back to a
            for (int i = 0; i < a.length; i++) {
                a[i] = tmp[i];
            }
        }
    }

    /**
     * Top-down merge sort algorithm included for learning purposes.
     * 
     * @see <a href="https://www.baeldung.com/java-merge-sort">Baeldung: Merge Sort
     *      in Java</a>
     * 
     * @param a the array of integers to be sorted
     */
    public static void topDownSort(int[] a) {
        // https://www.baeldung.com/java-merge-sort
        var n = a.length;

        if (n < 2) {
            return;
        }

        var mid = n / 2;
        int[] l = Arrays.copyOf(a, mid);
        int[] r = Arrays.copyOfRange(a, mid, n);
        topDownSort(l);
        topDownSort(r);

        topDownMerge(a, l, r);
    }

    private static void topDownMerge(int[] a, int[] l, int[] r) {
        int llen = l.length, rlen = r.length;
        int i = 0, j = 0, k = 0;

        while (i < llen && j < rlen) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < llen) {
            a[k++] = l[i++];
        }

        while (j < rlen) {
            a[k++] = r[j++];
        }
    }
}
