package com.geeks.ds.strings;

import java.util.Arrays;

/**
 * Given a string, the task is to find the first character (whose leftmost appearance is first) that repeats.
 */
public class LeftmostRepeatingCharacter {
    static final int CHAR = 256;

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        System.out.println("Index of leftmost repeating character: " + leftMost(str));
    }


    static int leftMost(String str) {

        int[] firstIndex = new int[CHAR];
        Arrays.fill(firstIndex, -1);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            int fi = firstIndex[str.charAt(i)];
            if (fi == -1)
                firstIndex[str.charAt(i)] = i;
            else
                res = Math.min(res, fi);
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    //Second method   cc44444
    static int leftMost2(String str) {
        boolean[] visited = new boolean[CHAR];
        int res = -1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (visited[str.charAt(i)])
                res = i;
            else
                visited[str.charAt(i)] = true;
        }

        return res;

    }
}
