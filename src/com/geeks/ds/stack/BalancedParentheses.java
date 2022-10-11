package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string of parenthesis ({, }, (, ), [ and ]), we need to check if this string is balanced or not.
 */
public class BalancedParentheses {

    public static void main(String[] args) {

        String str = "[()]{}{[()()]()}";

        if (isBalanced(str))
            System.out.print("Balanced");
        else
            System.out.print("Not Balanced");

    }

    public static boolean isBalanced(String str) {

        Deque<Character> s = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                s.add(str.charAt(i));
            } else {
                if (s.isEmpty()) {
                    return false;
                } else if (!matching(s.peek(), str.charAt(i))) {
                    return false;
                } else {
                    s.pop();
                }

            }
        }
        return (s.isEmpty() == true);
    }

    public static boolean matching(char a, char b) {
        return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
    }
}
