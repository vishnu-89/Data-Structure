package com.geeks.ds.matrix;

/**
 * Given a boolean matrix of size m*n where each cell contains either 0 or 1,
 * modify it such that if a matrix cell matrix[i][j] is 1 then all
 * the cells in its ith row and jth column will become 1.
 */
public class BooleanMatrix {

    public static void main(String args[]) {

        int mat[][] = {
                {1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        System.out.println("Input Matrix :");
        printMatrix(mat);

        modifyMatrix(mat);

        System.out.println("Matrix After Modification :");
        printMatrix(mat);

    }

    public static void modifyMatrix(int mat[][]) {

        boolean row_flag = false;
        boolean col_flag = false;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 && mat[i][j] == 1)
                    row_flag = true;

                if (j == 0 && mat[i][j] == 1)
                    col_flag = true;

                if (mat[i][j] == 1) {

                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }

            }
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {

                if (mat[0][j] == 1 || mat[i][0] == 1) {
                    mat[i][j] = 1;
                }
            }
        }

        if (row_flag == true) {
            for (int i = 0; i < mat[0].length; i++) {
                mat[0][i] = 1;
            }
        }

        if (col_flag == true) {
            for (int i = 0; i < mat.length; i++) {
                mat[i][0] = 1;
            }
        }
    }

    public static void modifyMatrixBruteForce(int mat[][], int R, int C) {
        int row[] = new int[R];
        int col[] = new int[C];
        int i, j;

        for (i = 0; i < R; i++) {
            row[i] = 0;
        }

        for (i = 0; i < C; i++) {
            col[i] = 0;
        }

        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (mat[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    mat[i][j] = 1;
                }
            }
        }
    }

    public static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println("");
        }
    }
}
