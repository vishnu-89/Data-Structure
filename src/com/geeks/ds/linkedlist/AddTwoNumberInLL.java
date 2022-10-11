package com.geeks.ds.linkedlist;

import java.util.Stack;

/**
 * Given two numbers represented by two linked lists, write a function that returns Sum list.
 * The sum list is linked list representation of addition of two input numbers.
 */
public class AddTwoNumberInLL {

    public static void main(String[] args) {

        Node l1 = new Node(5);
        l1.next = new Node(6);
        l1.next.next = new Node(7);

        Node l2 = new Node(1);
        l2.next = new Node(8);
        Node result = addTwoNumbers(l1, l2);

        printList(result);
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.add(l1.data);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.add(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node result = null;

        while (!stack1.isEmpty() ||
                !stack2.isEmpty()) {
            int a = 0, b = 0;

            if (!stack1.isEmpty()) {
                a = stack1.pop();
            }

            if (!stack2.isEmpty()) {
                b = stack2.pop();
            }

            int total = a + b + carry;

            Node temp = new Node(total % 10);
            carry = total / 10;

            if (result == null) {
                result = temp;
            } else {
                temp.next = result;
                result = temp;
            }
        }

        if (carry != 0) {
            Node temp = new Node(carry);
            temp.next = result;
            result = temp;
        }
        return result;
    }

    // Second approach
    void addTwoLists(Node first, Node second) {
        Node start1 = new Node(0);
        start1.next = first;
        Node start2 = new Node(0);
        start2.next = second;

        addPrecedingZeros(start1, start2);
        Node result = new Node(0);
        if (sumTwoNodes(start1.next, start2.next, result) == 1) {
            Node node = new Node(1);
            node.next = result.next;
            result.next = node;
        }
        printList(result.next);
    }

    private void addPrecedingZeros(Node start1, Node start2) {
        Node next1 = start1.next;
        Node next2 = start2.next;
        while (next1 != null && next2 != null) {
            next1 = next1.next;
            next2 = next2.next;
        }
        if (next1 == null && next2 != null) {
            while (next2 != null) {
                Node node = new Node(0);
                node.next = start1.next;
                start1.next = node;
                next2 = next2.next;
            }
        } else if (next2 == null && next1 != null) {
            while (next1 != null) {
                Node node = new Node(0);
                node.next = start2.next;
                start2.next = node;
                next1 = next1.next;
            }
        }
    }

    private int sumTwoNodes(Node first, Node second, Node result) {
        if (first == null) {
            return 0;
        }
        int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
        Node node = new Node(number % 10);
        node.next = result.next;
        result.next = node;
        return number / 10;
    }


    public static void printList(Node result) {
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
        System.out.println();
    }
}
