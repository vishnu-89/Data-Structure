package com.geeks.ds.linkedlist;

/**
 * Given a linked list detect if loop available and if Yes then remove the loop from the linked list
 */
public class DetectAndRemoveLoop {

    public static void main(String args[]) {
        Node head = new Node(15);
        head.next = new Node(10);
        head.next.next = new Node(12);
        head.next.next.next = new Node(20);
        head.next.next.next.next = head.next;
        detectRemoveLoop(head);

        System.out.println("Node after removing loop :");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    static void detectRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast)
            return;
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

}
