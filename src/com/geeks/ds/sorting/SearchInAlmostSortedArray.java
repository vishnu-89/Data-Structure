package com.geeks.ds.sorting;

/**
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions,
 * i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
 * Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 * For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
 */
public class SearchInAlmostSortedArray {

    public static void main(String args[]) {
        int arr[] = {3, 2, 10, 4, 40};
        int n = arr.length;
        int x = 4;
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1) {
            System.out.println("Element is not present in array");
        } else {
            System.out.println("Element is present at index " + result);
        }

    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;
            if (mid > l && arr[mid - 1] == x)
                return (mid - 1);
            if (mid < r && arr[mid + 1] == x)
                return (mid + 1);

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 2, x);

            return binarySearch(arr, mid + 2, r, x);
        }

        return -1;
    }
}
