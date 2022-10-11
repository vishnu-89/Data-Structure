package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * Given an unsorted array of positive integers, find the number of triangles that can be formed with three different array elements
 * as three sides of triangles. For a triangle to be possible from 3 values, the sum of any of the two values (or sides)
 * must be greater than the third value (or third side).
 */
public class CountPossibleTriangleInArray {

    public static void main(String[] args) {
        int arr[] = {10, 21, 22, 100, 101, 200, 300};
        int size = arr.length;

        System.out.println("Total number of triangles possible :" +
                countTotalTriangles(arr, size));
    }

    static int countTotalTriangles(int[] ar, int n) {
        Arrays.sort(ar);

        int count = 0;

        for (int i = n - 1; i >= 1; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (ar[l] + ar[r] > ar[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}
