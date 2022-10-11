package com.geeks.ds.dynamicprogramming;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights
 * of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property)
 */
public class ZeroOneKnapSack {

    public static void main(String[] args) {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 10;
        int n = 4;

        System.out.println(knapSack(W, wt, val, n));


    }

    //By Using Dynamic programming solution
    private static int knapSack(int w, int[] wt, int[] val, int n) {

        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {

                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }

    //Recursive solution of a knapsack problem with exponential time complexity
    private static int knapSackRecursive(int w, int[] wt, int[] val, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] > w) {
            return knapSackRecursive(w, wt, val, n - 1);
        } else {
            return Math.max(knapSackRecursive(w, wt, val, n - 1),
                    val[n - 1] + knapSackRecursive(w - wt[n - 1], wt, val, n - 1));
        }
    }
}
