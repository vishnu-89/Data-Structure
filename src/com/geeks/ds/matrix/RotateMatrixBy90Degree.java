package com.geeks.ds.matrix;

/**
 * Given a matrix rotate the matrix in anti-clockwise by 90 degree
 */
public class RotateMatrixBy90Degree {

    public static void main(String args[]) {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n = arr.length;
        rotate90AntiClockwise(arr, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotateBy90(int mat[][], int n) {

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                swap(mat, i, j);

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;

            while (low < high) {
                swap2(mat, low, high, i);

                low++;
                high--;
            }
        }
    }

    static void swap(int mat[][], int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    static void swap2(int mat[][], int low, int high, int i) {
        int temp = mat[low][i];
        mat[low][i] = mat[high][i];
        mat[high][i] = temp;
    }

    // In place rotation
    static void rotate90AntiClockwise(int a[][], int N) {

        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {

                int temp = a[i][j];
                a[i][j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = temp;
            }
        }
    }
}
