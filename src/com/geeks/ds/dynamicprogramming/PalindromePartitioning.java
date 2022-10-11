package com.geeks.ds.dynamicprogramming;

/**
 *
 */
public class PalindromePartitioning {

    public static void main(String args[]) {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for Palindrome Partitioning is " + minPalPartion(str, 0, str.length() - 1));
    }

    //DP solution
    static int palPartition(String str) {
        int n = str.length();

        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;

                if (isPalindrome(str, i, j)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    //Recursive solution
    static int minPalPartion(String string, int i, int j) {
        if (i >= j || isPalindrome(string, i, j)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE, count;
        for (int k = i; k < j; k++) {
            count = minPalPartion(string, i, k) + minPalPartion(string, k + 1, j) + 1;
            ans = Math.min(ans, count);
        }

        return ans;
    }

    static boolean isPalindrome(String string, int i, int j) {
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
