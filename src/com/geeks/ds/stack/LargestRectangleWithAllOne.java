package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
 */
public class LargestRectangleWithAllOne {

    public static void main(String[] args) {
        int R = 4;
        int C = 4;

        int mat[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.print("Area of maximum rectangle is " + maxRectangle(R, C, mat));
    }

    static int maxRectangle(int R, int C, int mat[][]) {
        int res = largestHist(R, C, mat[0]);

        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
            res = Math.max(res, largestHist(R, C, mat[i]));
        }

        return res;
    }

    public static int largestHist(int R, int C, int arr[]) {
        Deque<Integer> result = new ArrayDeque<>();

        int top_val;
        int max_area = 0;
        int area = 0;

        int i = 0;
        while (i < C) {
            if (result.isEmpty() || arr[result.peek()] <= arr[i]) {
                result.push(i++);
            } else {
                top_val = arr[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.isEmpty()) {
                    area = top_val * (i - result.peek() - 1);
                }
                max_area = Math.max(area, max_area);
            }
        }

        while (!result.isEmpty()) {
            top_val = arr[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.isEmpty()) {
                area = top_val * (i - result.peek() - 1);
            }

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
}
