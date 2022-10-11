package com.geeks.ds.strings;

import java.util.Arrays;

/**
 * Given a string str, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringOfDistinctCharacter {

    static final int CHAR = 256;

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        int len = longestDistinct(str);
        System.out.print("The length of the longest distinct characters substring is " + len);
    }

    static int longestDistinct(String str) {
        int n = str.length();
        int res = 0;
        int prev[] = new int[CHAR];
        Arrays.fill(prev, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, prev[str.charAt(j)] + 1);
            int maxEnd = j - i + 1;
            res = Math.max(res, maxEnd);
            prev[str.charAt(j)] = j;
        }
        return res;
    }
}
