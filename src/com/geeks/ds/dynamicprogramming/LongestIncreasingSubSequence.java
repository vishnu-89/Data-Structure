package com.geeks.ds.dynamicprogramming;

/**
 * Given an array find the longest common subsequence in an increasing order
 */
public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 8, 10, 5, 1};
        int n = 7;

        System.out.println(longestSubsequence(arr, n));


    }

    static int LIS(int arr[], int n) {
        int lis[] = new int[n];

        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int res = lis[0];

        for (int i = 0; i < n; i++) {
            res = Math.max(lis[i], res);
        }

        return res;
    }

    static int longestSubsequence(int arr[], int n) {

        int[] tail = new int[n];
        tail[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {

            if (arr[i] > tail[len - 1]) {
                tail[len] = arr[i];
                len++;
            } else {
                int ceil = ceilIndex(tail, 0, len - 1, arr[i]);
                tail[ceil] = arr[i];
            }
        }
        return len;
    }

    private static int ceilIndex(int[] tail, int l, int r, int x) {

        while (r > l) {
            int mid = l + (r - l) / 2;
            if (tail[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}

/**
 * Variation of LIS
 *  1. Minimum deletion to make an array sorted (Solution : n - lis(Ar,n)
 *  2. Maximum sum increasing subsequence
 *  3. Maximum length bitonic subsequence
 *  4. Building bridges
 *  5. The longest chain
 */