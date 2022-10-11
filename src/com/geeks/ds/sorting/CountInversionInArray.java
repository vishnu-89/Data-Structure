package com.geeks.ds.sorting;

/**
 * Given an array find the inversion of it.
 * Inversion Count for an array indicates that how far (or close) the array is from being sorted.
 * If the array is already sorted, then the inversion count is 0, but if the array is sorted in the reverse order,
 * the inversion count is the maximum.
 */
public class CountInversionInArray {

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};

        int n = arr.length;
        System.out.print(countInversion(arr, 0, n - 1));

    }

    static int countInversion(int arr[], int l, int r) {
        int res = 0;
        if (l < r) {

            int m = (r + l) / 2;

            res += countInversion(arr, l, m);
            res += countInversion(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    static int countAndMerge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + l];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }

        int res = 0;
        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                res = res + (n1 - i);
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
        return res;
    }

}
