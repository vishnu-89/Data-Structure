package com.geeks.ds.linkedlist;

import java.util.HashSet;

public class DetectLoop {

    public static void main(String args[]) {
        Node head = new Node(15);
        head.next = new Node(10);
        head.next.next = new Node(12);
        head.next.next.next = new Node(20);
        head.next.next.next.next = head.next;

        if (isLoop(head)) {
            System.out.print("Loop is found ");
        } else {
            System.out.print("No Loop");
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    // By using Floyd cycle detection
    static boolean isLoop(Node head) {
        Node slow_p = head;
        Node fast_p = head;

        while (fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                return true;
            }
        }
        return false;
    }

    static boolean isLoop1(Node head) {
        Node temp = new Node(0);
        Node curr = head;
        while (curr != null) {
            if (curr.next == null) {
                return false;
            }
            if (curr.next == temp) {
                return true;
            }
            Node curr_next = curr.next;
            curr.next = temp;
            curr = curr_next;
        }
        return false;
    }

    // By using hashing
    static boolean isLoop2(Node head) {
        HashSet<Node> s = new HashSet<Node>();
        for (Node curr = head; curr != null; curr = curr.next) {
            if (s.contains(curr)) {
                return true;
            }
            s.add(curr);
        }
        return false;
    }
}
