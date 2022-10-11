package com.geeks.ds.linkedlist;

import java.util.Stack;

/**
 * Given a singly linked list of characters, write a function that returns true if the given list is a palindrome
 */
public class IsPalindrome {

    Node left;

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        IsPalindrome isPalindrome = new IsPalindrome();
        boolean condition = isPalindrome.isPalindrome(head);
        System.out.println("isPalidrome :" + condition);
    }

    boolean isPalindrome(Node head) {
        Node slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {

            int i = stack.pop();
            if (head.data == i) {
                ispalin = true;
            } else {
                ispalin = false;
                break;
            }
            head = head.next;
        }
        return ispalin;
    }

}
