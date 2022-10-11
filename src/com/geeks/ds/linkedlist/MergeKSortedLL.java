package com.geeks.ds.linkedlist;

import java.util.HashSet;

/**
 * Given K sorted linked lists of size N each, merge them and print the sorted output.
 */
public class MergeKSortedLL {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);

        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next;
        Print(n1);
        Print(n2);
        System.out.println(MegeNode(n1, n2).data);
    }

    public static Node MegeNode(Node n1, Node n2) {
        HashSet<Node> hs = new HashSet<Node>();
        while (n1 != null) {
            hs.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (hs.contains(n2)) {
                return n2;
            }
            n2 = n2.next;
        }
        return null;
    }

    public static void Print(Node n) {
        Node cur = n;
        while (cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    // By using two pointer approach
    static Node intersectPoint(Node head1, Node head2) {
        Node ptr1 = head1;
        Node ptr2 = head2;
        if (ptr1 == null || ptr2 == null) {

            return null;
        }
        while (ptr1 != ptr2) {

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

            if (ptr1 == ptr2) {

                return ptr1;
            }
            if (ptr1 == null) {

                ptr1 = head2;
            }
            if (ptr2 == null) {

                ptr2 = head1;
            }
        }

        return ptr1;
    }

}
