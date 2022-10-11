package com.geeks.ds.sorting;

/**
 * Given two sorted array find the intersection
 */
public class IntersectionOfTwoSortedArray {

    public static void main(String[] args) {
        int ar[] = {3, 5, 10, 10, 10, 15, 15, 20};
        int br[] = {5, 10, 10, 15, 30};

        int m = ar.length;
        int n = br.length;
        intersection(ar, br, m, n);

    }

    static void intersection(int a[], int b[], int m, int n) {

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (i > 0 && a[i - 1] == a[i]) {
                i++;
                continue;
            }
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
    }
}
