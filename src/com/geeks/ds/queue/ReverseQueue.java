package com.geeks.ds.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a program to reverse a queue
 */
public class ReverseQueue {

    public static void main(String args[]) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(12);
        queue.add(5);
        queue.add(15);
        queue.add(20);

        reversequeue(queue);
        print(queue);
    }

    static void reversequeue(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
    }

    static void print(Queue<Integer> queue) {
        for (Integer x : queue)
            System.out.print(x + " ");
    }

}
