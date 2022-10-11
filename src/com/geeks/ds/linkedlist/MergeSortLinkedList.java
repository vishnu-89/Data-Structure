package com.geeks.ds.linkedlist;

/**
 * Given a linked list sort using merge sort algorithm
 */
public class MergeSortLinkedList {

    public static void main(String[] args) {

        Node head = new Node(15);
        head.next = new Node(10);
        head.next.next = new Node(5);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);

        head = mergeSort(head);
        System.out.print("Sorted Linked List is : ");
        printList(head);
    }

    static Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    static Node mergeSort(Node h) {
        if (h == null || h.next == null) {
            return h;
        }
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(h);

        Node right = mergeSort(nextofmiddle);
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    public static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
