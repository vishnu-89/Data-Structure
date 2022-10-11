package com.geeks.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] of size n, find the first repeating element.
 */
public class FirstRepeatingElement {

    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 4, 3, 5, 6};
        int len = arr.length;

        System.out.println("The first repearing element: "+firstRepeatingElement(arr,len));
    }

    public static int firstRepeatingElement(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) >= 2) {
                return arr[i];
            }
        }
        return -1;
    }
}
