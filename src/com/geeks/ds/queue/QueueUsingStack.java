package com.geeks.ds.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * We are given a stack data structure with push and pop operations, the task is to implement a queue
 * using instances of stack data structure and operations on them.
 */
public class QueueUsingStack {

    static class Queue {
        static Deque<Integer> s1 = new ArrayDeque<>();
        static Deque<Integer> s2 = new ArrayDeque<>();

        static void enQueue(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        static int deQueue() {
            if (s1.isEmpty()) {
                System.out.println("Q is Empty");
                System.exit(0);
            }
            int x = s1.peek();
            s1.pop();
            return x;
        }
    }

    ;

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
