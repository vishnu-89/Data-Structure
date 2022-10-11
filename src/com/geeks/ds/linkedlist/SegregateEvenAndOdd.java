package com.geeks.ds.linkedlist;

/**
 * Given a linked list segregate even and odd
 */
public class SegregateEvenAndOdd {

    public static void main(String args[]) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);

        System.out.println("Linked before segregation :");
        printlist(head);
        head = segregate(head);

        System.out.println("Linked after segregation :");
        printlist(head);

    }

    static Node segregate(Node head) {
        Node eS = null;
        Node eE = null;
        Node oS = null;
        Node oE = null;
        for (Node curr = head; curr != null; curr = curr.next) {
            int x = curr.data;
            if (x % 2 == 0) {
                if (eS == null) {
                    eS = curr;
                    eE = eS;
                } else {
                    eE.next = curr;
                    eE = eE.next;
                }
            } else {
                if (oS == null) {
                    oS = curr;
                    oE = oS;
                } else {
                    oE.next = curr;
                    oE = oE.next;
                }
            }
        }
        if (oS == null || eS == null) {
            return head;
        }

        eE.next = oS;
        oE.next = null;
        return eS;
    }

    public static void printlist(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
