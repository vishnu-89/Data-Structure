package com.geeks.ds.arrays;

public class MoveZerosToEnd {
    public static void main(String [] args) {
        int [] ar = {4, 0, 20, 0, 100,200};
        int len = ar.length;

        System.out.println("Before moving zero to an end : ");
        for(int i = 0 ; i < ar.length ; i++) {
            System.out.print(ar[i]+" ");
        }

        moveZeroToEnd(ar, len);
        System.out.println();

        System.out.println("After moving zero to an end : ");
        for(int i = 0 ; i < len ; i++) {
            System.out.print(ar[i]+" ");
        }
    }

    private static void moveZeroToEnd(int[] ar, int len) {
        int index = 0;
        for(int i = 0 ; i < len ;i++) {
            if(ar[i] != 0) {
                ar[index++] = ar[i];
            }
        }
        while (index < len) {
            ar[index++] = 0;
        }

    }
}
