package com.geeks.ds.searching;

import java.util.HashSet;

/**
 * Use two pointer approach to fine below problems
 */
public class TwoPointerApproach {

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printPairs(A, n);
    }

    // Find pair in unsorted array which gives sum X
    static void printPairs(int arr[], int sum) {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if (s.contains(temp)) {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
            }
            s.add(arr[i]);
        }
    }

    // Find pair in sorted array which gives sum X
    static int isSumPresent(int arr[], int n, int sum) {
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            if (arr[l] + arr[h] == sum) {
                return 1;
            } else if (arr[l] + arr[h] > sum) {
                h--;
            } else {
                l++;
            }
        }

        return 0;
    }

    // Find triplet in an array which gives sum X

    boolean find3Numbers(int A[], int len, int sum) {
        int l, r;

        for (int i = 0; i < len - 2; i++) {

            l = i + 1;
            r = len - 1;
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    return true;
                } else if (A[i] + A[l] + A[r] < sum) {
                    l++;
                } else { // A[i] + A[l] + A[r] > sum
                    r--;
                }

            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
}
