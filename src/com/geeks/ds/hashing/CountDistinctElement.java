package com.geeks.ds.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers where number can be repeated count the distinct element
 */
public class CountDistinctElement {

    public static void main(String[] args) {
        int arr[] = {15, 16, 27, 27, 28, 28, 16};
        int n = arr.length;

        System.out.println(countDistinctElement(arr, n));
    }

    static int countDistinctElement(int arr[], int n) {
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }

        return hs.size();
    }
}
