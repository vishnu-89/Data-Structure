package com.geeks.ds.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue
 */
public class ReverseFirstKElement {

    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        int k = 5;
        reverseQueueFirstKElements(queue, k);
        printQueue(queue);
    }

    static void reverseQueueFirstKElements(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k > queue.size()) {
            return;
        }
        if (k <= 0) {
            return;
        }
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
    }

    static void printQueue(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }
}
