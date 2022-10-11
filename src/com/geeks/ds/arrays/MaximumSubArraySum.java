package com.geeks.ds.arrays;

/**
 * Find the maximum sum of subarray from the given array
 */
public class MaximumSubArraySum {

    public static void main(String args[]) {
        int ar[] = {1, -2, 3, -1, 5};
        int len = ar.length;

        System.out.println(maxSubArraySum(ar, len));

    }

   private static int maxSubArraySum(int ar[], int len) {
        int currentSum = ar[0];

        int maxSum = currentSum;

        for(int i = 1; i < len; i++) {
            currentSum = Math.max(currentSum + ar[i], ar[i]);

            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
