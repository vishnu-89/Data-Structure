package com.geeks.ds.matrix;

/**
 * Given a square matrix of size N*N, print the sum of upper and lower triangular elements.
 * Upper Triangle consists of elements on the diagonal and above it.
 * The lower triangle consists of elements on the diagonal and below it.
 */
public class SumUpperAndLowerTriangle {

    public static void main(String[] args) {

        int mat[][] = {
                {6, 5, 4, 2},
                {1, 2, 5, 8},
                {7, 9, 7, 6},
                {1, 4, 3, 5}
        };

        sum(mat, mat.length, mat[0].length);
    }

    static void sum(int mat[][], int r, int c) {
        int i, j;
        int upper_sum = 0;
        int lower_sum = 0;

        // Calculate sum of upper triangle
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (i <= j) {
                    upper_sum += mat[i][j];
                }
            }
        }
        System.out.println("Upper triangle sum is " + upper_sum);

        // Calculate sum of lower triangle
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (j <= i) {
                    lower_sum += mat[i][j];
                }
            }
        }
        System.out.print("Lower triangle sum is " + lower_sum);
    }
}
