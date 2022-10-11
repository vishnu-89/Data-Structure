package com.geeks.ds.matrix;

/**
 *
 */
public class ExchangeMatrixRow {

    public static void main(String args[]) {
        int mat[][] = {
                {8, 9, 7, 6},
                {4, 7, 6, 5},
                {3, 2, 1, 8},
                {9, 9, 7, 7}
        };

        exchangeFirstLastRow(mat, mat.length);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void exchangeFirstLastRow(int mat[][], int rows) {

        for (int i = 0; i < mat[0].length; i++) {
            int t = mat[0][i];
            mat[0][i] = mat[rows - 1][i];
            mat[rows - 1][i] = t;
        }
    }
}
