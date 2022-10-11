package com.geeks.ds.sorting;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of n distinct elements and a number k, arrange array elements according to the absolute difference with k,
 * For example, an element having minimum difference comes first, and so on.
 * Note: If two or more elements are at equal distance arrange them in the same sequence as in the given array.
 */
public class SortByAbsoluteDifference {

    public static void main(String args[]) {
        int[] arr = {10, 5, 3, 9, 2};
        int n = arr.length;
        int x = 7;
        rearrange(arr, n, x);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    static void rearrange(int[] arr, int n, int x) {
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(x - arr[i]);
            if (m.containsKey(diff)) {
                ArrayList<Integer> al = m.get(diff);
                al.add(arr[i]);
                m.put(diff, al);
            } else {
                ArrayList<Integer> al = new
                        ArrayList<>();
                al.add(arr[i]);
                m.put(diff, al);
            }
        }

        int index = 0;
        for (Map.Entry entry : m.entrySet()) {
            ArrayList<Integer> al = m.get(entry.getKey());
            for (int i = 0; i < al.size(); i++) {
                arr[index++] = al.get(i);
            }
        }
    }
}
