package com.geeks.ds.matrix;

/**
 * Print the spiral traversal of a matrix
 */
public class SpiralTraversal {

    public static void main(String args[]) {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        spiralTraversal(arr, arr.length, arr[0].length);

    }

    static void spiralTraversal(int mat[][], int R, int C) {
        int top = 0;
        int left = 0;
        int bottom = R - 1;
        int right = C - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(mat[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(mat[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(mat[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(mat[i][left] + " ");
                }
                left++;
            }
        }
    }
}
