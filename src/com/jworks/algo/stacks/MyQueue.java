package com.jworks.algo.stacks;

import java.util.*;

public class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            transferFromStack1ToStack2();
        }

        return stack2.pop();
    }


    public int peek() {
        if (stack2.isEmpty()) {
            transferFromStack1ToStack2();
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void transferFromStack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Test cases with expected results
        try {
            // Test 1: Push and Peek
            queue.push(1);
            queue.push(2);
            assertEqual(queue.peek(), 1, "Test 1 - Peek after push");

            // Test 2: Pop and Verify
            assertEqual(queue.pop(), 1, "Test 2 - Pop first element");
            assertEqual(queue.peek(), 2, "Test 2 - Peek after pop");

            // Test 3: Push more and Pop
            queue.push(3);
            assertEqual(queue.pop(), 2, "Test 3 - Pop second element");
            assertEqual(queue.pop(), 3, "Test 3 - Pop third element");

            // Test 4: Check Empty
            assertEqual(queue.empty(), true, "Test 4 - Queue is empty");

            // Test 5: Push After Empty
            queue.push(4);
            assertEqual(queue.empty(), false, "Test 5 - Queue is not empty after push");
            assertEqual(queue.peek(), 4, "Test 5 - Peek after new push");
            assertEqual(queue.pop(), 4, "Test 5 - Pop only element");

            // Final Check: Queue is Empty Again
            assertEqual(queue.empty(), true, "Final Check - Queue is empty again");

            System.out.println("\nAll tests passed successfully!");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    // Helper method to assert and print results
    private static void assertEqual(Object actual, Object expected, String testName) {
        if (!actual.equals(expected)) {
            throw new AssertionError(
                    testName + " failed: Expected = " + expected + ", Got = " + actual
            );
        } else {
            System.out.println(testName + " passed: Expected = " + expected + ", Got = " + actual);
        }
    }


}


// stack 1 [] , stack 2 []

//push a > stack 1 [a] , stack 2 []

//push a > stack 1 [a] , stack 2 []

//push b > stack 1 [a,b] , stack 2 []

//push c > stack 1 [a,b,c] , stack 2 []

//pop
// > do a transfer first from stack1 to stack2 only if stack2 is empty
// > stack 1 [] , stack 2 [c,b,a]
// > stack 1 [] , stack 2 [c,b] returns a

//pop
// > do a transfer first from stack1 to stack2 only if stack2 is empty (it isn't)
// > stack 1 [] , stack 2 [c,b]
// > stack 1 [] , stack 2 [c] returns b

//push d > stack 1 [d] , stack 2 [c]

//peek
// > do a transfer first from stack1 to stack2 only if stack2 is empty (it isn't)
// peek stack1 [d], stack2[c] returns c
