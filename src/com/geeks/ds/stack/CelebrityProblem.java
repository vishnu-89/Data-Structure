package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people,
 * find if there is a celebrity in the party or not.
 * A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1
 * it means ith person knows jth person
 */
public class CelebrityProblem {

    static int MATRIX[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else
            System.out.println("Celebrity ID " + result);
    }

    static int findCelebrity(int n) {
        Deque<Integer> st = new ArrayDeque<>();
        int c;
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (knows(a, b)) {
                st.push(b);
            } else {
                st.push(a);
            }
        }
        if (st.isEmpty()) {
            return -1;
        }

        c = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != c && (knows(c, i) || !knows(i, c))) {
                return -1;
            }
        }
        return c;
    }

    static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }

    // Second approach
    public static int celebrity(int n) {

        int i = 0, j = n - 1;
        while (i < j) {
            if (MATRIX[j][i] == 1) {
                j--;
            } else {
                i++;
            }
        }

        int candidate = i;
        for (i = 0; i < n; i++) {
            if (i != candidate) {
                if (MATRIX[i][candidate] == 0 || MATRIX[candidate][i] == 1) {
                    return -1;
                }
            }
        }
        return candidate;
    }
}