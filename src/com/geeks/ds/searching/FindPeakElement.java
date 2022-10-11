package com.geeks.ds.searching;

/**
 * Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours.
 */
public class FindPeakElement {

    public static void main(String args[]) {

        int arr[] = {5, 20, 40, 30, 20, 50, 60}, n = 7;

        System.out.println("The peak element is : "+findPeak(arr, n));

    }

    static int findPeak(int arr[], int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            }

            if (mid > 0 && arr[mid - 1] >= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }
}
