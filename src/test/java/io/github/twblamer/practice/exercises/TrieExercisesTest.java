package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrieExercisesTest {
    private TrieExercises trie;

    @BeforeEach
    public void setUp() {
        trie = new TrieExercises();
    }

    @Test
    public void testInsertAndSearch() {
        trie.insert("hello");
        trie.insert("world");

        assertTrue(trie.search("hello"));
        assertTrue(trie.search("world"));
        assertFalse(trie.search("hell"));
        assertFalse(trie.search("wor"));
        assertFalse(trie.search("helloo"));
    }

    @Test
    public void testStartsWith() {
        trie.insert("hello");
        trie.insert("world");

        assertTrue(trie.startsWith("he"));
        assertTrue(trie.startsWith("wor"));
        assertTrue(trie.startsWith("hell"));
        assertTrue(trie.startsWith("worl"));
        assertFalse(trie.startsWith("helloo"));
        assertFalse(trie.startsWith("o"));
    }
}