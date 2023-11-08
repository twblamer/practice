package io.github.twblamer.practice.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringExercisesTest {
    @Test
    public void testLongestSubstringWithoutRepeatingCharacters() {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5 = "a";
        String s6 = "ab";
        String s7 = "aab";
        String s8 = "abb";
        String s9 = "abcbadef";

        assertEquals("abc", StringExercises.longestSubstringWithoutRepeatingCharacters(s1));
        assertEquals("b", StringExercises.longestSubstringWithoutRepeatingCharacters(s2));
        assertEquals("wke", StringExercises.longestSubstringWithoutRepeatingCharacters(s3));
        assertEquals("", StringExercises.longestSubstringWithoutRepeatingCharacters(s4));
        assertEquals("a", StringExercises.longestSubstringWithoutRepeatingCharacters(s5));
        assertEquals("ab", StringExercises.longestSubstringWithoutRepeatingCharacters(s6));
        assertEquals("ab", StringExercises.longestSubstringWithoutRepeatingCharacters(s7));
        assertEquals("ab", StringExercises.longestSubstringWithoutRepeatingCharacters(s8));
        assertEquals("cbadef", StringExercises.longestSubstringWithoutRepeatingCharacters(s9));
    }
}