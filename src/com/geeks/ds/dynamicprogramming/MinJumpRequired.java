package com.geeks.ds.dynamicprogramming;

/**
 * Given an array of integers find the minimum jump required to reach to the end of array.
 * The value at ith position can be considered as total jump.
 */
public class MinJumpRequired {

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 1, 2, 1};
        int n = 6;

        System.out.println(minJumps(arr, n));

    }

    private static int minJumps(int[] arr, int n) {

        int dp[] = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    //Space and time optimizaed solution
    private static int minJumps(int arr[]) {
        if (arr.length <= 1) {
            return 0;
        }
        if (arr[0] == 0) {
            return -1;
        }

        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return jump;
            }
            maxReach = Math.max(maxReach, i + arr[i]);

            step--;

            if (step == 0) {
                jump++;

                if (i >= maxReach) {
                    return -1;
                }
                step = maxReach - i;
            }
        }

        return -1;
    }

    //Recursive solution
    private static int minJumpsRecursive(int[] arr, int n) {

        if (n == 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 2; i++) {
            if (arr[i] + i >= n - 1) {
                int subRes = minJumpsRecursive(arr, i + 1);

                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + 1);
                }
            }
        }
        return res;
    }
}
