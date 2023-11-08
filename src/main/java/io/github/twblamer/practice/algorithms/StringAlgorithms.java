package io.github.twblamer.practice.algorithms;

import java.util.HashSet;

public class StringAlgorithms {
    public static String longestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;
        HashSet<Character> charSet = new HashSet<>();
        String longestSubstring = "";

        while (end < s.length()) {
            char currentChar = s.charAt(end);

            if (!charSet.contains(currentChar)) {
                charSet.add(currentChar);
                end++;

                if (end - start > maxLength) {
                    maxLength = end - start;
                    longestSubstring = s.substring(start, end);
                }
            } else {
                charSet.remove(s.charAt(start));
                start++;
            }
        }

        return longestSubstring;
    }
}
