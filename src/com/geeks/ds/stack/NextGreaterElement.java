package com.geeks.ds.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * Given an array of distinct integers, find the NextGreater(position-wise closest and on the right side) of every array elements.
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] arr = {5, 15, 10, 8, 6, 12, 9, 18};

        for (int x : nextGreater(arr, arr.length)) {
            System.out.print(x + " ");
        }

    }

    public static ArrayList<Integer> nextGreater(int arr[], int n) {
        ArrayList<Integer> v = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(arr[n - 1]);
        v.add(-1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            int ng = stack.isEmpty() ? -1 : stack.peek();
            v.add(ng);
            stack.add(arr[i]);
        }
        Collections.reverse(v);
        return v;
    }
}
