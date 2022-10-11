package com.geeks.ds.sorting;

/**
 * Write an algorithm to segregate an array in which array contains three different kind of elements
 * The three different can of below type -
 * Sort an array of 0s, 1s, 2s.
 * Three-way partitioning when multiple occurrences of a pivot may exist.
 * Partitioning around a range.
 */
public class SortArrayWithThreeTypeOfElement {

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 0, 1, 1, 2};

        int n = arr.length;

        sort(arr, n);

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

    static void sort(int arr[], int n) {
        int l = 0;
        int h = n - 1;
        int mid = 0;
        while (mid <= h) {
            switch (arr[mid]) {
                case 0:
                    int temp = arr[l];
                    arr[l] = arr[mid];
                    arr[mid] = temp;

                    l++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[h];
                    arr[h] = arr[mid];
                    arr[mid] = temp;

                    h--;
                    break;
            }
        }

    }
}
