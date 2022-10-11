package com.geeks.ds.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        int arr[] = {5, 3, 9, -4, -6, 7, -1};
        int n = arr.length;

        System.out.println("Zero sum subarray found : " + zeroSumSubarray(arr, n));

    }

    static boolean zeroSumSubarray(int arr[], int n) {
        Set<Integer> set = new HashSet<Integer>();
        int prefix_sum = 0;
        for (int i = 0; i < n; i++) {
            prefix_sum += arr[i];

            if(prefix_sum == 0) {
                return true;
            }
            else if (set.contains(prefix_sum)) {
                return true;
            }

            set.add(prefix_sum);
        }

        return false;
    }
}
