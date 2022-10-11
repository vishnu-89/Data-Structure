package com.geeks.ds.strings;

import java.util.Arrays;

/**
 * Given a string, the task is to find the leftmost character that does not repeat.
 */
public class LeftmostNonRepearting {

    static final int CHAR = 256;

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        System.out.println("Index of leftmost non-repeating element:");
        System.out.println(nonRep(str));
    }

    static int nonRep(String str) {
        int[] firstIndex = new int[CHAR];
        Arrays.fill(firstIndex, -1);

        for (int i = 0; i < str.length(); i++) {
            if (firstIndex[str.charAt(i)] == -1) {
                firstIndex[str.charAt(i)] = i;
            } else {
                firstIndex[str.charAt(i)] = -2;
            }

        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < CHAR; i++) {
            if (firstIndex[i] >= 0) {
                res = Math.min(res, firstIndex[i]);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

}
