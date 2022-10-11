package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Calculate the Largest Rectangular Area in a Histogram.
 */
public class LargestRetangularAreaInHistogram {

    public static int getMaxArea(int arr[], int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int tp;
        int curr;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                tp = stack.peek();
                stack.pop();
                curr = arr[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                res = Math.max(res, curr);
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            tp = stack.peek();
            stack.pop();
            curr = arr[tp] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            res = Math.max(res, curr);
        }

        return res;

    }

    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 4, 1, 5, 6};

        System.out.print("Maximum Area: " + getMaxArea(arr, arr.length));

    }
}
