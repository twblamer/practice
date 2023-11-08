package io.github.twblamer.practice.exercises;

import java.util.LinkedList;

import io.github.twblamer.practice.util.HashTable;

/**
 * @see HashTableExercisesTest
 */
public class HashTableExercises<K, V> extends HashTable<K, V> {
    // set this to a low value to verify the resize logic
    private static int DEFAULT_INITIAL_CAPACITY = 16;

    // protected int size = 0;
    // protected LinkedList<Entry<K, V>>[] table;

    // protected static class Entry<K, V>

    public HashTableExercises() {
        super(DEFAULT_INITIAL_CAPACITY);
    }

    public HashTableExercises(int capacity) {
        super(capacity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        table = new LinkedList[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    //
    // Start here
    //
    @Override
    public void put(K key, V value) {
        super.put(key, value);
    }

    @Override
    public V get(K key) {
        return super.get(key);
    }

    @Override
    public V remove(K key) {
        return super.remove(key);
    }

    @Override
    public boolean containsKey(K key) {
        return super.containsKey(key);
    }
}
