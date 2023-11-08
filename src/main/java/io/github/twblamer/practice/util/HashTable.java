package io.github.twblamer.practice.util;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    protected int size = 0;
    protected LinkedList<Entry<K, V>>[] table;

    protected static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int initialCapacity;

    public HashTable() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        initialCapacity = capacity;
        table = new LinkedList[capacity];
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        table = new LinkedList[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }

        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;

        if (size > table.length * LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[oldTable.length * 2];
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldTable) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public V remove(K key) {
        int index = getIndex(key);

        if (table[index] != null) {
            Iterator<Entry<K, V>> iterator = table[index].iterator();

            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();

                if (entry.key.equals(key)) {
                    V removedValue = entry.value;
                    iterator.remove();
                    size--;

                    return removedValue;
                }
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }
}
