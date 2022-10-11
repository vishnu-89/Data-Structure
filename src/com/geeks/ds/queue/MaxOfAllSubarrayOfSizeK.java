package com.geeks.ds.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * We are given an array and a number k, we need to find maximums of all subarrays of size k.
 */
public class MaxOfAllSubarrayOfSizeK {

    public static void main(String[] args) {
        int arr[] = {20, 40, 30, 10, 60};
        int k = 3;
        findMaxOfSubarray(arr, arr.length, k);
    }

    static void findMaxOfSubarray(int arr[], int n, int k) {

        Deque<Integer> dq = new ArrayDeque<Integer>();

        for (int i = 0; i < k; ++i) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }


        for (int i = k; i < n; ++i) {
            System.out.print(arr[dq.peek()] + " ");

            while ((!dq.isEmpty()) && dq.peek() <= i - k) {
                dq.removeFirst();
            }

            while ((!dq.isEmpty()) && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }


        System.out.print(arr[dq.peek()]);
    }
}
