package com.geeks.ds.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {

        int n = 5;
        memo = new int[n + 1];

        Arrays.fill(memo, -1);
        System.out.println(fib(n));

    }

    static int[] memo;

    // Memoization based approach(Top down approach)
    static int fib(int n) {
        if (memo[n] == -1) {
            int res;

            if (n == 0 || n == 1) {
                return n;
            } else {
                res = fib(n - 1) + fib(n - 2);
            }

            memo[n] = res;
        }

        return memo[n];
    }

    // Tabular based solution (Bottom up)
    static int fibTabular(int n) {
        int f[] = new int[n + 1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

}
