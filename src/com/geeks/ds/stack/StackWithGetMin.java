package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Design a stack that supports normal stack operatiosn in O(1) and also supprots getMin() in O(1)
 */
public class StackWithGetMin {

    Deque<Integer> mainStack;
    Deque<Integer> auxilaryStack;

    StackWithGetMin() {
        mainStack = new ArrayDeque<>();
        auxilaryStack = new ArrayDeque<>();
    }

    void push(int x) {

        if (mainStack.isEmpty()) {
            mainStack.add(x);
            auxilaryStack.add(x);
            return;
        }
        mainStack.add(x);

        if (auxilaryStack.peek() >= mainStack.peek()) {
            auxilaryStack.add(x);
        }
    }

    void pop() {

        if (auxilaryStack.peek() == mainStack.peek()) {
            auxilaryStack.pop();
        }
        mainStack.pop();
    }

    int top() {
        return mainStack.peek();
    }

    int getMin() {
        return auxilaryStack.peek();
    }

    public static void main(String[] args) {
        StackWithGetMin s = new StackWithGetMin();
        ;
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();

        System.out.print(" Minimum Element from Stack: " + s.getMin());

    }
}
