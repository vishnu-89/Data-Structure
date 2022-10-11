package com.geeks.ds.dynamicprogramming;

public class EggDroppingPuzzle {

    public static void main(String args[]) {
        int n = 2;
        int k = 10;
        System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDrop(n, k));
    }

    static int eggDrop(int e, int f) {

        int dp[][] = new int[f+1][e+1];

        for(int i = 1; i <= e ;i++) {
            dp[1][i] = 1;
            dp[0][i] = 0;
        }

        for(int j = 1; j <= f; j++){
            dp[j][1] = j;
        }

        for(int i = 2; i <= f; i++) {
            for(int j = 2; j <= e; j++) {
                dp[i][j] =Integer.MAX_VALUE;
                for(int x = 1; x <= i; x++){
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x-1][j-1], dp[i-x][j]));
                }
            }
        }

        return dp[f][e];
    }

    //Recursive solution
    static int eggDropRecursive(int n, int k) {
        if (k == 1 || k == 0) {
            return k;
        }
        if (n == 1) {
            return k;
        }

        int min = Integer.MAX_VALUE;
        int x;
        int res;

        for (x = 1; x <= k; x++) {
            res = Math.max(
                    eggDropRecursive(n - 1, x - 1),
                    eggDropRecursive(n, k - x)
            );
            if (res < min) {
                min = res;
            }
        }

        return min + 1;
    }
}
