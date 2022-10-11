package com.geeks.ds.sorting;

import java.util.ArrayList;

/**
 * Given 3 arrays (A, B, C) which are sorted in ascending order, we are required to merge them together
 * in ascending order and output the array D.
 */
public class MergeThreeSortedArray {

    public static void main(String[] args) {
        int ar[] = {1, 2, 41, 52, 84};
        int br[] = {1, 2, 41, 52, 67};
        int cr[] = {1, 2, 41, 52, 67, 85};

        mergeThreeSorted(ar, br, cr);
    }

    static void mergeThreeSorted(int A[], int B[], int C[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < A.length && j < B.length && k < C.length) {
            int a = A[i];
            int b = B[j];
            int c = C[k];

            if (a <= b && a <= c) {
                list.add(a);
                i++;
            } else if (b <= a && b <= c) {
                list.add(b);
                j++;
            } else {
                list.add(c);
                k++;
            }
        }
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                list.add(A[i]);
                i++;
            } else {
                list.add(B[j]);
                j++;
            }
        }
        while (j < B.length && k < C.length) {
            if (B[j] < C[k]) {
                list.add(B[j]);
                j++;
            } else {
                list.add(C[k]);
                k++;
            }
        }
        while (i < A.length && k < C.length) {
            if (A[i] < C[k]) {
                list.add(A[i]);
                i++;
            } else {
                list.add(C[k]);
                k++;
            }
        }

        while (i < A.length) {
            list.add(A[i]);
            i++;
        }
        while (j < B.length) {
            list.add(B[j]);
            j++;
        }
        while (k < C.length) {
            list.add(C[k]);
            k++;
        }
        for (Integer x : list) {
            System.out.print(x + " ");
        }

    }
}
