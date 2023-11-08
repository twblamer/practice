package io.github.twblamer.practice.exercises;

import java.util.Iterator;

import io.github.twblamer.practice.util.BinaryTreeNode;

/**
 * @see BinaryTreeExercisesTest
 */
public class BinaryTreeExercises extends BinaryTreeNode {
    public BinaryTreeExercises(int val) {
        this.value = val;
    }

    public BinaryTreeExercises(int val, BinaryTreeExercises left, BinaryTreeExercises right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    //
    // Start here
    //
    @Override
    public boolean binarySearch(int value) {
        return super.binarySearch(value);
    }

    // Replace this implementation too
    public static BinaryTreeExercises fromArray(int[] a) {
        return (BinaryTreeExercises) BinaryTreeNode.fromArrayHelper(a, BinaryTreeExercises::new);
    }

    @Override
    public void invert() {
        super.invert();
    }

    @Override
    public Iterator<Integer> bfs() {
        return super.bfs();
    }

    @Override
    public Iterator<Integer> dfs(TraversalOrder order) {
        return super.dfs(order);
    }
}
