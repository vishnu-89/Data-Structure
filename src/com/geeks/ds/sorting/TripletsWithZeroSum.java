package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
 */
public class TripletsWithZeroSum {

    public static void main(String[] args) {

        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        findTriplets(arr, n);
    }

    static void findTriplets(int arr[], int n) {
        boolean found = false;
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (arr[i] + arr[l] + arr[r] == 0) {
                    System.out.print(arr[i] + " ");
                    System.out.print(arr[l] + " ");
                    System.out.println(arr[r] + " ");

                    l++;
                    r--;
                    found = true;
                } else if (arr[i] + arr[l] + arr[r] < 0) {
                    l++;
                } else {
                    r--;
                }

            }
        }

        if (found == false) {
            System.out.println(" No Triplet Found");
        }

    }
}
