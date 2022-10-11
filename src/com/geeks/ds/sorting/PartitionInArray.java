package com.geeks.ds.sorting;

/**
 * Write an algorithm to partition an array
 */
public class PartitionInArray {

    public static void main(String[] args) {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};

        int n = arr.length;
        lomutoPartition(arr, 0, n - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

    //Lomuto partition

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

    static int hoarePartition(int arr[], int l, int h) {
        int pivot = arr[l];
        int i = l - 1;
        int j = h + 1;
        while (true) {

            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}
