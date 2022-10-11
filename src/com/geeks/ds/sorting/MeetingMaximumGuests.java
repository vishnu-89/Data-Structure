package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * You are given arrival and departure times of the guests, you need to find the time to go to the party
 * so that you can meet maximum people.
 */
public class MeetingMaximumGuests {

    public static void main(String[] args) {
        int arr[] = {900, 600, 700};
        int dep[] = {1000, 800, 730};
        int n = arr.length;

        System.out.print(maxGuest(arr, dep, n));

    }

    static int maxGuest(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1;
        int j = 0;
        int res = 1;
        int curr = 1;

        while (i < n && j < n) {
            if (arr[i] < dep[j]) {
                curr++;
                i++;
            } else {
                curr--;
                j++;
            }
            res = Math.max(curr, res);
        }
        return res;
    }
}
