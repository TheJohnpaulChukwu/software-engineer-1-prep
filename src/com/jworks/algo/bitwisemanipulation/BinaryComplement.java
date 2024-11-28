package com.jworks.algo.bitwisemanipulation;

/**
 * Finds the complement of a given positive integer's binary representation.
 *
 * The complement is obtained by flipping all the bits in the binary form of the number,
 * turning every 0 into a 1 and every 1 into a 0. The result is then returned as a decimal integer.
 *
 * **Approach:**
 * 1. **Special Case Handling:**
 *    - If the input `n` is 0, its binary representation is "0".
 *    - The complement of "0" is "1", which is 1 in decimal.
 *    - So, we return 1 immediately for this case.
 *
 * 2. **Creating a Mask:**
 *    - We need a mask that has the same number of bits as `n`, with all bits set to 1.
 *    - Initialize `mask` to 0.
 *    - Use a temporary variable `temp` to traverse through the bits of `n`.
 *    - While `temp` is not zero:
 *        - Left shift `mask` by 1 bit (`mask << 1`), which adds a 0 at the right end.
 *        - Use bitwise OR with 1 (`| 1`) to set the rightmost bit to 1.
 *        - Right shift `temp` by 1 bit (`temp >> 1`) to move to the next bit.
 *    - This loop effectively builds a mask of ones that aligns with the length of `n` in binary.
 *    - **Example:** If `n` is 5 (binary `101`), the mask becomes `111` (binary), which is 7 in decimal.
 *
 * 3. **Calculating the Complement:**
 *    - Use the XOR (exclusive OR) operation between `n` and the mask (`n ^ mask`).
 *    - The XOR operation flips the bits where the mask has 1s.
 *    - This effectively flips all the bits of `n`, giving us the complement.
 *    - **Example:** `5 ^ 7` gives `2`, because `101 ^ 111` equals `010` in binary.
 *
 * 4. **Return the Result:**
 *    - The result of the XOR operation is the complement of `n`.
 *    - Return this value.
 *
 * **Runtime Complexity:**
 * - **Time Complexity:** O(k), where k is the number of bits in `n`.
 *   - We traverse each bit of `n` once to build the mask.
 * - **Space Complexity:** O(1), constant space.
 *   - We use a fixed number of variables regardless of the input size.
 *
 * **Relatable Analogy:**
 * - Think of the mask as a template that covers all the bits of `n`.
 * - By XORing `n` with this template of all 1s, we're flipping each bit of `n`.
 * - It's like having a photo negative: where the original is light, the negative is dark, and vice versa.
 *
 * @param n The positive integer to find the complement of.
 * @return The complement of the binary representation of `n` as a decimal integer.
 */
public class BinaryComplement {
    public static int findComplement(int n) {
        if (n == 0) {
            return 1; // Special case: the complement of 0 is 1
        }

        int mask = 0;
        int temp = n;

        // Create a mask with all bits set to 1 that has the same length as n
        while (temp != 0) {
            mask = (mask << 1) | 1; // Shift mask left and add a 1
            temp = temp >> 1;        // Shift temp right to move to the next bit
        }

        // XOR n with mask to flip all bits and get the complement
        int complement = n ^ mask;

        return complement;
    }

    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 5;

        // Test Case 1
        int n1 = 5;
        int expected1 = 2;
        int result1 = findComplement(n1);
        if (result1 == expected1) {
            passedTests++;
            System.out.println("Test Case 1 Passed. Input: " + n1 + ", Expected: " + expected1 + ", Actual: " + result1);
        } else {
            System.out.println("Test Case 1 Failed. Input: " + n1 + ", Expected: " + expected1 + ", Actual: " + result1);
        }

        // Test Case 2
        int n2 = 1;
        int expected2 = 0;
        int result2 = findComplement(n2);
        if (result2 == expected2) {
            passedTests++;
            System.out.println("Test Case 2 Passed. Input: " + n2 + ", Expected: " + expected2 + ", Actual: " + result2);
        } else {
            System.out.println("Test Case 2 Failed. Input: " + n2 + ", Expected: " + expected2 + ", Actual: " + result2);
        }

        // Test Case 3
        int n3 = 0;
        int expected3 = 1;
        int result3 = findComplement(n3);
        if (result3 == expected3) {
            passedTests++;
            System.out.println("Test Case 3 Passed. Input: " + n3 + ", Expected: " + expected3 + ", Actual: " + result3);
        } else {
            System.out.println("Test Case 3 Failed. Input: " + n3 + ", Expected: " + expected3 + ", Actual: " + result3);
        }

        // Test Case 4
        int n4 = 10;
        int expected4 = 5;
        int result4 = findComplement(n4);
        if (result4 == expected4) {
            passedTests++;
            System.out.println("Test Case 4 Passed. Input: " + n4 + ", Expected: " + expected4 + ", Actual: " + result4);
        } else {
            System.out.println("Test Case 4 Failed. Input: " + n4 + ", Expected: " + expected4 + ", Actual: " + result4);
        }

        // Test Case 5
        int n5 = 100;
        int expected5 = 27;
        int result5 = findComplement(n5);
        if (result5 == expected5) {
            passedTests++;
            System.out.println("Test Case 5 Passed. Input: " + n5 + ", Expected: " + expected5 + ", Actual: " + result5);
        } else {
            System.out.println("Test Case 5 Failed. Input: " + n5 + ", Expected: " + expected5 + ", Actual: " + result5);
        }

        // Print the total number of passed tests
        System.out.println("\nTotal Tests Passed: " + passedTests + " out of " + totalTests);
    }
}