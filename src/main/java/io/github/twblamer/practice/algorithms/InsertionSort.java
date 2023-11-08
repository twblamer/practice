package io.github.twblamer.practice.algorithms;

public class InsertionSort {
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            var current = nums[i];
            var j = i - 1;

            while (j >= 0 && nums[j] > current) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = current;
        }
    }
}
