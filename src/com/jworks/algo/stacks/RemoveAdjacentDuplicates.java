package com.jworks.algo.stacks;

import java.util.*;

public class RemoveAdjacentDuplicates {


    /*You are given a string consisting of lowercase English letters.
    Repeatedly remove adjacent duplicate letters, one pair at a time.
     Both members of a pair of adjacent duplicate letters need to be removed.

     example:

     abccba
    */

    public static void main(String[] args) {
        // Define test cases: input string and expected output
        String[][] testCases = {
                {"abbaca", "ca"}, // Simple cascade removal
                {"aaaa", ""}, // All characters removed
                {"aabcca", "b"}, // Nested duplicates
                {"abc", "abc"}, // No duplicates
                {"abccba", ""}, // Complete cascade removal
                {"a", "a"}, // Single character
                {"", ""}, // Empty string
                {"aabbaacc", ""}, // Multiple duplicate pairs
                {"abba", ""}, // Mirror-like duplicates
                {"aaabccddd", "abd"}, // Complex case with interleaved duplicates
        };

//        String[][] testCases = {
//                {"aabcca", "b"}, // Nested duplicates
//        };

        // Track passed and failed cases
        int passed = 0;
        int failed = 0;

        // Iterate through test cases
        for (String[] testCase : testCases) {
            String input = testCase[0];
            String expected = testCase[1];
            String actual = removeDuplicates(input);

            // Check if test passed or failed
            if (actual.equals(expected)) {
                System.out.println("Test Passed: Input: \"" + input + "\" -> Expected: \"" + expected + "\", Actual: \"" + actual + "\"");
                passed++;
            } else {
                System.out.println("Test Failed: Input: \"" + input + "\" -> Expected: \"" + expected + "\", Actual: \"" + actual + "\"");
                failed++;
            }
        }

        // Print summary
        System.out.println("\nSummary: " + passed + " Passed, " + failed + " Failed");
    }

//    public static String removeDuplicatesNaive(String word) {
//        boolean hasDuplicates = true;
//
//        while (hasDuplicates) {
//            hasDuplicates = false;
//            StringBuilder newWord = new StringBuilder();
//
//            for (int i = 0; i < word.length(); i++) {
//                // Check if adjacent characters are duplicates
//                if (i < word.length() - 1 && word.charAt(i) == word.charAt(i + 1)) {
//                    hasDuplicates = true; // Found duplicates
//                    i++; // Skip the next character as well
//                } else {
//                    // Add to newWord only if it's not part of a duplicate
//                    newWord.append(word.charAt(i));
//                }
//            }
//
//            // Update the word for the next pass
//            word = newWord.toString();
//        }
//
//        return word;
//    }


//    public static String removeDuplicatesNaive(String s) {
//        boolean hasDuplicates = true;
//
//        // Continue looping until no adjacent duplicates are found
//        while (hasDuplicates) {
//            hasDuplicates = false;
//            StringBuilder sb = new StringBuilder();
//
//            int i = 0;
//            while (i < s.length()) {
//                // Check if the current character and the next one are the same
//                if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
//                    // Skip both characters
//                    hasDuplicates = true;
//                    i += 2;
//                } else {
//                    // Append the current character
//                    sb.append(s.charAt(i));
//                    i++;
//                }
//            }
//
//            // Update the string for the next iteration
//            s = sb.toString();
//        }
//
//        return s;
//    }


//    public static String removeDuplicatesNaive(String s) {
//        Map<Character, Integer> charCount = new HashMap<>();
//
//        // First pass: Count the occurrences of each character
//        for (char c : s.toCharArray()) {
//            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        // Second pass: Build the result string with unique characters
//        for (char c : s.toCharArray()) {
//            if (charCount.get(c) == 1) {
//                sb.append(c);
//            }
//        }
//
//        return sb.toString();
//    }

    public static String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
