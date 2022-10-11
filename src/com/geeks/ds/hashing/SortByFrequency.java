package com.geeks.ds.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first.
 * If frequencies of two elements are same, then smaller number comes first.
 */
public class SortByFrequency {

    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 1, 1, 8, 3, 6, 8, 7, 8};

        sortByFrequencyAndIndex(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortByFrequencyAndIndex(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Map<Integer, Data> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.putIfAbsent(arr[i], new Data(arr[i], 0, i));
            hm.get(arr[i]).count++;
        }

        List<Data> values = hm.values().stream()
                .sorted()
                .collect(Collectors.toList());

        int k = 0;
        for (Data data : values) {
            for (int j = 0; j < data.count; j++) {
                arr[k++] = data.value;
            }

        }
    }
}

class Data implements Comparable<Data> {
    int value, count, index;

    public Data(int value, int count, int index) {
        this.value = value;
        this.count = count;
        this.index = index;
    }

    public int compareTo(Data obj) {
        if (this.count != obj.count) {
            return obj.count - this.count;
        }
        return this.index - obj.index;
    }
}