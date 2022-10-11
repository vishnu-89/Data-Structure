package com.geeks.ds.arrays;

/**
 * Given n numbers (both +ve and -ve), arranged in a circle, find the maximum sum of consecutive numbers.
 */
public class MaxCircularSubarraySum {

    public static void main(String args[]) {
        int arr[] = {8, -4, 3, -5, 4}, n = 5;

        System.out.println(maxCircularSum(arr, n));

    }

    private static int overallMaxSum(int ar[], int len) {
        int max_normal = normalMaxSum(ar, len);

        if(max_normal < 0) {
            return max_normal;
        }

        int arr_sum = 0;

        for(int i = 0; i < len; i++) {
            arr_sum += ar[i];
            ar[i] = -ar[i];
        }

        int max_circular = arr_sum + normalMaxSum(ar, len);

        return Math.max(max_circular, max_normal);
    }

    private static int normalMaxSum(int ar[], int len) {
        int curSum = ar[0];

        int maxSum = curSum;

        for(int i = 1; i < len; i++) {
            curSum = Math.max(curSum + ar[i], ar[i]);
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }

    // Solution 2
    public static int maxCircularSum(int a[], int n) {

        if (n == 1) {
            return a[0];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        int curr_max = a[0];
        int max_so_far = a[0];
        int curr_min = a[0];
        int min_so_far = a[0];

        for (int i = 1; i < n; i++) {

            curr_max = Math.max(curr_max + a[i], a[i]);
            max_so_far = Math.max(max_so_far, curr_max);

            curr_min = Math.min(curr_min + a[i], a[i]);
            min_so_far = Math.min(min_so_far, curr_min);
        }
        if (min_so_far == sum) {
            return max_so_far;
        }

        return Math.max(max_so_far, sum - min_so_far);
    }


}
