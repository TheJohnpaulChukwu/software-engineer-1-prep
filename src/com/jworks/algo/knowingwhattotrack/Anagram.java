package com.jworks.algo.knowingwhattotrack;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

    /**
     * Determines if two strings are anagrams of each other.
     *
     * Approach:
     * 1. If the lengths of the two strings are not equal, they cannot be anagrams, so return false.
     * 2. Use a HashMap to keep track of the frequency of each character in the first string (str1).
     *    - Increment the count for each character in str1.
     * 3. Traverse through the second string (str2) and decrement the count for each character found in the map.
     * 4. Finally, check the values in the map:
     *    - If all values are zero, the strings are anagrams.
     *    - If any value is non-zero, the strings are not anagrams.
     *
     * Time Complexity: O(n), where n is the length of the strings.
     * Space Complexity: O(1), as the HashMap will only contain up to 26 entries (for lowercase English letters).
     *
     * @param str1 the first string
     * @param str2 the second string
     * @return true if str2 is an anagram of str1, false otherwise
     */
    public static boolean isAnagram(String str1, String str2) {

        HashMap<Character, Integer> wordCountMap = new HashMap<>();

        if (str1.length() != str2.length()) return false;

        for (char character : str1.toCharArray()) {
            wordCountMap.put(character, wordCountMap.getOrDefault(character, 0) + 1);
        }

        for (char character : str2.toCharArray()) {
            if (wordCountMap.containsKey(character)) {
                wordCountMap.put(character, wordCountMap.get(character) - 1);
            }
        }

        return wordCountMap.values().stream()
                .mapToInt(count -> count)
                .noneMatch(count -> count != 0);
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
                {"listen", "silent"},  // Expected: true
                {"anagram", "nagaram"}, // Expected: true
                {"rat", "car"},         // Expected: false
                {"hello", "oellh"},     // Expected: true
                {"test", "sett"},       // Expected: true
                {"apple", "ppale"},     // Expected: false
        };

        // Test the function with sample test cases
        System.out.println("Testing Anagram Function:");
        for (String[] testCase : testCases) {
            String str1 = testCase[0];
            String str2 = testCase[1];
            boolean expected = isExpectedAnagram(str1, str2); // Helper for expected result
            boolean actual = isAnagram(str1, str2);
            System.out.printf(
                    "Test Case: str1 = \"%s\", str2 = \"%s\" | Expected: %b, Actual: %b | %s\n",
                    str1, str2, expected, actual, (expected == actual) ? "PASSED" : "FAILED"
            );
        }
    }

    // Helper function to derive expected result (for demonstration purposes)
    private static boolean isExpectedAnagram(String str1, String str2) {
        // Sort and compare for expected value
        char[] sortedStr1 = str1.toCharArray();
        char[] sortedStr2 = str2.toCharArray();
        Arrays.sort(sortedStr1);
        Arrays.sort(sortedStr2);
        return Arrays.equals(sortedStr1, sortedStr2);
    }
}
