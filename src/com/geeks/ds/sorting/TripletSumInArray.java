package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
 */
public class TripletSumInArray {

    public static void main(String[] args) {
        int ar[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        int len = ar.length;

        find3Numbers(ar, len, sum);
    }

    static boolean find3Numbers(int ar[], int n, int sum) {
        int l;
        int r;

        Arrays.sort(ar);

        for (int i = 0; i < n - 2; i++) {

            l = i + 1;
            r = n - 1;
            while (l < r) {
                if (ar[i] + ar[l] + ar[r] == sum) {
                    System.out.print("Triplet is " + ar[i] + ", " + ar[l] + ", " + ar[r]);
                    return true;
                } else if (ar[i] + ar[l] + ar[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return false;
    }
}
