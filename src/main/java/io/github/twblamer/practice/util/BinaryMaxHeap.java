package io.github.twblamer.practice.util;

import java.util.Arrays;

/**
 * This is a max-heap (always pops the largest value first).
 * 
 * @see BinaryHeap
 */
public class BinaryMaxHeap extends BinaryHeap {
    public BinaryMaxHeap() {
        super();
    }

    public BinaryMaxHeap(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int newValue) {
        super.add(newValue * -1);
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        return super.peek() * -1;
    }

    @Override
    public int poll() throws IndexOutOfBoundsException {
        return super.poll() * -1;
    }

    @Override
    public int[] toIntArray() {
        return Arrays.stream(super.toIntArray()).map((var x) -> {
            return x * -1;
        }).toArray();
    }
}
