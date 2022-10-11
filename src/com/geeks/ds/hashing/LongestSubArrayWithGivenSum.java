package com.geeks.ds.hashing;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array
 * having sum equal to the given value k.
 */
public class LongestSubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {8, 3, -7, -4, 1};
        int n = arr.length;
        int sum = -8;

        System.out.println("The length of longest sub array :"+longestSubarrayWithSum(arr, n, sum));

    }

    static int longestSubarrayWithSum(int arr[], int n, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pre_sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            pre_sum += arr[i];
            if (pre_sum == sum) {
                maxLen = i + 1;
            }

            if (!map.containsKey(pre_sum)) {
                map.put(pre_sum, i);
            }

            if (map.containsKey(pre_sum - sum)) {

                if (maxLen < (i - map.get(pre_sum - sum))) {
                    maxLen = i - map.get(pre_sum - sum);
                }

            }
        }

        return maxLen;
    }
}
