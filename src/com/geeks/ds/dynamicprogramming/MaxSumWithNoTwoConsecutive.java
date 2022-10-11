package com.geeks.ds.dynamicprogramming;

/**
 * Given an array of positive numbers, the task is to find the maximum sum of a subsequence
 * with the constraint that no 2 numbers in the sequence should be adjacent in the array.
 */
public class MaxSumWithNoTwoConsecutive {

    public static void main(String[] args) {


        int arr[] = {10, 20, 30, 40, 50};
        int n = arr.length;

        System.out.println(maxSum(arr, n));

    }

    // Space optimized solution
    static int maxSum(int arr[], int n) {
        if (n == 0) {
            return arr[0];
        }

        int prev_prev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int res = prev;

        for (int i = 3; i <= n; i++) {
            res = Math.max(prev, prev_prev + arr[i - 1]);

            prev_prev = prev;

            prev = res;
        }

        return res;
    }

    static int maxSum2(int arr[], int n) {
        if (n == 0)
            return arr[0];

        int dp[] = new int[n + 1];

        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }

        return dp[n];
    }
}
