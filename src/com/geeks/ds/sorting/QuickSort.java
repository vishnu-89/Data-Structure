package com.geeks.ds.sorting;

/**
 * Write a quick sort algorithm to sort an array
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {8, 4, 7, 9, 3, 10, 5};

        int n = arr.length;
        quickSort(arr, 0, n - 1);

        for (int x : arr)
            System.out.print(x + " ");

    }

    static void quickSort(int arr[], int l, int h) {
        if (l < h) {
            int p = lomutoPartition(arr, l, h);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, h);
        }
    }

    static int lomutoPartition(int arr[], int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;
        return i + 1;
    }

    // Quick sort using hoare partition algorithm

    static void qSort(int arr[], int l, int h) {
        if (l < h) {
            int p = hoarePartition(arr, l, h);
            qSort(arr, l, p);
            qSort(arr, p + 1, h);
        }
    }

    static int hoarePartition(int arr[], int l, int h) {
        int pivot = arr[l];
        int i = l - 1, j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}
