package com.jworks.algo.knowingwhattotrack;

import java.util.HashMap;

public class FirstUniqueCharacter {

    /**
     * Finds the index of the first non-repeating character in a given string.
     *
     * Approach:
     * 1. Use a HashMap to count the occurrences of each character in the string.
     *    - Traverse the string and update the frequency of each character in the map.
     * 2. Iterate through the string a second time.
     *    - For each character, check if its frequency in the map is 1.
     *    - If found, return the index of the first such character.
     * 3. If no unique character is found, return -1.
     *
     * Time Complexity:
     * - Building the frequency map: O(n), where n is the length of the string.
     * - Second traversal to find the first unique character: O(n).
     * - Overall: O(n).
     *
     * Space Complexity:
     * - O(1) as the HashMap stores at most 26 entries (for lowercase English letters).
     *
     * @param word the input string
     * @return the index of the first non-repeating character, or -1 if none exists
     */
    public static int firstUniqueChar(String word) {
        HashMap<Character, Integer> wordCountMap = new HashMap<>();

        // Count occurrences of each character
        for (char character : word.toCharArray()) {
            wordCountMap.put(character, wordCountMap.getOrDefault(character, 0) + 1);
        }

        // Find the first character with a frequency of 1
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char character = charArray[i];
            if (wordCountMap.get(character) == 1) {
                return i;
            }
        }
        return -1; // No unique character found
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
                "leetcode",     // Expected: 0 ('l')
                "loveleetcode", // Expected: 2 ('v')
                "aabb",         // Expected: -1 (no unique character)
                "abcdabcdz",    // Expected: 8 ('z')
                "xxyyzz",       // Expected: -1 (no unique character)
                "unique"        // Expected: 0 ('u')
        };

        int[] expectedResults = {0, 2, -1, 8, -1, 0};

        // Test the function with sample test cases
        System.out.println("Testing FirstUniqueCharacter Function:");
        for (int i = 0; i < testCases.length; i++) {
            String testCase = testCases[i];
            int expected = expectedResults[i];
            int actual = firstUniqueChar(testCase);
            System.out.printf(
                    "Test Case: \"%s\" | Expected: %d, Actual: %d | %s\n",
                    testCase, expected, actual, (expected == actual) ? "PASSED" : "FAILED"
            );
        }
    }
}
