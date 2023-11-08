package io.github.twblamer.practice.util;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This is a min-heap (always pops the smallest value first).
 * 
 * @see BinaryMaxHeap
 */
public class BinaryHeap {
    protected int[] a;
    protected int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 100;

    public BinaryHeap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        this.a = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void add(int newValue) {
        if (size >= a.length) {
            a = Arrays.copyOf(a, a.length * 2);
        }

        a[size++] = newValue;

        heapifyUp();
    }

    public int peek() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return a[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        var out = a[0];

        a[0] = a[size - 1];
        size--;
        heapifyDown(0);

        return out;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        var tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void heapifyDown(int i) {
        var leftIndex = left(i);
        var rightIndex = right(i);

        while (leftIndex < size) {
            var largest = i;

            if (a[leftIndex] < a[largest]) {
                largest = leftIndex;
            }

            if (rightIndex < size && a[rightIndex] < a[largest]) {
                largest = rightIndex;
            }

            if (largest == i) {
                break;
            }

            swap(i, largest);
            i = largest;
            leftIndex = left(i);
            rightIndex = right(i);
        }
    }

    private void heapifyUp() {
        int i = size - 1;
        var parentIndex = parent(i);

        while (i > 0 && a[parentIndex] > a[i]) {
            swap(i, parentIndex);
            i = parentIndex;
            parentIndex = parent(i);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toIntArray());
    }

    public int[] toIntArray() {
        return Arrays.copyOf(a, size);
    }

    protected static <T extends BinaryHeap> T fromArrayHelper(int[] a, Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);

            var out = constructor.newInstance(a.length);
            var n = a.length;
            out.a = a;
            out.size = n;

            for (int i = (n / 2) - 1; i >= 0; i--) {
                ((BinaryHeap) out).heapifyDown(i);
            }

            return out;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static BinaryHeap fromArray(int[] a) {
        return fromArrayHelper(a, BinaryHeap.class);
    }
}
