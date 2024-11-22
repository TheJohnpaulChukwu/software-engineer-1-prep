package com.jworks.algo.fastandslowpointers;

public class MiddleOfLinkedList {

    /*
    * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.

       If the total number of nodes in the LinkedList is even, return the second middle node.
    *
    * */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }


    /**
     * Algorithm: Middle of a Linked List
     *
     * This method uses the Fast and Slow Pointers technique to find the middle node
     * of a singly linked list.
     *
     * Approach:
     * 1. Use two pointers, `slowPointer` and `fastPointer`, both initialized to the head of the linked list.
     *    - `slowPointer`: Moves one step at a time.
     *    - `fastPointer`: Moves two steps at a time.
     *
     * 2. Traverse the linked list until `fastPointer` reaches the end or there are no more nodes to jump two steps.
     *    - For every two steps the `fastPointer` moves, the `slowPointer` moves one step.
     *    - When `fastPointer` reaches the end (`null`) or the second-to-last node (`fastPointer.next == null`),
     *      the `slowPointer` will be pointing to the middle node.
     *
     * 3. Return the `slowPointer` as the middle node.
     *
     * Special Cases:
     * - If the linked list has an odd number of nodes, the middle node is returned directly.
     * - If the linked list has an even number of nodes, the second middle node is returned
     *   (as per the problem requirement).
     *
     * Time Complexity:
     * - O(n), where n is the number of nodes in the linked list. Each node is visited once.
     *
     * Space Complexity:
     * - O(1), as the algorithm uses only a constant amount of extra space.
     *
     * Example:
     * Given a linked list: 1 -> 2 -> 3 -> 4 -> 5
     * - Initial: slowPointer = 1, fastPointer = 1
     * - Step 1: slowPointer = 2, fastPointer = 3
     * - Step 2: slowPointer = 3, fastPointer = 5
     * - End: fastPointer reaches the end, slowPointer = 3 (middle node)
     *
     * Given a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * - Initial: slowPointer = 1, fastPointer = 1
     * - Step 1: slowPointer = 2, fastPointer = 3
     * - Step 2: slowPointer = 3, fastPointer = 5
     * - Step 3: slowPointer = 4, fastPointer = null
     * - End: slowPointer = 4 (second middle node)
     */
    public static ListNode findMiddle(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null  && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }



    /**
     * Algorithm: Naive Approach to Find the Middle of a Linked List
     *
     * This method finds the middle node of a singly linked list in two passes:
     *
     * Approach:
     * 1. Count the total number of nodes in the linked list:
     *    - Traverse the list once to calculate the total node count (`n`).
     *
     * 2. Calculate the middle index:
     *    - If the number of nodes is odd, the middle node index is `n / 2`.
     *    - If the number of nodes is even, the middle node index is `n / 2`
     *      (the second middle node as per the requirement).
     *
     * 3. Retrieve the middle node:
     *    - Traverse the list again, stopping at the middle index, and return the node.
     *
     * Time Complexity:
     * - O(n): Requires two complete traversals of the list (one to count the nodes
     *   and another to retrieve the middle node).
     *
     * Space Complexity:
     * - O(1): Does not use any additional data structures and only uses a constant amount of memory.
     *
     * Example:
     * Given a linked list: 1 -> 2 -> 3 -> 4 -> 5
     * - First pass: Count = 5
     * - Middle index: 5 / 2 = 2 (zero-based index)
     * - Second pass: Traverse to index 2 -> Middle node = 3
     *
     * Given a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * - First pass: Count = 6
     * - Middle index: 6 / 2 = 3 (zero-based index)
     * - Second pass: Traverse to index 3 -> Middle node = 4
     */

    public static ListNode findMiddleNaive(ListNode head){

        int count = 0;

        ListNode current = head;

        while(current != null){
            current = current.next;
            count++;
        }

        int middle  = count / 2;

        current = head;
        for (int i = 0; i < middle; i++) {
            current = current.next;
        }

        return current;
    }
}
