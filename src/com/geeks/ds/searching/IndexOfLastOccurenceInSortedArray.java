package com.geeks.ds.searching;

/**
 * Given a sorted array with repetition and an element k, we need to find index of last occurrence of k.
 */
public class IndexOfLastOccurenceInSortedArray {

    public static void main(String args[]) {
        int arr[] = {5, 10, 10, 10, 10, 20, 20};
        int n = 7;
        int x = 10;
        System.out.println(indexOfLastOccurence(arr, 0, n - 1, x, n));
    }

    static int indexOfLastOccurence(int arr[], int low, int high, int x, int n) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (x > arr[mid]) {
            return indexOfLastOccurence(arr, mid + 1, high, x, n);
        } else if (x < arr[mid]) {
            return indexOfLastOccurence(arr, low, mid - 1, x, n);
        } else {
            if (mid == n - 1 || arr[mid + 1] != arr[mid]) {
                return mid;
            } else {
                return indexOfLastOccurence(arr, mid + 1, high, x, n);
            }

        }
    }
}
