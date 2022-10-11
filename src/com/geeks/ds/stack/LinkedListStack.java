package com.geeks.ds.stack;

/**
 * Implement stack data structure using linked list
 */
public class LinkedListStack {

    Node head;
    int size;

    LinkedListStack() {
        head = null;
        size = 0;
    }

    void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop() {
        if (head == null) {
            return Integer.MAX_VALUE;
        }
        int res = head.data;
        Node temp = head;
        head = head.next;
        size--;
        return res;
    }

    int peek() {
        if (head == null) {
            return Integer.MAX_VALUE;
        }
        return head.data;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();
        st.push(5);
        st.push(10);
        st.push(20);
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}