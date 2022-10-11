package com.geeks.ds.hashing;

import java.util.HashSet;

/**
 * Given an array, find if any pair exists with given sum
 */
public class PairWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {3, 8, 4, 7, 6, 1};
        int len = arr.length;
        int x = 14;
        System.out.println("Pair with given sum found :"+pairSum(arr, len, x));
    }

    static boolean pairSum(int arr[], int n, int sum) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (hs.contains(sum - arr[i])) {
                return true;
            }

            hs.add(arr[i]);
        }
        return false;

    }
}
