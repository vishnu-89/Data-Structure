package com.geeks.ds.dynamicprogramming;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}
 */
public class CoinChangeProblem {

    public static void main(String[] args) {

        int coins[] = {1, 2, 3};
        int sum = 4;
        int n = 3;

        System.out.println(getCoinSum(coins, n, sum));

    }

    private static int getCoinSum(int[] coins, int n, int sum) {

        int[][] dp = new int[sum + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {

                dp[i][j] = dp[i][j - 1];
                if (coins[j - 1] <= i) {
                    dp[i][j] = dp[i][j] + dp[i - coins[j - 1]][j];
                }
            }
        }

        return dp[sum][n];
    }

    // Recursive solution
    static int count(int coins[], int m, int sum) {

        if (sum == 0) {
            return 1;
        }

        if (sum < 0) {
            return 0;
        }

        if (m <= 0 && sum >= 1) {
            return 0;
        }

        return count(coins, m - 1, sum) + count(coins, m, sum - coins[m - 1]);
    }

    //Space optimized solution
    static long countWays(int coins[], int m, int sum) {

        int[] table = new int[sum + 1];

        Arrays.fill(table, 0);   //O(n)

        table[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                table[j] += table[j - coins[i]];
            }
        }

        return table[sum];
    }
}
