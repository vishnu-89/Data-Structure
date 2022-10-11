package com.geeks.ds.hashing;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given two integer arrays A1[ ] and A2[ ] of size N and M respectively. Sort the first array A1[ ]
 * such that all the relative positions of the elements in the first array are
 * the same as the elements in the second array A2[ ].
 */
public class SortAnArrayAccordingToOther {

    public static void main(String[] args) {
        int[] first = {5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4};
        int[] second = {3, 5, 7, 2};

        customSort(first, second);
    }

    public static void customSort(int[] first, int[] second) {
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int i : first) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        int index = 0;
        for (int i : second) {
            int n = freq.getOrDefault(i, 0);
            while (n-- > 0) {
                first[index++] = i;
            }
            freq.remove(i);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                first[index++] = entry.getKey();
            }
        }

        for(int i : first) {
            System.out.print(first[i]+" ");
        }
    }
}
