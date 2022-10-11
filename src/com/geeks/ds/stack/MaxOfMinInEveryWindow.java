package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an integer array of size n, find the maximum of the minimum’s of every window size in the array. Note that window size varies from 1 to n.
 */
public class MaxOfMinInEveryWindow {


    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 50, 10, 70, 30};
        printMaxOfMin(arr, arr.length);
    }


    static void printMaxOfMin(int[] arr, int n) {
        Deque<Integer> stack = new ArrayDeque<>();

        int left[] = new int[n + 1];
        int right[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int ans[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
