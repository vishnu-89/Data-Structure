package com.geeks.ds.sorting;

/**
 * Write bubble sort algorithm
 */
public class BubbleSort {

    public static void main(String[] args) {
        int ar[] = {2, 3, 4, 1};
        bubbleSort(ar, ar.length);

        for (int i = 0; i < 4; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    static void optimizedBubbleSort(int arr[], int n) {
        boolean swapped;

        for (int i = 0; i < n; i++) {

            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }
}
