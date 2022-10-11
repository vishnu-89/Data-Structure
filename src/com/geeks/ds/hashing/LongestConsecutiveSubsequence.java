package com.geeks.ds.hashing;

import java.util.HashSet;

/**
 * Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers,
 * the consecutive numbers can be in any order.
 */
public class LongestConsecutiveSubsequence {

    public static void main(String args[]) {
        int arr[] = {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        
        System.out.println("Length of the Longest consecutive subsequence is :" + findLongestConseqSubseq(arr, n));
    }

    static int findLongestConseqSubseq(int arr[], int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            set.add(arr[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (!set.contains(arr[i] - 1)) {
                int j = arr[i];
                while (set.contains(j)) {
                    j++;
                }

                if (ans < j - arr[i]) {
                    ans = j - arr[i];
                }

            }
        }
        return ans;
    }

}
