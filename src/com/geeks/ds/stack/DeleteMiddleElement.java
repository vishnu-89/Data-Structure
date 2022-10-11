package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a stack with push(), pop(), empty() operations, delete the middle of the stack without using any additional data structure.
 */
public class DeleteMiddleElement {

    public static void main(String args[]) {
        Deque<Character> st = new ArrayDeque<Character>();

        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        st.push('5');
        st.push('6');
        st.push('7');

        deleteMid(st, st.size(), 0);
        while (!st.isEmpty()) {
            char p = st.pop();
            System.out.print(p + " ");
        }
    }

    static void deleteMid(Deque<Character> st, int n, int curr) {

        if (st.isEmpty() || curr == n) {
            return;
        }

        char x = st.pop();
        deleteMid(st, n, curr + 1);
        if (curr != n / 2) {
            st.push(x);
        }
    }
}
