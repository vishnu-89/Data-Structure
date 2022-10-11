package com.geeks.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find all elements in array that appear more than n/k times
 */
public class MoreThanNbyK {

    public static void main(String[] args) {
        int arr[] = {10, 10, 20, 30, 20, 10, 10};

        int n = arr.length;
        int k = 2;
        printNByK(arr, n, k);

    }

    static void printNByK(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > n / k) {
                System.out.print(e.getKey() + " ");
            }
        }

    }
}