package com.geeks.ds.matrix;

/**
 * Search an element in a row-wise and column-wise sorted matrix
 */
public class SearchInRowColumnWiseSortedMatrix {

    public static void main(String args[]) {
        int arr[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 35, 45},
                {32, 33, 39, 50}
        };
        int x = 29;

        search(arr, x, arr.length, arr[0].length);

    }

    static void search(int mat[][], int x, int R, int C) {
        int i = 0;
        int j = C - 1;

        while (i < R && j >= 0) {
            if (mat[i][j] == x) {
                System.out.println("Found at (" + i + ", " + j + ")");
                return;
            } else if (mat[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not Found");
    }
}
