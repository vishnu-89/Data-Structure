package com.geeks.ds.dynamicprogramming;

/**
 * Given two strings s1 and s2, write and algorithm to convert s1 to s2 by using minimum operation.
 * You can either add, delete or replace the characters
 */
public class EditDistance {

    public static void main(String[] args) {

        String s1 = "CAT";
        String s2 = "CUT";
        int n = s1.length();
        int m = s2.length();


        System.out.println(editDistance(s1, s2, m, n));

    }

    // Tabulation based DP solution
    private static int editDistance(String s1, String s2, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    private static int editDistanceRecursive(String s1, String s2, int m, int n) {

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDistanceRecursive(s1, s2, m - 1, n - 1);
        } else {
            return 1 + Math.min(Math.min(editDistanceRecursive(s1, s2, m, n - 1), editDistanceRecursive(s1, s2, m - 1, n - 1)),
                    editDistanceRecursive(s1, s2, m - 1, n));
        }
    }
}
