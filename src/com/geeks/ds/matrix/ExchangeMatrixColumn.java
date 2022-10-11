package com.geeks.ds.matrix;

/**
 * Given a m x n matrix, the task is to exchange the elements of first and last columns and show the resulting matrix.
 */
public class ExchangeMatrixColumn {

    public static void main(String[] args) {
        int mat[][] = {
                {8, 9, 7, 6},
                {4, 7, 6, 5},
                {3, 2, 1, 8},
                {9, 9, 7, 7}
        };

        int n = mat[0].length;
        exchangeFirstLastColoumn(mat,n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void exchangeFirstLastColoumn(int m[][], int n) {

        for (int i = 0; i < n; i++) {
            int t = m[i][0];
            m[i][0] = m[i][n - 1];
            m[i][n - 1] = t;
        }
    }
}
