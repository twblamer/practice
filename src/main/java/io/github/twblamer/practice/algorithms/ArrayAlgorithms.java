package io.github.twblamer.practice.algorithms;

/**
 * This class contains various algorithms related to arrays.
 */
public class ArrayAlgorithms {

    /**
     * Searches for a value in a sorted array using binary search.
     *
     * @param a     the sorted array to search in
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
    public static boolean binarySearch(int[] a, int value) {
        int start = 0, end = a.length - 1, m;

        while (end >= start) {
            m = start + (end - start) / 2;
            if (a[m] == value) {
                return true;
            } else if (a[m] > value) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }

        return false;
    }

    /**
     * Finds the majority element in an array.
     *
     * @param a the array to search in
     * @return the majority element
     */
    public static int majorityElement(int[] a) {
        int result = a[0];
        int count = 1;

        for (int i = 1; i < a.length; i++) {
            if (count == 0) {
                result = a[i];
            }

            if (a[i] == result) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }

    /**
     * Finds the maximum product of a subarray in an array.
     *
     * @param a the array to search in
     * @return the maximum product of a subarray
     */
    public static int maximumSubarrayProduct(int[] a) {
        int result = a[0];
        int curMax = a[0];
        int curMin = a[0];

        for (int i = 1; i < a.length; i++) {
            var tmp = curMax;

            curMax = Math.max(a[i], Math.max(a[i] * tmp, a[i] * curMin));
            curMin = Math.min(a[i], Math.min(a[i] * tmp, a[i] * curMin));
            result = Math.max(result, Math.max(curMin, curMax));
        }

        return result;
    }

    /**
     * Finds the maximum sum of a subarray in an array.
     *
     * @param a the array to search in
     * @return the maximum sum of a subarray
     */
    public static int maximumSubarraySum(int[] a) {
        int maxSum = a[0];
        int curSum = a[0];

        for (int i = 1; i < a.length; i++) {
            curSum = Math.max(curSum + a[i], a[i]);
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }
}
