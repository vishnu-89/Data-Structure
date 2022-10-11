package com.geeks.ds.searching;

/**
 * Given a sorted array with repetition and an element k, we need to find index of first occurrence of k.
 */
public class IndexOfFirstOccurenceInSortedArray {

    public static void main(String args[]) {
        int ar[] = {5, 10, 10, 10,15, 20, 20, 20};
        int n = 7;
        int x = 10;

        System.out.println(firstOccurence(ar, 0, n - 1, x));
    }

    static int firstOccurence(int arr[], int low, int high, int x) {
        if(low > high)
            return -1;
        int mid = (low + high) / 2;

        if(x > arr[mid]) {
            return firstOccurence(arr, mid + 1, high, x);
        }
        else if(x < arr[mid]) {
            return firstOccurence(arr, low, mid - 1, x);
        }
        else {
            if(mid == 0 || arr[mid - 1] != arr[mid]) {
                return mid;
            }
            else {
                return firstOccurence(arr, low, mid - 1, x);
            }

        }
    }
}
