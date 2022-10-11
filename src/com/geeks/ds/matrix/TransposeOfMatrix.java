package com.geeks.ds.matrix;

/**
 * Print transpose of a matrix.
 */
public class TransposeOfMatrix {

    public static void main(String args[]) {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n = arr.length;
        transpose(arr, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void swap(int mat[][], int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    static void transpose(int mat[][], int n) {

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                swap(mat, i, j);
    }

    // Naive solution
    static void transposeNaive(int mat[][], int n) {
        int temp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                temp[i][j] = mat[j][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = temp[i][j];
        }
    }

}
