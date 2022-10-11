package com.geeks.ds.sorting;

/**
 * Write an algorithm for selection sort
 */
public class SelectionSort {

    public static void main(String[] args) {
        int ar[] = {2, 1, 4, 3};
        selectionSort(ar, ar.length);

        for (int i = 0; i < 4; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int index = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
