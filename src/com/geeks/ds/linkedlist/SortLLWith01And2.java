package com.geeks.ds.linkedlist;

/**
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only.
 * The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list,
 * and 1s in the mid of 0s and 2s.
 */
public class SortLLWith01And2 {

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        System.out.println("Linked List Before Sorting : ");
        printList(head);
        head = sortList(head);
        System.out.println("Linked List After Sorting : ");
        printList(head);
    }

    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);

        Node zero = zeroD;
        Node one = oneD;
        Node two = twoD;

        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
                curr = curr.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
                curr = curr.next;
            } else {
                two.next = curr;
                two = two.next;
                curr = curr.next;
            }
        }
        zero.next = (oneD.next != null) ? (oneD.next) : (twoD.next);
        one.next = twoD.next;
        two.next = null;
        head = zeroD.next;
        return head;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // By changing Node data
    static void sortList1(Node head) {
        int count[] = {0, 0, 0};

        Node ptr = head;
        while (ptr != null) {
            count[ptr.data]++;
            ptr = ptr.next;
        }

        int i = 0;
        ptr = head;
        while (ptr != null) {
            if (count[i] == 0)
                i++;
            else {
                ptr.data = i;
                --count[i];
                ptr = ptr.next;
            }
        }
    }
}

