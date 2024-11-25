package com.jworks.algo.inplacemodification;

public class ReverseLinkedListII {

    // Question
    // Given a singly linked list with n nodes and two positions, left and right,
    // the objective is to reverse the nodes of the
    // list from left to right. Return the modified list.
    
    /**
     * Reverses a sublist of a singly linked list from position 'left' to 'right' in-place.
     *
     * @param head  The head of the singly linked list.
     * @param left  The starting position of the sublist to reverse (1-indexed).
     * @param right The ending position of the sublist to reverse (1-indexed).
     * @return The head of the modified linked list after reversing the sublist.
     */
    public LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        // Edge case: if the list is empty or left equals right, no reversal is needed
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node that points to the head to simplify edge cases
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        // Initialize 'nodeBeforeSublist' to point to the node before the sublist to reverse
        LinkedListNode nodeBeforeSublist = dummy;

        // Move 'nodeBeforeSublist' to the node immediately before position 'left'
        for (int i = 1; i < left; i++) {
            nodeBeforeSublist = nodeBeforeSublist.next;
        }

        // 'leftNodeToReverse' points to the first node in the sublist that will be reversed
        LinkedListNode leftNodeToReverse = nodeBeforeSublist.next;

        // Iterate over the sublist and reverse the links
        for (int i = 0; i < right - left; i++) {
            // 'RightNodeToReverse' is the node that will be moved to the front of the sublist
            LinkedListNode rightNodeToReverse = leftNodeToReverse.next;

            // Adjust the pointers to remove 'RightNodeToReverse' from its current position
            leftNodeToReverse.next = rightNodeToReverse.next;

            // Insert 'RightNodeToReverse' right after 'nodeBeforeSublist'
            rightNodeToReverse.next = nodeBeforeSublist.next;
            nodeBeforeSublist.next = rightNodeToReverse;
        }

        // Return the head of the modified list
        return dummy.next;
    }
}
