package com.geeks.ds.hashing;

import java.util.HashMap;

/**
 * Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s
 */
public class LongestSubArrayWith1And0 {

    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 1, 0, 0};
        int len = arr.length;

        System.out.println(largestSubarrayWithEqualZeroAndOnes(arr, len));
    }

    public static int largestSubarrayWithEqualZeroAndOnes(int arr[], int n) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0;
        int max_len = 0;
        int ending_index = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {

            sum += arr[i];
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }
            if (hm.containsKey(sum)) {
                if (max_len < i - hm.get(sum)) {
                    max_len = i - hm.get(sum);
                    ending_index = i;
                }
            } else {
                hm.put(sum, i);
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println("The longest subarray with zero and ones present at :"+end + " to " + ending_index);

        return max_len;
    }
}
