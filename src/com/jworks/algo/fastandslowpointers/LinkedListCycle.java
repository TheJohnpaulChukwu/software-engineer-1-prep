package com.jworks.algo.fastandslowpointers;

import java.util.HashSet;

public class LinkedListCycle {

//    Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.

/**
 * There are two approaches to detect a cycle in a linked list:
 *
 * 1. Optimal Approach (Floyd's Cycle-Finding Algorithm):
 *    - Uses two pointers: a slow pointer and a fast pointer.
 *    - The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
 *    - If there is a cycle in the linked list, the two pointers will eventually meet.
 *    - Time Complexity: O(N), where N is the number of nodes in the list.
 *    - Space Complexity: O(1), as no additional memory is used.
 *
 * 2. Naive Approach (Using a HashSet):
 *    - Uses a HashSet to keep track of visited nodes.
 *    - While traversing the list, each node is added to the HashSet.
 *    - If a node is already present in the HashSet, a cycle is detected.
 *    - Time Complexity: O(N), where N is the number of nodes in the list.
 *    - Space Complexity: O(N), as the HashSet stores all visited nodes.
 */



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycleOptimal(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycleOptimal(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycleOptimal(head));
    }

    public static boolean hasCycleOptimal(ListNode head){

        /*
         * Time complexity : 0(N)
         *  Space Complexity: 0(1)
         * */


        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next!= null){

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(fastPointer == slowPointer) return true;
        }

        return false;

    }


    public static boolean hasCycleNaive(ListNode head) {

        /*
        * Time complexity & Space Complexity: 0(N)
        * */

        HashSet<ListNode> listNodes = new HashSet<>();

        ListNode currentNode = head;

        while(currentNode != null){
            boolean alreadyExists = listNodes.add(currentNode);

            if(!alreadyExists) return true;

            currentNode = currentNode.next;
        }

        return false;
    }
}
