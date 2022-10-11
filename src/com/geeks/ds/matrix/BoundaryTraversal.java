package com.geeks.ds.matrix;

/**
 * Print matrix boundary traversal problem ie. first row left to right, last column top to bottom,
 * last row right to left and first column bottom to top
 */
public class BoundaryTraversal {

    public static void main(String args[]) {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        boundaryTraversal(arr, arr.length,arr[0].length);
    }

    static void boundaryTraversal(int mat[][], int R, int C) {
        if (R == 1) {
            for (int i = 0; i < C; i++)
                System.out.print(mat[0][i] + " ");
        } else if (C == 1) {
            for (int i = 0; i < R; i++)
                System.out.print(mat[i][0] + " ");
        } else {
            for (int i = 0; i < C; i++)
                System.out.print(mat[0][i] + " ");
            for (int i = 1; i < R; i++)
                System.out.print(mat[i][C - 1] + " ");
            for (int i = C - 2; i >= 0; i--)
                System.out.print(mat[R - 1][i] + " ");
            for (int i = R - 2; i >= 1; i--)
                System.out.print(mat[i][0] + " ");
        }

    }
}
