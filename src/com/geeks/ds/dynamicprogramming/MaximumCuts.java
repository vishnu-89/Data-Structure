package com.geeks.ds.dynamicprogramming;

/**
 * Given a rod of length N meters, and the rod can be cut in only 3 sizes A, B and C.
 * The task is to maximizes the number of cuts in rod. If it is impossible to make cut then print -1.
 */
public class MaximumCuts {

    public static void main(String[] args) {
        int n = 5;
        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println(maxCuts(n, a, b, c));

    }

    private static int maxCuts(int n, int a, int b, int c) {

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0) {
                dp[i] = Math.max(dp[i], dp[i - a]);
            }

            if (i - b >= 0) {
                dp[i] = Math.max(dp[i], dp[i - b]);
            }

            if (i - c >= 0) {
                dp[i] = Math.max(dp[i], dp[i - c]);
            }

            if (dp[i] != -1) {
                dp[i]++;
            }
        }
        return dp[n];
    }
}
