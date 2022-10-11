package com.geeks.ds.searching;

/**
 * Given a sorted binary array, we need to count total 1s in this array.
 */
public class CountOnesInSortedBinaryArray {

    public static void main(String args[]) {
        int arr[] = {0, 0, 1, 1, 1, 1};
        int len = 6;


        System.out.println(countTotalOnes(arr, len));

    }

    static int countTotalOnes(int arr[], int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == 0) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] == 0) {
                    return (n - mid);
                } else {
                    high = mid - 1;
                }

            }
        }

        return 0;
    }
}
