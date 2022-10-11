package com.geeks.ds.stack;

/**
 * Implement Two stacks in a single array.
 */
public class TwoStackInArray {

    int cap;
    int top1;
    int top2;
    int arr[];

    TwoStackInArray(int n) {
        arr = new int[n];
        cap = n;
        top1 = -1;
        top2 = cap;
    }

    void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int pop2() {
        if (top2 < cap) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    public static void main(String[] args) {

        TwoStackInArray stack = new TwoStackInArray(5);
        stack.push1(5);
        stack.push2(10);
        stack.push2(15);
        stack.push1(11);
        stack.push2(7);
        System.out.println("Popped element from stack1 is: " + stack.pop1());
        stack.push2(40);
        System.out.println("Popped element from stack2 is: " + stack.pop2());

    }
}
