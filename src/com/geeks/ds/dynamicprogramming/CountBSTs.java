package com.geeks.ds.dynamicprogramming;

/**
 * Find the total number of possible Binary Search Trees with n distinct keys
 */
public class CountBSTs {

    public static void main(String[] args) {

        int n = 4;
        System.out.println(countBSTs(n));
    }

    static int countBSTs(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    /**
     * Total number of possible Binary Search Trees with n different keys (countBST(n)) = Catalan number Cn = (2n)! / ((n + 1)! * n!)
     */
}
