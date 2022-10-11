package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * Given a set of time intervals in any order, merge all overlapping intervals into one and
 * output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity.
 * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. The intervals {1,3} and {2,4} overlap with each other,
 * so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}
 */
public class MergeOverlappingInterval {

    public static void main(String[] args) {
        Interval arr[] = {new Interval(5, 10), new Interval(3, 15), new Interval(18, 30),
                new Interval(2, 7)};

        int n = arr.length;

        mergeIntervals(arr, n);
    }

    static void mergeIntervals(Interval arr[], int n) {
        Arrays.sort(arr);

        int res = 0;

        for (int i = 1; i < n; i++) {
            if (arr[res].e >= arr[i].s) {
                arr[res].e = Math.max(arr[res].e, arr[i].e);
                arr[res].s = Math.min(arr[res].s, arr[i].s);
            } else {
                res++;
                arr[res] = arr[i];
            }
        }

        for (int i = 0; i <= res; i++)
            System.out.print("[" + arr[i].s + ", " + arr[i].e + "] ");
    }
}

class Interval implements Comparable<Interval> {
    int s;
    int e;

    Interval(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public int compareTo(Interval a) {
        return this.s - a.s;
    }
};