package com.geeks.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers find the frequency of each element
 */
public class FrequencyOfArrayElement {

    public static void main(String[] args) {
        int arr[] = {15, 16, 27, 27, 28, 28, 16};
        int n = arr.length;

        countFrequency(arr, n);
    }

    static void countFrequency(int arr[], int n) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }

        }

        for (Map.Entry<Integer, Integer> itr : hm.entrySet()) {
            System.out.println(itr.getKey() + " " + itr.getValue());
        }

    }

}
