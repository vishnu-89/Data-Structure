package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Design A Stack With Get Min() in O(1) Space
 */
public class StackWithGetMinConstantSpace {

    Deque<Integer> stack;
    int min;

    StackWithGetMinConstantSpace() {
        stack = new ArrayDeque<>();
    }

    void push(int x) {

        if (stack.isEmpty()) {
            min = x;
            stack.add(x);
        } else if (x <= min) {
            stack.add(2 * x - min);
            min = x;
        } else {
            stack.add(x);
        }
    }

    int pop() {

        int t = stack.peek();
        stack.pop();
        if (t <= min) {
            int res = min;
            min = 2 * min - t;
            return res;
        } else {
            return t;
        }
    }

    int peek() {
        int t = stack.peek();
        return ((t <= min) ? min : t);
    }

    int getMin() {
        return min;
    }

    public static void main(String[] args) {
        StackWithGetMinConstantSpace s = new StackWithGetMinConstantSpace();
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();

        System.out.print(" Minimum Element from Stack: " + s.getMin());

    }
}
