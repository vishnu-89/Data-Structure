package com.geeks.ds.searching;

/**
 * Write binary search algorithm both recursuve and iterative
 */
public class BinarySearch {

    public static void main(String args[]) {
        int ar[] = {10, 20, 30, 40, 50, 60};
        int n = 6;
        int x = 25;
        System.out.println(binarySearchIterative(ar, n, x));

    }

    static int binarySearchIterative(int ar[], int n, int x) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (ar[mid] == x) {
                return mid;
            } else if (ar[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    static int binarySearchRecursive(int arr[], int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] > x) {
            return binarySearchRecursive(arr, low, mid - 1, x);
        } else {
            return binarySearchRecursive(arr, mid + 1, high, x);
        }

    }
}
