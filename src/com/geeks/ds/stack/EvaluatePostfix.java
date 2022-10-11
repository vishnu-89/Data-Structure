package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given string S representing a postfix expression, the task is to evaluate the expression and find the final value.
 * Operators will only include the basic arithmetic operators like *, /, + and -.
 */
public class EvaluatePostfix {

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println("postfix evaluation: " + evaluatePostfix(exp));
    }

    static int evaluatePostfix(String exp) {

        Deque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
