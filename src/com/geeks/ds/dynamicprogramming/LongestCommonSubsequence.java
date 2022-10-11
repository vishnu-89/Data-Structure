package com.geeks.ds.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int[][] memo;

    public static void main(String[] args) {

        String s1 = "AXYZ";
        String s2 = "BAZ";

        int m = 4;
        int n = 3;
        memo = new int[m + 1][n + 1];

        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }

        System.out.println(lcs(s1, s2, m, n));

        System.out.println(lcsTabulation(s1, s2, m, n));
    }

    // Memoization based DP solution
    public static int lcs(String s1, String s2, int m, int n) {

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (m == 0 || n == 0) {
            memo[m][n] = 0;
        } else {
            if (s1.charAt(m - 1) == s2.charAt(n - 1))
                memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
            else
                memo[m][n] = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
        return memo[m][n];
    }

    // Tabulation based DP solution
    public static int lcsTabulation(String s1, String s2, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // Recursive solution
    public static int lcsRecursive(String s1, String s2, int n, int m) {

        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcsRecursive(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(lcsRecursive(s1, s2, n - 1, m), lcsRecursive(s1, s2, n, m - 1));
        }
    }

    /*
         Variations of LCS -
         1. Diff utility
         2. Minimum insertion and deletion required to convert string s1 to s2
         3. Shortest common super sequence
         4. Longest palindrome subsequence
         5. Longest repeating subsequence
         6. Space optimized DP solution of LCS
         7. Printing LCS
     */
}
