package com.geeks.ds.arrays;

/**
 * Given an array arr[] of integers, find out the maximum difference between any two elements such that larger
 * element appears after the smaller number.
 */

public class MaximumDifferenceWithOrder {

    public static void main(String [] args) {
        int [] ar = {3, 17, 4, 18, 5, 2};
        int len = ar.length;

        System.out.println("Maximum difference  : "+maxDiff(ar, len));

    }

    private static int maxDiff(int arr[], int len) {
        int maxDiff = arr[1] - arr[0];
        int minElement = arr[0];
        int i;
        for (i = 1; i < len; i++) {
            if (arr[i] - minElement > maxDiff) {
                maxDiff = arr[i] - minElement;
            }
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
        }
        return maxDiff;
    }
}

