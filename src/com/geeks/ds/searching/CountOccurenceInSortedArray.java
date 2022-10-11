package com.geeks.ds.searching;

/**
 * Given a sorted array and an element k, we need to count occurrences of k in the array.
 */
public class CountOccurenceInSortedArray {

    public static void main(String args[]) {
        int arr[] = {10, 20, 20, 20, 40, 40};
        int len = 6;
        int x = 20;

        System.out.println(countOccurence(arr, len, x));

    }

    static int firstOccurence(int arr[], int n, int x) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }

            }

        }

        return -1;
    }

    static int lastOccurence(int arr[], int n, int x) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] != arr[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }

            }

        }

        return -1;
    }


    static int countOccurence(int arr[], int n, int x) {
        int first = firstOccurence(arr, n, x);

        if (first == -1)
            return 0;
        else
            return lastOccurence(arr, n, x) - first + 1;
    }
}
