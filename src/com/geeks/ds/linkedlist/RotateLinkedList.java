package com.geeks.ds.linkedlist;

/**
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes
 */
public class RotateLinkedList {

    static Node head;

    public static void main(String args[]) {
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println("list before rotation :");
        printList(head);

        rotate(3);
        System.out.println("list after rotation :");
        printList(head);
    }

    static void rotate(int k) {
        if (k == 0)
            return;
        Node current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return;
        }

        Node kthNode = current;
        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head = kthNode.next;

        kthNode.next = null;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
