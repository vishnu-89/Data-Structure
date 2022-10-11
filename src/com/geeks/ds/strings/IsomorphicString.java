package com.geeks.ds.strings;

import java.util.Arrays;

/**
 * Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
 * Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1
 * to every character of str2 while preserving the order.
 */
public class IsomorphicString {

    static int CHAR = 256;

    public static void main(String[] args) {
        boolean res = areIsomorphic("aab", "xxy");
        System.out.println(res);

        res = areIsomorphic("aab", "xyz");
        System.out.println(res);
    }

    static boolean areIsomorphic(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if (m != n) {
            return false;
        }
        Boolean[] marked = new Boolean[CHAR];
        Arrays.fill(marked, Boolean.FALSE);

        int[] map = new int[CHAR];
        Arrays.fill(map, -1);

        for (int i = 0; i < n; i++) {
            if (map[str1.charAt(i)] == -1) {
                if (marked[str2.charAt(i)] == true) {
                    return false;
                }
                marked[str2.charAt(i)] = true;

                map[str1.charAt(i)] = str2.charAt(i);
            } else if (map[str1.charAt(i)] != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    static boolean isoMorphic(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (n != m) {
            return false;
        }
        int[] countChars1 = new int[26];
        int[] countChars2 = new int[26];

        for (int i = 0; i < n; i++) {
            countChars1[str1.charAt(i) - 'a']++;
            countChars2[str2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (countChars1[str1.charAt(i) - 'a'] != countChars2[str2.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}
