package com.geeks.ds.sorting;

/**
 * Write an algorithm for insertion sort
 */
public class IntertionSort {

    public static void main(String[] args) {
        int arr[] = {50, 20, 40, 60, 10, 30};

        int n = arr.length;
        insertionSort(arr, n);

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

    static void insertionSort(int arr[], int n) {

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
