package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of distinct integers, find the closest (positive wise) greater on left of every element.
 * If there is no greater element on left, then print -1
 */
public class PreviousGreaterElement {

    public static void main(String[] args) {

        int[] arr = {20, 30, 10, 5, 15};

        printPrevGreater(arr, arr.length);

    }

    public static void printPrevGreater(int arr[], int n) {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(arr[0]);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int pg = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(pg + " ");
            stack.add(arr[i]);
        }
    }
}
