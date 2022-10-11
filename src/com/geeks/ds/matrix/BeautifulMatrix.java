package com.geeks.ds.matrix;

/**
 * A beautiful matrix is a matrix in which the sum of elements in each row and column is equal.
 * Given a square matrix of size NxN. Find the minimum number of operations that are required to make the matrix beautiful.
 * In one operation you can increment the value of any one cell by 1.
 */
public class BeautifulMatrix {

    public static void main(String[] args) {
        int arr[][] = {
                {1, 2},
                {3, 4}
        };
        int n = arr.length;
        System.out.println(findMinOpeartion(arr, n));

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    static int findMinOpeartion(int matrix[][], int n) {

        int[] sumRow = new int[n];
        int[] sumCol = new int[n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                sumRow[i] += matrix[i][j];
                sumCol[j] += matrix[i][j];
            }
        }

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, sumRow[i]);
            maxSum = Math.max(maxSum, sumCol[i]);
        }

        int count = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {

            int diff = Math.min(maxSum - sumRow[i], maxSum - sumCol[j]);

            matrix[i][j] += diff;
            sumRow[i] += diff;
            sumCol[j] += diff;

            count += diff;

            if (sumRow[i] == maxSum) {
                ++i;
            }

            if (sumCol[j] == maxSum) {
                ++j;
            }

        }
        return count;
    }
}
