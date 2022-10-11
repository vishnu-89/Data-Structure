package com.geeks.ds.sorting;

/**
 * Given two sorted array merge them and output should be sorted
 */
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int ar[] = {10, 15, 20, 40};
        int br[] = {5, 6, 6, 10, 15};

        int m = ar.length;
        int n = br.length;
        merge(ar, br, m, n);

    }

    static void merge(int a[], int b[], int m, int n) {

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            
            if (a[i] < b[j]) {
                System.out.print(a[i++] + " ");
            } else {
                System.out.print(b[j++] + " ");
            }

        }
        while (i < m) {
            System.out.print(a[i++] + " ");
        }
        while (j < n) {
            System.out.print(b[j++] + " ");
        }

    }
}
