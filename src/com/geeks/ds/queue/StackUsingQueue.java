package com.geeks.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a stack operation using Queue data structure
 */
public class StackUsingQueue {

    static class QueueStack {

        static Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();


        static int curr_size;

        QueueStack() {
            curr_size = 0;
        }

        static void push(int x) {
            curr_size++;
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        static void pop() {
            if (q1.isEmpty())
                return;
            q1.remove();
            curr_size--;
        }

        static int top() {
            if (q1.isEmpty())
                return -1;
            return q1.peek();
        }

        static int size() {
            return curr_size;
        }
    }


    public static void main(String[] args) {
        QueueStack stack = new QueueStack();
        stack.push(10);
        stack.push(5);
        stack.push(15);
        stack.push(20);

        System.out.println("current size: " + stack.size());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());

        System.out.println("current size: " + stack.size());
    }
}
