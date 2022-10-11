package com.geeks.ds.dynamicprogramming;

/**
 * Consider a row of n coins of values v1 . . . vn, where n is even.
 * We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row,
 * removes it from the row permanently, and receives the value of the coin.
 * Determine the maximum possible amount of money we can definitely win if we move first.
 */
public class OptimalStrategyGame {

    public static void main(String[] args) {

        int n = 4;
        int arr[] = {2,20, 5, 4, 6,9};

        System.out.println(optimalStrategy(arr, n));

        System.out.println(optimalStrategyRecusive(arr, 0, n - 1));

    }

    static int optimalStrategy(int[] arr, int n) {
        int dp[][] = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }

        for (int gap = 3; gap < n; gap = gap + 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = gap + i;

                dp[i][j] = Math.max(
                        (arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1])),
                        (arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]))
                );
            }
        }

        return dp[0][n - 1];
    }

    private static int optimalStrategyRecusive(int[] ar, int i, int j) {

        if (i + 1 == j) {
            return Math.max(ar[i], ar[j]);
        }

        return Math.max(
                ar[i] + Math.min(
                        optimalStrategyRecusive(ar, i + 2, j),
                        optimalStrategyRecusive(ar, i + 1, j - 1)
                ),
                ar[j] + Math.min(
                        optimalStrategyRecusive(ar, i + 1, j - 1),
                        optimalStrategyRecusive(ar, i, j - 2)
                )
        );
    }

}
