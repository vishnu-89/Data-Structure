package com.geeks.ds.backtracking;

/**
 * A Maze is given as N*N matrix of blocks where source block is the upper left most block
 * i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1].
 * Find if it is possible for the rat to reach from the source block to the destination block.
 * The number of steps rat can jump from (i, j) is represented by maze[i][j].
 */
public class RatMazeWithMultipleJumps {

    static int N = 4;

    public static void main(String[] args) {
        int maze[][] = {
                {2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}
        };

        solveMaze(maze);
    }

    static boolean solveMaze(int maze[][]) {
        int sol[][] = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.printf("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {

        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {

            sol[x][y] = 1;

            for (int i = 1; i <= maze[x][y] && i < N; i++) {

                if (solveMazeUtil(maze, x + i, y, sol) ) {
                    return true;
                }
                if (solveMazeUtil(maze, x, y + i, sol) ) {
                    return true;
                }
            }

            sol[x][y] = 0;
        }

        return false;
    }

    static boolean isSafe(int maze[][], int x, int y) {

        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] != 0);
    }

    static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(" %d ", sol[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
