package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an infix expression in the form of string str. Convert this infix expression to postfix expression.
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

    static String infixToPostfix(String exp) {
        String result = new String("");
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }

        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    static int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
