package com.geeks.ds.backtracking;

/**
 * Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors
 * such that no two adjacent vertices of the graph are colored with the same color.
 */

/* Create following graph and
           test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
*/

public class MColoringProblem {

    final int V = 4;
    int color[];

    public static void main(String args[]) {
        MColoringProblem coloring = new MColoringProblem();

        int graph[][] = {
                            { 0, 1, 1, 1 },
                            { 1, 0, 1, 0 },
                            { 1, 1, 0, 1 },
                            { 1, 0, 1, 0 },
                        };
        int m = 3;
        coloring.graphColoring(graph, m);
    }

    boolean graphColoring(int graph[][], int m) {
        color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = 0;
        }

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist ");
            return false;
        }

        printSolution(color);
        return true;
    }

    boolean graphColoringUtil(int graph[][], int m, int color[], int v) {

        if (v == V) {
            return true;
        }

        for (int c = 1; c <= m; c++) {

            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                if (graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }

                color[v] = 0;
            }
        }
        return false;
    }

    boolean isSafe(int v, int graph[][], int color[], int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    void printSolution(int color[]) {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i < V; i++) {
            System.out.print(" " + color[i] + " ");
        }
        System.out.println();
    }
}
