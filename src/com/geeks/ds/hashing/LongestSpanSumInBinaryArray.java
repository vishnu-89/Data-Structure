package com.geeks.ds.hashing;

import java.util.HashMap;

/**
 * Given two binary arrays, arr1[] and arr2[] of the same size n. Find the length of the longest common span (i, j) where j >= i
 * such that arr1[i] + arr1[i+1] + …. + arr1[j] = arr2[i] + arr2[i+1] + …. + arr2[j].
 */
public class LongestSpanSumInBinaryArray {

    public static void main(String args[]) {
        int[] arr1 = {0, 1, 0, 1, 1, 1, 1};
        int[] arr2 = {1, 1, 1, 1, 1, 0, 1};
        int n = arr1.length;
        System.out.println(longestCommonSum(arr1, arr2, n));
    }

    static int longestCommonSum(int[] arr1, int[] arr2, int n) {

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i] - arr2[i];
        }

        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0;
        int max_len = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];
            if (sum == 0) {
                max_len = i + 1;
            }
            if (hM.containsKey(sum)) {
                max_len = Math.max(max_len, i - hM.get(sum));
            } else {
                hM.put(sum, i);
            }

        }
        return max_len;
    }
}
