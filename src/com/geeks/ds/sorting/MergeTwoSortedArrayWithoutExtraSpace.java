package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
 * Merge them in sorted order without using any extra space
 */
public class MergeTwoSortedArrayWithoutExtraSpace {

    public static void main(String[] args) {
        int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
        int arr2[] = new int[]{2, 3, 8, 13};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.print("After Merging \nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }

    static void merge(int arr1[], int arr2[], int m, int n) {
        int i = 0;
        int j = 0;
        int k = m - 1;
        while (i <= k && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    static void merge1(int arr1[], int arr2[], int n, int m) {
        int i = 0;
        int temp = 0;

        while (arr1[n - 1] > arr2[0]) {
            if (arr1[i] > arr2[0]) {

                temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                Arrays.sort(arr2);
            }
            i++;
        }
    }
}
