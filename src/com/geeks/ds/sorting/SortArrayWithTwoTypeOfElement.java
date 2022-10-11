package com.geeks.ds.sorting;

/**
 * List of algorithm to sort an array of two different type
 */
public class SortArrayWithTwoTypeOfElement {

    public static void main(String[] args) {
        int arr[] = {13, -12, 18, -10};

        int n = arr.length;

        sort(arr, n);

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

    // Segregate negative and positive elements.
    static void sort(int arr[], int n) {
        int i = -1;
        int j = n;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);

            do {
                j--;
            } while (arr[j] >= 0);

            if (i >= j) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }

    // Sort a binary array.
    static void segregate0and1(int arr[], int n) {
        int type0 = 0;
        int type1 = n - 1;

        while (type0 < type1) {
            if (arr[type0] == 1) {

                arr[type0] = arr[type0] + arr[type1];
                arr[type1] = arr[type0] - arr[type1];
                arr[type0] = arr[type0] - arr[type1];
                type1--;
            } else {
                type0++;
            }
        }
    }

    // Segregate even and odd element
    static void segregateEvenOdd(int arr[]) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (arr[left] % 2 == 0 && left < right) {
                left++;
            }

            while (arr[right] % 2 == 1 && left < right) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
