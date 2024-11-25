package com.jworks.algo.inplacemodification;

import java.util.*;

public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {



        LinkedListNode currentNode = head;
        LinkedListNode nextNode;
        LinkedListNode prevNode = null;

        while (currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }

}