package com.geeks.ds.matrix;

/**
 * Print a matrix in snake pattern ie. first row should be printed from left to right, second row from right to left, and so on
 */
public class SnakePattern {

    public static void main(String args[]) {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int R = arr.length;
        int C = arr[0].length;
        printSnake(arr, R, C);
    }

    static void printSnake(int mat[][], int R, int C) {
        for (int i = 0; i < R; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < C; j++) {
                    System.out.print(mat[i][j] + " ");
                }
            } else {
                for (int j = C - 1; j >= 0; j--) {
                    System.out.print(mat[i][j] + " ");
                }

            }


        }
    }
}
