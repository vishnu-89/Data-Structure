package com.geeks.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the first non-repeating element in a given array of integers.
 */
public class CountNonRepeatedElement {

    public static void main(String[] args) {
        int arr[] = {9, 4, 9, 6, 7, 4};
        int n = arr.length;
        System.out.println(firstNonRepeating(arr, n));
    }

    static int firstNonRepeating(int arr[], int n) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return -1;
    }
}
