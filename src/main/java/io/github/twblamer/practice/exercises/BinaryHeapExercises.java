package io.github.twblamer.practice.exercises;

import java.util.NoSuchElementException;

import io.github.twblamer.practice.util.BinaryHeap;

/**
 * @see BinaryHeapExercisesTest
 */
public class BinaryHeapExercises extends BinaryHeap {
    // set this to a low value to verify the resize logic
    private static int DEFAULT_INITIAL_CAPACITY = 1;

    // protected int[] a;
    // protected int size;

    public BinaryHeapExercises() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public BinaryHeapExercises(int capacity) {
        super(capacity);
    }

    //
    // Start here
    //
    @Override
    public void add(int newValue) {
        super.add(newValue);
    }

    @Override
    public int peek() throws NoSuchElementException {
        return super.peek();
    }

    @Override
    public int poll() throws NoSuchElementException {
        return super.poll();
    }

    // Replace this implementation too
    public static BinaryHeapExercises fromArray(int[] a) {
        return BinaryHeap.fromArrayHelper(a, BinaryHeapExercises.class);
    }
}
