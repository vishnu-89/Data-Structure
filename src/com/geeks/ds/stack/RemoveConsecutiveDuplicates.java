package com.geeks.ds.stack;

import java.util.Arrays;

/**
 * You are given string str. You need to remove the consecutive duplicates from the given string.
 */
public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        char S1[] = "aaaaaabaabccccccc".toCharArray();
        removeDuplicates(S1);

    }

    static void removeDuplicates(char[] S) {
        int n = S.length;
        if (n < 2) {
            return;
        }
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (S[j] != S[i]) {
                j++;
                S[j] = S[i];
            }
        }
        System.out.println(Arrays.copyOfRange(S, 0, j + 1));
    }

}
