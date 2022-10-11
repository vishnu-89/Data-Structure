package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * Given an array of n integers where each value represents the number of chocolates in a packet.
 * Each packet can have a variable number of chocolates. There are m students,
 * the task is to distribute chocolate packets such that:
 * <p>
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates in the packet with maximum chocolates
 * and packet with minimum chocolates given to the students is minimum.
 */
public class ChocolateDistributionProblem {

    public static void main(String[] args) {
        int arr[] = {7, 3, 2, 4, 9, 12, 56};

        int n = arr.length;
        int m = 3;

        System.out.print(minDiff(arr, n, m));

    }

    static int minDiff(int arr[], int n, int m) {
        if (m > n) {
            return -1;
        }
        Arrays.sort(arr);
        int res = arr[m - 1] - arr[0];
        for (int i = 0; (i + m - 1) < n; i++) {
            res = Math.min(res, arr[i + m - 1] - arr[i]);
        }

        return res;
    }
}
