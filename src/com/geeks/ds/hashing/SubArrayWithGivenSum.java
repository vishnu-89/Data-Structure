package com.geeks.ds.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array Find the subarray of given sum
 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {5, 8, 6, 13, 3, -1};
        int sum = 22;
        int n = arr.length;

        System.out.println(isSubArraySum(arr, n, sum));

    }

    static boolean isSubArraySum(int arr[], int n, int sum) {
        Set<Integer> set = new HashSet<Integer>();
        int pre_sum = 0;
        for (int i = 0; i < n; i++) {
            pre_sum += arr[i];

            if (pre_sum == sum) {
                return true;
            }
            if (set.contains(pre_sum - sum)) {
                return true;
            }

            set.add(pre_sum);
        }

        return false;
    }
}
