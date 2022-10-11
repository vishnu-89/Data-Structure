package com.geeks.ds.linkedlist;

/**
 * Write a function that takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list
 */
public class RemoveDuplicate {
    private static Node head;

    public static void main(String args[]) {
        head = new Node(20);
        head.next = new Node(13);
        head.next.next = new Node(13);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(11);

        System.out.println("List before removal of duplicates");
        printList();

        removeDuplicates();

        System.out.println("List after removal of elements");
        printList();
    }

    static void removeDuplicates() {

        Node curr = head;
        while (curr != null) {
            Node temp = curr;
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}