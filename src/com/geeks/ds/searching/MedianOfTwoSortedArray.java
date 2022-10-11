package com.geeks.ds.searching;

/**
 * Find the median of two sorted array
 */
public class MedianOfTwoSortedArray {

    public static void main(String args[]) {

        int ar1[] = {10, 20, 30, 40, 50};
        int len1 = ar1.length;
        int ar2[] = {5, 15, 25, 35, 45};
        int len2 = ar2.length;

        System.out.println(getMedian(ar1, ar2, len1, len2));

    }

    static double getMedian(int ar1[], int ar2[], int len1, int len2) {
        int begin1 = 0;
        int end1 = len1;

        while (begin1 < end1) {
            int i1 = (begin1 + end1) / 2;
            int i2 = ((len1 + len2 + 1) / 2) - i1;

            int min1 = (i1 == len1) ? Integer.MAX_VALUE : ar1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : ar1[i1 - 1];

            int min2 = (i2 == len2) ? Integer.MAX_VALUE : ar2[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : ar2[i2 - 1];

            if (max1 <= min2 && max2 <= min1) {
                if ((len1 + len2) % 2 == 0) {
                    return ((double) Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                } else {
                    return (double) Math.max(max1, max2);
                }
            } else if (max1 > min2) {
                end1 = i1 - 1;
            } else {
                begin1 = i1 + 1;
            }

        }

        return -1;
    }
}
