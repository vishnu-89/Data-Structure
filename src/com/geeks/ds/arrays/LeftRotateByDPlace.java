package com.geeks.ds.arrays;

public class LeftRotateByDPlace {

    public static void main(String [] args) {
        int [] ar = {4, 0, 20, 0, 100,200};
        int len = ar.length;
        int rotate  = 2;
        System.out.println("Array before left rotate : ");
        for(int i = 0 ; i < ar.length ; i++) {
            System.out.print(ar[i]+" ");
        }

        reverse(ar, 0, rotate-1);
        reverse(ar, rotate, ar.length-1);
        reverse(ar, 0, ar.length-1);

        System.out.println();

        System.out.println("Array before left rotate by D place : ");
        for(int i = 0 ; i < len ; i++) {
            System.out.print(ar[i]+" ");
        }
    }

    private static void reverse(int[] ar, int l, int r) {

        while( l < r ) {
            int temp = ar[l];
            ar[l] = ar[r];
            ar[r] = temp;
            l++;
            r--;
        }
    }
}
