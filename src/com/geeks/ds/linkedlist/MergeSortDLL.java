package com.geeks.ds.linkedlist;

/**
 * Write merge sort algorithm of  doubly linked list
 */
public class MergeSortDLL {

    public static void main(String[] args) {

        DLLNode head = new DLLNode(10);
        head.next = new DLLNode(30);
        head.next.next = new DLLNode(3);
        head.next.next.next = new DLLNode(4);
        head.next.next.next.next = new DLLNode(20);
        head.next.next.next.next.next = new DLLNode(5);


        DLLNode node = null;
        node = mergeSort(head);
        System.out.println("Linked list after sorting :");
        print(node);

    }

    static DLLNode mergeSort(DLLNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        DLLNode second = split(node);
        node = mergeSort(node);
        second = mergeSort(second);

        return merge(node, second);
    }

   static DLLNode split(DLLNode head) {
        DLLNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        DLLNode temp = slow.next;
        slow.next = null;
        return temp;
    }

    static DLLNode merge(DLLNode first, DLLNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    static void print(DLLNode node) {
        DLLNode temp = node;
        System.out.println("Forward Traversal using next pointer");
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }


    static class DLLNode {

        int data;
        DLLNode next, prev;

        DLLNode(int d) {
            data = d;
            next = prev = null;
        }
    }
}
