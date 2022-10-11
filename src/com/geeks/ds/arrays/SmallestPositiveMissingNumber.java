package com.geeks.ds.arrays;

/**
 * You are given an array arr[] of N integers including 0.
 * The task is to find the smallest positive number missing from the array.
 */
public class SmallestPositiveMissingNumber {

    public static void main(String[] args) {

        int ar[] = { 0, 10, 2, -10, -20 };
        System.out.println(findMissing(ar));
    }

    private static int findMissing(int[] ar) {
        int n = ar.length;

        boolean[] present = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (ar[i] > 0 && ar[i] <= n)
                present[ar[i]] = true;
        }

        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;

        return n + 1;
    }
}
