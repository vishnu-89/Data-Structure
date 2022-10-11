package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpan {

    public static void main(String[] args) {

        int[] arr = new int[]{18, 12, 13, 14, 11, 16};

        printSpan(arr, arr.length);

    }

    public static void printSpan(int arr[], int n) {
        Deque<Integer> s = new ArrayDeque<>();
        s.add(0);
        System.out.print(1 + " ");
        for (int i = 1; i < n; i++) {
            while (s.isEmpty() == false && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            int span = s.isEmpty() ? i + 1 : i - s.peek();
            System.out.print(span + " ");
            s.push(i);
        }
    }
}
